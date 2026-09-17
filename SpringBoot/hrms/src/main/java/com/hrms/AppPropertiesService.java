package com.hrms;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service
public class AppPropertiesService {
    @Value("${hrms.company.name}")
    private String companyName;
    @Value("${hrms.company.location}")
    private String companyLocation;
    @Value("${hrms.support.email}")
    private String companyEmail;
    @Value("${hrms.office.timing}")
    private String officeTiming;
    public String getCompanyDetails(){
        return """
                Company Details<br>
                ------------------------<br>
                ------------------------<br>
                Company Name : %s<br>
                Company Location : %s<br>
                Company Email : %s<br>
                Office Timing : %s<br>
                """.formatted(companyName,companyLocation,companyEmail,officeTiming );
    }
}
