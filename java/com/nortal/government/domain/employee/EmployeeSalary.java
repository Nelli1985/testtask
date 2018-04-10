package com.nortal.government.domain.employee;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "employee_salary")
public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSalarySequenceGenerator")
    @SequenceGenerator(name = "employeeSalarySequenceGenerator", sequenceName = "employee_salary_seq", allocationSize = 1)
    private Long id;
    private Long employeeId;
    private LocalDate assignDate;
    @Column(precision = 10, scale = 2)
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
        EmployeeSalary that = (EmployeeSalary) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(employeeId, that.employeeId) &&
            Objects.equals(assignDate, that.assignDate) &&
            Objects.equals(salary, that.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, assignDate, salary);
    }

    @Override
    public String toString() {
        return "EmployeeSalary{" +
            "id=" + id +
            ", employeeId=" + employeeId +
            ", assignDate=" + assignDate +
            ", salary=" + salary +
            '}';
    }
}
