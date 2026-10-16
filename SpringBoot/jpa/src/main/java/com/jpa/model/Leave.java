package com.jpa.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "leave_requests")
public class Leave
{
    @Id
    private String leaveId;
    private String employeeId;
    private String leaveType;
    private int leaveDays;
    private String reason;
    public Leave()
    {
    }
    public String getLeaveId()
    {
        return leaveId;
    }
    public void setLeaveId(String leaveId)
    {
        this.leaveId = leaveId;
    }
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
    public String getReason()
    {
        return reason;
    }
    public void setReason(String reason)
    {
        this.reason = reason;
    }
}