package com.jpa.exception;
public class LeaveRuleException extends RuntimeException
{
    public LeaveRuleException(String message)
    {
        super(message);
    }
}