package com.nortal.government.service.dto.employee;

import java.time.LocalDate;

import com.nortal.government.domain.employee.ExecutiveEmployee;

public class ExecutiveEmployeeDTO {
    private Long id;
    private String employeeName;
    private LocalDate hireDate;
    private String position;
    private String email;
    private String phoneNumber;
    private String parkingSpaceCode;

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

    public static ExecutiveEmployeeDTO of(ExecutiveEmployee e) {
        ExecutiveEmployeeDTO dto = new ExecutiveEmployeeDTO();
        dto.setId(e.getId());
        dto.setEmployeeName(e.getEmployeeName());
        dto.setHireDate(e.getHireDate());
        dto.setPosition(e.getPosition());
        dto.setEmail(e.getEmail());
        dto.setPhoneNumber(e.getPhoneNumber());
        dto.setParkingSpaceCode(e.getParkingSpaceCode());
        return dto;
    }


}
