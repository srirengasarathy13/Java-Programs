package com.hrms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HRMSEmployeeController {

    private final HRMSEmployeeService service;

    public HRMSEmployeeController(HRMSEmployeeService service) {
        this.service = service;
    }

    @GetMapping("/emp")
    public String employee(Model model) {

        Employee employee = service.getEmployeeInformation();

        model.addAttribute("employee", employee);

        return "employee";
    }
}