package com.hrms;
import org.springframework.stereotype.Service;;
@Service 
public class EmployeeService {
    public  String getEmployeeInfo(String empId){
        if("EMP101".equals(empId)){
            return """
            HRMS Employee Details<br>
            ---------------------------------<br>
            ---------------------------------<br>
            Employee ID   : EMP101<br>
            Employee Name : R Sri Rengasarathy<br>
            Department    : IT<br>
            Designation   : Java Developer<br>
                    """;
        }
        return "Employee Not Found !";
    }
}
