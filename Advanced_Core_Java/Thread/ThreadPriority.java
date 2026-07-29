/**
 * EmployeeMultipleThreads
 */
class EmployeeRegister extends Thread{
    @Override
    public void run(){
        System.out.println("HR : Registering Employees...");
    }
}

class Payroll extends Thread{
    @Override
    public void run(){
        System.out.println("Payroll : Processing Salary...");
    }
}

class Attendance extends Thread{
    @Override
    public void run(){
        System.out.println("Attendance : Creating Attendance Record...");
    }
}

public class ThreadPriority {
   public static void main(String[] args) {
    EmployeeRegister hr = new EmployeeRegister();
    Payroll payroll = new Payroll();
    Attendance attendance = new Attendance();    
    hr.setPriority(10);
    payroll.setPriority(8);
    attendance.setPriority(1);
    hr.start();
    payroll.start();
    attendance.start();
   }

}