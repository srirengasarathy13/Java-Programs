package com.jpa;

import org.springframework.stereotype.Service;

@Service
public class EmployeeAttendanceService {

    private final EmployeeAttendanceRepository repository;

    public EmployeeAttendanceService(
            EmployeeAttendanceRepository repository) {

        this.repository = repository;
    }

    public EmployeeAttendance checkIn(EmployeeAttendance attendance) {

        if (repository.existsById(attendance.getEmployeeId())) {
            throw new RuntimeException(
                    "Employee already checked in today");
        }

        attendance.setStatus("PENDING");

        return repository.save(attendance);
    }

    public EmployeeAttendance checkOut(
            String employeeId,
            String checkOutTime) {

        EmployeeAttendance attendance =
                repository.findById(employeeId).orElse(null);

        if (attendance == null) {
            throw new RuntimeException(
                    "Employee has not checked in");
        }

        if (attendance.getCheckOutTime() != null) {
            throw new RuntimeException(
                    "Employee already checked out");
        }

        String[] in = attendance.getCheckInTime().split(":");
        String[] out = checkOutTime.split(":");

        int inHour = Integer.parseInt(in[0]);
        int inMinute = Integer.parseInt(in[1]);

        int outHour = Integer.parseInt(out[0]);
        int outMinute = Integer.parseInt(out[1]);

        int checkInMinutes = inHour * 60 + inMinute;
        int checkOutMinutes = outHour * 60 + outMinute;

        if (checkOutMinutes < checkInMinutes) {
            throw new RuntimeException(
                    "Check-out cannot be before check-in");
        }

        int difference = checkOutMinutes - checkInMinutes;

        int hours = difference / 60;
        int minutes = difference % 60;

        attendance.setCheckOutTime(checkOutTime);

        attendance.setWorkingHours(
                hours + "h " + minutes + "m");

        if (hours >= 8) {
            attendance.setStatus("PRESENT");
        } else if (hours >= 4) {
            attendance.setStatus("HALF DAY");
        } else {
            attendance.setStatus("ABSENT");
        }

        return repository.save(attendance);
    }

    public EmployeeAttendance getAttendance(
            String employeeId) {

        return repository.findById(employeeId).orElse(null);
    }

    public java.util.List<EmployeeAttendance> getDailyAttendance(
            String date) {

        return repository.findAll()
                .stream()
                .filter(a -> a.getAttendanceDate().equals(date))
                .toList();
    }
}