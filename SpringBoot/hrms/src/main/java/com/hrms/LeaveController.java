package com.hrms;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController 
public class LeaveController {
    private final LeaveService leaveService;
    public LeaveController(LeaveService leaveService){
        this.leaveService = leaveService;
    }

    @GetMapping("/leave")
    public String getLeaveDetails(@RequestParam String empId){
        return leaveService.getLeaveBalance(empId);
    }
}
