package Advanced_Core_Java.Callable;

import java.util.concurrent.*;

class EmployeeProfileTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);

        return """
                ===============================
                Employee Profile
                ===============================
                Employee ID   : EMP1001
                Name          : Raj Kumar
                Department    : SAP
                Designation   : Software Engineer
                Status        : Active
                ===============================
                """;
    }
}

class ProjectAllocationTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2500);

        return """
                ===============================
                Project Allocation
                ===============================
                Project Name  : HRMS Portal
                Role          : Java Developer
                Team          : Development
                Manager       : Ganesh
                ===============================
                """;
    }
}

class TrainingHistoryTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1500);

        return """
                ===============================
                Training History
                ===============================
                Java Basics        : Completed
                Spring Boot        : Completed
                SQL                : Completed
                AWS Fundamentals   : In Progress
                ===============================
                """;
    }
}

class AssetAllocationTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1800);

        return """
                ===============================
                Asset Allocation
                ===============================
                Laptop     : Dell Latitude
                Monitor    : Dell 24"
                Mouse      : Logitech
                Employee ID Card : Issued
                ===============================
                """;
    }
}

class PerformanceRatingTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(2200);

        return """
                ===============================
                Performance Rating
                ===============================
                Communication : 4.5/5
                Technical Skill: 4.8/5
                Team Work      : 4.7/5
                Overall Rating : 4.7/5
                ===============================
                """;
    }
}


public class EmployeeManagementCallable{

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Future<String> profileFuture =
                executor.submit(new EmployeeProfileTask());

        Future<String> projectFuture =
                executor.submit(new ProjectAllocationTask());

        Future<String> trainingFuture =
                executor.submit(new TrainingHistoryTask());

        Future<String> assetFuture =
                executor.submit(new AssetAllocationTask());

        Future<String> performanceFuture =
                executor.submit(new PerformanceRatingTask());

        System.out.println("=========================================");
        System.out.println("      HRMS EMPLOYEE DASHBOARD");
        System.out.println("=========================================");
        System.out.println("Generating reports...\n");

        try {

            System.out.println(profileFuture.get());

            System.out.println(projectFuture.get());

            System.out.println(trainingFuture.get());

            System.out.println(assetFuture.get());

            System.out.println(performanceFuture.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        System.out.println("All HRMS reports generated successfully.");
    }
}
