package com.nortal.government.web.rest;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import com.codahale.metrics.annotation.Timed;

import com.nortal.government.domain.employee.ExecutiveEmployee;
import com.nortal.government.domain.employee.EmployeeBonus;
import com.nortal.government.service.EmployeeBonusService;
import com.nortal.government.service.EmployeeService;
import com.nortal.government.service.dto.employee.ExecutiveEmployeeDTO;
import com.nortal.government.service.dto.employee.EmployeeBonusDTO;

import io.github.jhipster.web.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/executive-employees")
public class ExecutiveEmployeeResource {
    private final Logger log = LoggerFactory.getLogger(ExecutiveEmployeeResource.class);

    private final EmployeeService employeeService;
    private final EmployeeBonusService employeeBonusService;

    public ExecutiveEmployeeResource(EmployeeService employeeService EmployeeBonusService employeeBonusService) 
    {
        this.employeeService = employeeService;
        this.employeeBonusService = employeeBonusService;
    }

    @GetMapping("/{id}")
    @Timed
    public ResponseEntity<ExecutiveEmployeeDTO> getEmployee(@PathVariable Long id) {
        log.debug("REST request to get Employee : {}", id);
        ExecutiveEmployee employee = (ExecutiveEmployee) employeeService.findOne(id);
        ExecutiveEmployeeDTO dto = ExecutiveEmployeeDTO.of(employee);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dto));
    }

    @GetMapping("/{id}/bonuses")
    @Timed
    public ResponseEntity<Set<EmployeeBonusDTO>> getEmployeeBonuses(@PathVariable Long id) {
        log.debug("REST request to get Bonuses for Employee : {}", id);
        Set<EmployeeBonus> bonuses = employeeBonusService.findByEmployeeIdAndWithinLastYear(id);
        Set<EmployeeBonusDTO> dtos = bonuses.stream().map(EmployeeBonusDTO::of).collect(Collectors.toSet());
        return ResponseEntity.ok().body(dtos);
    }
}
