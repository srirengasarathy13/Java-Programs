package com.intg.controller;
import com.intg.model.Leave;
import com.intg.model.LeaveRequest;
import com.intg.service.LeaveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/leaves")
public class LeaveController
{
    private final LeaveService leaveService;
    public LeaveController(LeaveService leaveService)
    {
        this.leaveService = leaveService;
    }
    @PostMapping("/apply")
    public ResponseEntity<Leave> applyLeave(@Valid @RequestBody LeaveRequest request)
    {
        Leave savedLeave = leaveService.applyLeave(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLeave);
    }
    @GetMapping("/{leaveId}")
    public ResponseEntity<Leave> getLeaveById(@PathVariable String leaveId)
    {
        return ResponseEntity.ok(leaveService.getLeaveById(leaveId));
    }
    @GetMapping
    public ResponseEntity<List<Leave>> getAllLeaves()
    {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }
}