package com.nortal.government.domain.employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;

import com.nortal.government.domain.employee.enumeration.EmployeeType;

@Entity
@Table(name = "employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeSequenceGenerator")
    @SequenceGenerator(name = "employeeSequenceGenerator", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;
    private String employeeName;
    private LocalDate hireDate;
    @Enumerated(EnumType.STRING)
    private EmployeeType type;
    private String position;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
            Objects.equals(employeeName, employee.employeeName) &&
            Objects.equals(hireDate, employee.hireDate) &&
            type == employee.type &&
            Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeName, hireDate, type, position);
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", employeeName='" + employeeName + '\'' +
            ", hireDate=" + hireDate +
            ", type=" + type +
            ", position='" + position + '\'' +
            '}';
    }
}
