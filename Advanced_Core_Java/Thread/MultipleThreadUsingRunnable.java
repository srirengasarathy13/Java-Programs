public class MultipleThreadUsingRunnable {
   public static void main(String[] args) {
    EmployeeRegisterThread registeTask = new EmployeeRegisterThread();
    PayrollThread payrollTask = new PayrollThread();
    AttendanceThread attendanceTask = new AttendanceThread();
    Thread register = new Thread(registeTask);
    Thread payroll = new Thread(payrollTask);
    Thread attendance = new Thread(attendanceTask);
    register.start();
    payroll.start();
    attendance.start();
   }
}

class EmployeeRegisterThread implements Runnable{
    @Override
    public void run(){
        System.out.println("HR : Registering Employees...");
    }
}

class PayrollThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Payroll : Processing Salary...");
    }
}

class AttendanceThread implements Runnable{
    @Override
    public void run(){
        System.out.println("Attendance : Creating Attendance Record...");
    }
}