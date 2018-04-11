package com.nortal.government.service;

import java.util.Set;

import com.nortal.government.domain.employee.EmployeeBonus;

public interface EmployeeBonusService {

    EmployeeBonus save(EmployeeBonus employeeBonus);

    EmployeeBonus findOne(Long id);

    Set<EmployeeBonus> findByEmployeeIdAndWithinLastYear(Long employeeId);

    void delete(Long id);
}
