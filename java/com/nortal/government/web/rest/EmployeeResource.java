package com.nortal.government.web.rest;

import java.util.List;

import com.codahale.metrics.annotation.Timed;

import com.nortal.government.domain.employee.Employee;
import com.nortal.government.service.EmployeeService;
import com.nortal.government.web.rest.util.PaginationUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeResource {
    private final Logger log = LoggerFactory.getLogger(EmployeeResource.class);

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @Timed
    public ResponseEntity<List<Employee>> getAllEmployees(Pageable pageable) {
        log.debug("REST request to get a page of Employees");
        Page<Employee> page = employeeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/employees");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
