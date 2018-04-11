package com.nortal.government.repository.employee;

import java.time.LocalDate;
import java.util.Set;

import com.nortal.government.domain.employee.EmployeeBonus;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the EmployeeBonus entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmployeeBonusRepository extends JpaRepository<EmployeeBonus, Long> {
    Set<EmployeeBonus> findByEmployeeIdAndAssignDateGreaterThanEqual(Long employeeId, LocalDate minBonusDate);
}
