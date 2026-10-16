package com.jpa.repository;
import com.jpa.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LeaveRepository
        extends JpaRepository<Leave, String>
{
}