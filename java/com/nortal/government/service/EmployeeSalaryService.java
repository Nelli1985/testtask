package com.nortal.government.service;

import java.util.Set;

import com.nortal.government.domain.employee.EmployeeSalary;

public interface EmployeeSalaryService {

    EmployeeSalary save(EmployeeSalary employeeSalary);

    EmployeeSalary findOne(Long id);

    Set<EmployeeSalary> findByEmployeeIdAndWithinLastYear(Long employeeId);

    void delete(Long id);
}
