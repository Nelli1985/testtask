package com.nortal.government.service.impl;

import java.time.LocalDate;
import java.util.Set;

import com.nortal.government.domain.employee.EmployeeBonus;
import com.nortal.government.repository.employee.EmployeeBonusRepository;
import com.nortal.government.service.EmployeeBonusService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeBonusServiceImpl implements EmployeeBonusService {

    private final Logger log = LoggerFactory.getLogger(EmployeeBonusServiceImpl.class);

    private final EmployeeBonusRepository employeeBonusRepository;

    public EmployeeBonusServiceImpl(EmployeeBonusRepository employeeBonusRepository) {
        this.employeeBonusRepository = employeeBonusRepository;
    }

    @Override
    public EmployeeBonus save(EmployeeBonus employeeBonus) {
        log.debug("Request to save EmployeeBonus : {}", employeeBonus);
        return employeeBonusRepository.save(employeeBonus);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeBonus findOne(Long id) {
        log.debug("Request to get EmployeeBonus : {}", id);
        return employeeBonusRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Set<EmployeeBonus> findByEmployeeIdAndWithinLastYear(Long employeeId) {
        log.debug("Request to get EmployeeBonuses for employeeId : {}", employeeId);
        return employeeBonusRepository.findByEmployeeIdAndAssignDateGreaterThanEqual(employeeId, LocalDate.now().minusYears(1L));
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete EmployeeBonus : {}", id);
        employeeBonusRepository.delete(id);
    }
}
