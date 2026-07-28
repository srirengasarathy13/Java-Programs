class AuthenticationThread extends Thread{
    @Override
    public void run(){
        System.out.println("Authenticating Employee...");
    }
}

class AttendanceThread extends Thread{
    @Override
    public void run(){
        System.out.println("Loading Attendance...");
    }
}

class EmailThread extends Thread{
    @Override
    public void run(){
        System.out.println("Sending Mail...");
    }
}

class SalaryThread extends Thread{
    @Override
    public void run(){
        System.out.println("Loading Salary Information...");
    }
}

public class EmployeePortal {
        public static void main(String[] args) {
            AuthenticationThread auth = new AuthenticationThread();
            AttendanceThread attendance = new AttendanceThread();
            EmailThread email = new EmailThread();
            SalaryThread salary = new SalaryThread();
            auth.start();
            attendance.start();
            email.start();
            salary.start();
        }
}
