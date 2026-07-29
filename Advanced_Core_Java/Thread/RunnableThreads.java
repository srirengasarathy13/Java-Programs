class EmployeeRegistration implements Runnable{
    @Override
    public void run(){
        System.out.println("Registering Employee...");
    }
}

public class RunnableThreads {
    public static void main(String[] args) {
        EmployeeRegistration emp = new EmployeeRegistration();
        Thread thread = new Thread(emp);
        thread.start();
    }
}
