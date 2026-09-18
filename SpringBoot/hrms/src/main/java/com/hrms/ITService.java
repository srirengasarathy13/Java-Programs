package com.hrms;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
@Service 
public class ITService {
    @Value("${hrms.company.name}")
    private String companyName;
    @Value("${hrms.company.location}")
    private String companyLocation;
    @Value("${hrms.itsupport.email}")
    private String itSupportEmail;
    @Value("${hrms.support.department}")
    private String supportDepartment;
    public String getItSupport(String empId, String requestType, String priority){
        return """
                HRMS Support Request<br>
                ------------------------------------<br>
                ------------------------------------<br>
                Employee Id : %s<br>
                Company Name : %s<br>
                Company Location : %s<br>
                Request Type : %s<br>
                Priority : %s<br>
                Support Team : %s<br>
                Support Email : %s<br><br>
                Request Submitted Successfully !
                """.formatted(empId,companyName,companyLocation,requestType,priority,itSupportEmail,supportDepartment);
    }
}