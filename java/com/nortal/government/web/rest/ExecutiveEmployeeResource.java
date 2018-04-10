package com.nortal.government.web.rest;

import java.util.Optional;

import com.codahale.metrics.annotation.Timed;

import com.nortal.government.domain.employee.ExecutiveEmployee;
import com.nortal.government.service.EmployeeService;
import com.nortal.government.service.dto.employee.ExecutiveEmployeeDTO;

import io.github.jhipster.web.util.ResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/executive-employees")
public class ExecutiveEmployeeResource {
    private final Logger log = LoggerFactory.getLogger(ExecutiveEmployeeResource.class);

    private final EmployeeService employeeService;

    public ExecutiveEmployeeResource(EmployeeService employeeService
    ) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    @Timed
    public ResponseEntity<ExecutiveEmployeeDTO> getEmployee(@PathVariable Long id) {
        log.debug("REST request to get Employee : {}", id);
        ExecutiveEmployee employee = (ExecutiveEmployee) employeeService.findOne(id);
        ExecutiveEmployeeDTO dto = ExecutiveEmployeeDTO.of(employee);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(dto));
    }

}
