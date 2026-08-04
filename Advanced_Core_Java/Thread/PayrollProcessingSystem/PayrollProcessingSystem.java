package Advanced_Core_Java.Thread.PayrollProcessingSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PayrollTask implements Runnable {

    private String employeeId;
    private String employeeName;

    PayrollTask(String employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    @Override
    public void run() {

        System.out.println("-------------------------------------");
        System.out.println("Thread Name : " + Thread.currentThread().getName());
        System.out.println("Processing Salary...");

        try {
            Thread.sleep(1000); 
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Salary Processed Successfully.");
        System.out.println("-------------------------------------");
    }
}

public class PayrollProcessingSystem {

    public static void main(String[] args) {

        
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new PayrollTask("EMP1001", "Rama"));
        executor.execute(new PayrollTask("EMP1002", "David"));
        executor.execute(new PayrollTask("EMP1003", "Anbu"));
        executor.execute(new PayrollTask("EMP1004", "Abi"));
        executor.execute(new PayrollTask("EMP1005", "Kevin"));
        executor.shutdown();
    }
}
