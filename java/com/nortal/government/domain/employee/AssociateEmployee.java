package com.nortal.government.domain.employee;

import java.util.Objects;
import javax.persistence.*;

import com.nortal.government.domain.employee.enumeration.EmployeeType;

@Entity
@Table(name = "associate_employee")
@PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "id")
public class AssociateEmployee extends Employee {
    private static final long serialVersionUID = 1L;

    private String favouriteTool;
    private String coffeePreference;

    public AssociateEmployee() {
        setType(EmployeeType.ASSOCIATE);
    }

    public String getFavouriteTool() {
        return favouriteTool;
    }

    public void setFavouriteTool(String favouriteTool) {
        this.favouriteTool = favouriteTool;
    }

    public String getCoffeePreference() {
        return coffeePreference;
    }

    public void setCoffeePreference(String coffeePreference) {
        this.coffeePreference = coffeePreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AssociateEmployee that = (AssociateEmployee) o;
        return Objects.equals(favouriteTool, that.favouriteTool) &&
            Objects.equals(coffeePreference, that.coffeePreference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), favouriteTool, coffeePreference);
    }

    @Override
    public String toString() {
        return "AssociateEmployee{" + getId() + '}';
    }
}
