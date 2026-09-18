package com.hrms;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController 
public class ITController {
    private final ITService itService;
    public ITController(ITService itService){
        this.itService = itService;
    }
    @GetMapping("/support/request")
    public String requestITSupport(@RequestParam String empId, @RequestParam String requestType, @RequestParam String priority) {
        return itService.getItSupport(empId, requestType, priority);
    }
    
}
