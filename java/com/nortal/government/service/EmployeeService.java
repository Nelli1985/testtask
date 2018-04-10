package com.nortal.government.service;

import com.nortal.government.domain.employee.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Employee save(Employee employee);

    /**
     * Get all the employees.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<Employee> findAll(Pageable pageable);

    Employee findOne(Long id);

    void delete(Long id);

}
