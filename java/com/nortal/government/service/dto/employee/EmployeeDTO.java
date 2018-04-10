package com.nortal.government.service.dto.employee;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.nortal.government.domain.employee.Employee;
import com.nortal.government.domain.employee.EmployeeSalary;
import com.nortal.government.domain.employee.enumeration.EmployeeType;

public class EmployeeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String employeeName;
    private LocalDate hireDate;
    private EmployeeType type;
    private String position;
    private Set<EmployeeSalary> salaries;
    private String sss = "sssssssssss";
    private List<String> salariesList = Arrays.asList("asda", "#");

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

    public Set<EmployeeSalary> getSalaries() {
        return salaries;
    }

    public void setSalaries(Set<EmployeeSalary> salaries) {
        this.salaries = salaries;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EmployeeDTO employee = (EmployeeDTO) o;
        if (employee.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", employeeName='" + getEmployeeName() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", type='" + getType() + "'" +
            ", position='" + getPosition() + "'" +
            ", salaries='" + getSalaries() + "'" +
            "}";
    }

    public List<String> getSalariesList() {
        return salariesList;
    }

    public void setSalariesList(List<String> salariesList) {
        this.salariesList = salariesList;
    }

    public String getSss() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss = sss;
    }

    public static EmployeeDTO of(Employee employee) {
        if (employee == null) {
            return null;
        }
        EmployeeDTO d = new EmployeeDTO();
        d.setEmployeeName(employee.getEmployeeName());
        d.setHireDate(employee.getHireDate());
        d.setId(employee.getId());
        d.setPosition(employee.getPosition());
        d.setType(employee.getType());
        return d;
    }
}
