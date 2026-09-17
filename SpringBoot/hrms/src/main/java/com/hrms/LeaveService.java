package com.hrms;
import org.springframework.stereotype.Service;
@Service
public class LeaveService {
    public String getLeaveBalance(String empId){
        if("EMP101".equals(empId)){
            return "HRMS Leave Details for "+empId+"<br>"+
                    """
                    -----------------------------------------<br>
                    -----------------------------------------<br>
                    Total leaves : 12<br>
                    Leaves taken : 3<br>
                    Leaves left  : 9<br>
                    """;
        }
        return "Employee Not Found !";
    }
}
