package com.hrms;

import org.springframework.stereotype.Service;

@Service
public class HRMSEmployeeService {

    public Employee getEmployeeInformation() {

        return new Employee(
            "AGNI101",
            "R Sri Rengasarathy",
            "Agnie Consulting",
            "Chennai"
        );
    }
}