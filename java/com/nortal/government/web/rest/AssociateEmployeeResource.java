package com.nortal.government.web.rest;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.codahale.metrics.annotation.Timed;

import com.nortal.government.domain.employee.AssociateEmployee;
import com.nortal.government.domain.employee.EmployeeSalary;
import com.nortal.government.service.EmployeeSalaryService;
import com.nortal.government.service.EmployeeService;
import com.nortal.government.service.dto.employee.AssociateEmployeeDTO;
import com.nortal.government.service.dto.employee.EmployeeSalaryDTO;

import io.github.jhipster.web.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/associate-employees")
public class AssociateEmployeeResource {
    private final Logger log = LoggerFactory.getLogger(AssociateEmployeeResource.class);

    private final EmployeeService employeeService;
    private final EmployeeSalaryService employeeSalaryService;

    public AssociateEmployeeResource(EmployeeService employeeService, EmployeeSalaryService employeeSalaryService) {
        this.employeeService = employeeService;
        this.employeeSalaryService = employeeSalaryService;
    }

    @GetMapping("/{id}")
    @Timed
    public ResponseEntity<AssociateEmployeeDTO> getEmployee(@PathVariable Long id) {
        log.debug("REST request to get Employee : {}", id);
        AssociateEmployee employee = (AssociateEmployee) employeeService.findOne(id);
        AssociateEmployeeDTO dto = AssociateEmployeeDTO.of(employee);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dto));
    }

    @GetMapping("/{id}/salaries")
    @Timed
    public ResponseEntity<Set<EmployeeSalaryDTO>> getEmployeeSalaries(@PathVariable Long id) {
        log.debug("REST request to get Salaries for Employee : {}", id);
        Set<EmployeeSalary> salaries = employeeSalaryService.findByEmployeeIdAndWithinLastYear(id);
        Set<EmployeeSalaryDTO> dtos = salaries.stream().map(EmployeeSalaryDTO::of).collect(Collectors.toSet());
        return ResponseEntity.ok().body(dtos);
    }
}
