package com.intg.repository;
import com.intg.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryfn
        extends JpaRepository<Employee, String>
{
}
 