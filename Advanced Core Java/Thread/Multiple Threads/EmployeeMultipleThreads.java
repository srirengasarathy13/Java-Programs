/**
 * EmployeeMultipleThreads
 */
class EmployeeRegisterThread extends Thread{
    @Override
    public void run(){
        System.out.println("HR : Registering Employees...");
    }
}

class PayrollThread extends Thread{
    @Override
    public void run(){
        System.out.println("Payroll : Processing Salary...");
    }
}

class AttendanceThread extends Thread{
    @Override
    public void run(){
        System.out.println("Attendance : Creating Attendance Record...");
    }
}

public class EmployeeMultipleThreads {
   public static void main(String[] args) {
    EmployeeRegisterThread hr = new EmployeeRegisterThread();
    PayrollThread payroll = new PayrollThread();
    AttendanceThread attendance = new AttendanceThread();
    hr.start();
    payroll.start();
    attendance.start();
   }

}