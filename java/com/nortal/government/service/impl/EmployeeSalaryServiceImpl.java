package com.nortal.government.service.impl;

import java.time.LocalDate;
import java.util.Set;

import com.nortal.government.domain.employee.EmployeeSalary;
import com.nortal.government.repository.employee.EmployeeSalaryRepository;
import com.nortal.government.service.EmployeeSalaryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

    private final Logger log = LoggerFactory.getLogger(EmployeeSalaryServiceImpl.class);

    private final EmployeeSalaryRepository employeeSalaryRepository;

    public EmployeeSalaryServiceImpl(EmployeeSalaryRepository employeeSalaryRepository) {
        this.employeeSalaryRepository = employeeSalaryRepository;
    }

    @Override
    public EmployeeSalary save(EmployeeSalary employeeSalary) {
        log.debug("Request to save EmployeeSalary : {}", employeeSalary);
        return employeeSalaryRepository.save(employeeSalary);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeSalary findOne(Long id) {
        log.debug("Request to get EmployeeSalary : {}", id);
        return employeeSalaryRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<EmployeeSalary> findByEmployeeIdAndWithinLastYear(Long employeeId) {
        log.debug("Request to get EmployeeSalaries for employeeId : {}", employeeId);
        return employeeSalaryRepository.findByEmployeeIdAndAssignDateGreaterThanEqual(employeeId, LocalDate.now().minusYears(1L));
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete EmployeeSalary : {}", id);
        employeeSalaryRepository.delete(id);
    }
}
