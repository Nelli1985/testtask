package com.nortal.government.service.dto.employee;

import java.time.LocalDate;

import com.nortal.government.domain.employee.AssociateEmployee;

public class AssociateEmployeeDTO {
    private Long id;
    private String employeeName;
    private LocalDate hireDate;
    private String position;
    private String favouriteTool;
    private String coffeePreference;

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public static AssociateEmployeeDTO of(AssociateEmployee e) {
        AssociateEmployeeDTO dto = new AssociateEmployeeDTO();
        dto.setId(e.getId());
        dto.setEmployeeName(e.getEmployeeName());
        dto.setHireDate(e.getHireDate());
        dto.setPosition(e.getPosition());
        dto.setFavouriteTool(e.getFavouriteTool());
        dto.setCoffeePreference(e.getCoffeePreference());
        return dto;
    }


}
