package com.nortal.government.service.dto.employee;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.nortal.government.domain.employee.EmployeeSalary;

public class EmployeeSalaryDTO {
    private Long id;
    private LocalDate assignDate;
    private BigDecimal salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(LocalDate assignDate) {
        this.assignDate = assignDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public static EmployeeSalaryDTO of(EmployeeSalary sal) {
        EmployeeSalaryDTO dto = new EmployeeSalaryDTO();
        dto.setId(sal.getId());
        dto.setAssignDate(sal.getAssignDate());
        dto.setSalary(sal.getSalary());
        return dto;
    }
}
