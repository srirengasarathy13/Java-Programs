package com.hrms;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController 
public class AppPropertiesController {
    private final AppPropertiesService appPropertiesService;
    public AppPropertiesController(AppPropertiesService appPropertiesService){
        this.appPropertiesService = appPropertiesService;
    }
    @GetMapping("/company")
    public String getCompany(){
        return appPropertiesService.getCompanyDetails();
    }
}
