package com.nortal.government.service.dto.employee;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.nortal.government.domain.employee.EmployeeBonus;

public class EmployeeBonusDTO {
    private Long id;
    private LocalDate bonusDate;
    private BigDecimal bonus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBonusDate() {
        return bonusDate;
    }

    public void setBonusDate(LocalDate bonusDate) {
        this.bonusDate = bonusDate;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public static EmployeeBonusDTO of(EmployeeBonus bon) {
        EmployeeBonusDTO dto = new EmployeeBonusDTO();
        dto.setId(bon.getId());
        dto.setBonusDate(bon.getBonusDate());
        dto.setBonus(bon.getBonus());
        return dto;
    }
}
