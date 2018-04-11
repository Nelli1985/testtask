package com.nortal.government.domain.employee;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "employee_bonus")
public class EmployeeBonus implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeBonusSequenceGenerator")
    @SequenceGenerator(name = "employeeBonusSequenceGenerator", sequenceName = "employee_bonus_seq", allocationSize = 1)
    private Long id;
    private Long employeeId;
    private LocalDate bonusDate;
    @Column(precision = 10, scale = 2)
    private BigDecimal bonusAmount; //Maybe this should be bonus_amount ?

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
        return bonusAmount;
    }

    public void setBonus(BigDecimal bonusAmount) {
        this.bonus = bonusAmount; //Or maybe this one should be bonus_amount?
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeBonus that = (EmployeeBonus) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(employeeId, that.employeeId) &&
            Objects.equals(bonusDate, that.bonusDate) &&
            Objects.equals(bonus, that.bonusAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, bonusDate, bonus);
    }

    @Override
    public String toString() {
        return "EmployeeBonus{" +
            "id=" + id +
            ", employeeId=" + employeeId +
            ", bonusDate=" + bonusDate +
            ", bonus=" + bonus +
            '}';
    }
}
