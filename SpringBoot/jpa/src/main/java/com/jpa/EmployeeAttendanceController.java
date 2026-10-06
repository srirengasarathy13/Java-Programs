package com.jpa;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendance")
public class EmployeeAttendanceController {

    private final EmployeeAttendanceService service;

    public EmployeeAttendanceController(
            EmployeeAttendanceService service) {

        this.service = service;
    }

    @PostMapping("/check-in")
    public EmployeeAttendance checkIn(
            @RequestBody EmployeeAttendance attendance) {

        return service.checkIn(attendance);
    }

    @PutMapping("/check-out/{employeeId}")
    public EmployeeAttendance checkOut(
            @PathVariable String employeeId,
            @RequestParam String checkOutTime) {

        return service.checkOut(
                employeeId,
                checkOutTime);
    }

    @GetMapping("/{employeeId}")
    public EmployeeAttendance getAttendance(
            @PathVariable String employeeId) {

        return service.getAttendance(employeeId);
    }

    @GetMapping("/date/{date}")
    public java.util.List<EmployeeAttendance> getDailyAttendance(
            @PathVariable String date) {

        return service.getDailyAttendance(date);
    }
}