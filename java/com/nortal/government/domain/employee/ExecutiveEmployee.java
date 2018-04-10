package com.nortal.government.domain.employee;

import java.util.Objects;
import javax.persistence.*;

import com.nortal.government.domain.employee.enumeration.EmployeeType;

@Entity
@Table(name = "executive_employee")
@PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "id")
public class ExecutiveEmployee extends Employee {
    private static final long serialVersionUID = 1L;

    private String email;
    private String phoneNumber;
    private String parkingSpaceCode;

    public ExecutiveEmployee() {
        setType(EmployeeType.EXECUTIVE);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParkingSpaceCode() {
        return parkingSpaceCode;
    }

    public void setParkingSpaceCode(String parkingSpaceCode) {
        this.parkingSpaceCode = parkingSpaceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ExecutiveEmployee that = (ExecutiveEmployee) o;
        return Objects.equals(email, that.email) &&
            Objects.equals(phoneNumber, that.phoneNumber) &&
            Objects.equals(parkingSpaceCode, that.parkingSpaceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), email, phoneNumber, parkingSpaceCode);
    }

    @Override
    public String toString() {
        return "ExecutiveEmployee{" + getId() + '}';
    }
}
