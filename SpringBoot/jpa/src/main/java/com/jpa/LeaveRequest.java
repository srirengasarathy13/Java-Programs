package com.jpa;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LeaveRequest {

    @NotBlank
    private String employeeId;

    @NotBlank
    private String leaveType;

    @Min(1)
    @Max(30)
    private int leaveDays;

    @NotBlank
    @Size(min = 5, max = 200)
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
