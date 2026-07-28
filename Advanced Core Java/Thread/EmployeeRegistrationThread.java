/**
 * EmployeeRegistrationThread
 */
public class EmployeeRegistrationThread extends Thread {

 @Override
 public void run(){
    System.out.println("Employee Registration Started...");
 }
 public static void main(String[] args) {
    EmployeeRegistrationThread registration  = new EmployeeRegistrationThread();
    registration.start();
 }
}