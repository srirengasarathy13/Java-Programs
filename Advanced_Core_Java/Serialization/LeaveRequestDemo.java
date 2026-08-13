package Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LeaveRequestDemo {
    static class LeaveRequest implements Serializable{

        private int requestId;
        private int employeeId;
        private String employeeName;
        private String leaveType;
        private int noOfDays;
        private String status;

       public LeaveRequest( int requestId, int employeeId, String employeeName, String leaveType, int noOfDays,String status){
            this.requestId = requestId;
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.leaveType = leaveType;
            this.noOfDays = noOfDays;
            this.status = status;
       }

       @Override
        public String toString() {
            return "Request ID: " + requestId +
                    "\nEmployee ID: " + employeeId +
                    "\nEmployee Name: " + employeeName +
                    "\nLeave Type: " + leaveType +
                    "\nNumber of Days: " + noOfDays +
                    "\nStatus: " + status;
        }

        public static void main(String[] args) throws Exception {

        LeaveRequest request = new LeaveRequest(
                101,
                1001,
                "Sri",
                "Casual Leave",
                2,
                "Approved"
        );

        
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("C:\\Sri\\Java Programs\\Advanced_Core_Java\\Serialization\\leaveRequest.ser"));

        out.writeObject(request);
        out.close();

        System.out.println("Leave request serialized successfully.");

        
        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("C:\\Sri\\Java Programs\\Advanced_Core_Java\\Serialization\\leaveRequest.ser"));

        LeaveRequest request2 =
                (LeaveRequest) in.readObject();

        in.close();

        System.out.println("\nRetrieved Leave Request:");
        System.out.println(request2);
    }
    }
}
