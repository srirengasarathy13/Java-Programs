package com.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAttendanceRepository
        extends JpaRepository<EmployeeAttendance, String> {

}