package com.nortal.government.repository.employee;

import java.time.LocalDate;
import java.util.Set;

import com.nortal.government.domain.employee.EmployeeSalary;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the EmployeeSalary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalary, Long> {
    Set<EmployeeSalary> findByEmployeeIdAndAssignDateGreaterThanEqual(Long employeeId, LocalDate minAssignDate);
}
