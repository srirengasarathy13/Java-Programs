package com.jpa;

import jakarta.validation.constraints.*;

public class LeaveRequest {

    @NotBlank
    @Pattern(regexp = "EMP[0-9]{4}", message = "Employee ID must be in format EMP followed by 4 digits")
    private String employeeId;

    @NotBlank
    private String leaveType;

    @Min(value = 1, message = "Leave days must be at least 1")
    @Max(value = 30, message = "Leave days cannot exceed 30")
    private int leaveDays;

    @NotBlank
    @Size(min = 5, max = 200, message = "Reason must contain 5 to 200 characters")
    private String reason;

    public LeaveRequest() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
