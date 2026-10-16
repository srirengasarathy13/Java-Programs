package com.jpa.model;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class LeaveRequest
{
    @NotBlank(message = "Employee ID is required")
    @Pattern(regexp = "EMP[0-9]{4}", message = "Employee ID must be like EMP1001")
    private String employeeId;
    @NotBlank(message = "Leave type is required")
    private String leaveType;
    @Min(value = 1, message = "Leave days must be at least 1")
    @Max(value = 30, message = "Leave days cannot exceed 30")
    private int leaveDays;
    @NotBlank(message = "Reason is required")
    @Size(min = 5, max = 200, message = "Reason must contain 5 to 200 characters")
    private String reason;
    public String getEmployeeId()
    {
        return employeeId;
    }
    public void setEmployeeId(String employeeId)
    {
        this.employeeId = employeeId;
    }
    public String getLeaveType()
    {
        return leaveType;
    }
    public void setLeaveType(String leaveType)
    {
        this.leaveType = leaveType;
    }
    public int getLeaveDays()
    {
        return leaveDays;
    }
    public void setLeaveDays(int leaveDays)
    {
        this.leaveDays = leaveDays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }
}