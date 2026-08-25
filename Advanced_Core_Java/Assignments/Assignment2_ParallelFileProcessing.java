package Assignments;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Assignment2_ParallelFileProcessing {

    // ============================================================
    // SalesRecord
    // ============================================================
    static class SalesRecord {

        private final String productName;
        private final double saleAmount;

        public SalesRecord(String productName, double saleAmount) {
            this.productName = productName;
            this.saleAmount = saleAmount;
        }

        public String getProductName() {
            return productName;
        }

        public double getSaleAmount() {
            return saleAmount;
        }

        @Override
        public String toString() {
            return productName + " : ₹" + saleAmount;
        }
    }

    // ============================================================
    // SalesReport
    // ============================================================
    static class SalesReport {

        private final String fileName;
        private final int numberOfRecords;
        private final double totalSales;
        private final double highestSale;
        private final double lowestSale;
        private final double averageSale;

        public SalesReport(
                String fileName,
                int numberOfRecords,
                double totalSales,
                double highestSale,
                double lowestSale,
                double averageSale) {

            this.fileName = fileName;
            this.numberOfRecords = numberOfRecords;
            this.totalSales = totalSales;
            this.highestSale = highestSale;
            this.lowestSale = lowestSale;
            this.averageSale = averageSale;
        }

        public String getFileName() {
            return fileName;
        }

        public int getNumberOfRecords() {
            return numberOfRecords;
        }

        public double getTotalSales() {
            return totalSales;
        }

        public double getHighestSale() {
            return highestSale;
        }

        public double getLowestSale() {
            return lowestSale;
        }

        public double getAverageSale() {
            return averageSale;
        }
    }

    // ============================================================
    // FileProcessor
    // ============================================================
    static class FileProcessor {

        /*
         * Reads a sales file and converts each line into
         * a SalesRecord object.
         *
         * Expected file format:
         *
         * Laptop,75000
         * Mouse,1500
         * Keyboard,2500
         */
        public List<SalesRecord> readFile(String fileName)
                throws IOException {

            List<SalesRecord> records =
                    new ArrayList<>();

            File file = new File(fileName);

            if (!file.exists()) {
                throw new FileNotFoundException(
                        "File not found: " + fileName
                );
            }

            try (BufferedReader reader =
                         new BufferedReader(
                                 new FileReader(file))) {

                String line;

                while ((line = reader.readLine()) != null) {

                    line = line.trim();

                    if (line.isEmpty()) {
                        continue;
                    }

                    String[] parts =
                            line.split(",");

                    if (parts.length != 2) {
                        System.out.println(
                                "Invalid record in "
                                        + fileName
                                        + " : "
                                        + line
                        );

                        continue;
                    }

                    String productName =
                            parts[0].trim();

                    double amount;

                    try {
                        amount =
                                Double.parseDouble(
                                        parts[1].trim()
                                );
                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Invalid sales amount in "
                                        + fileName
                                        + " : "
                                        + line
                        );

                        continue;
                    }

                    records.add(
                            new SalesRecord(
                                    productName,
                                    amount
                            )
                    );
                }
            }

            return records;
        }

        /*
         * Calculates the complete report for one file.
         */
        public SalesReport processFile(String fileName)
                throws IOException {

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> Processing "
                            + fileName
            );

            List<SalesRecord> records =
                    readFile(fileName);

            if (records.isEmpty()) {

                return new SalesReport(
                        fileName,
                        0,
                        0,
                        0,
                        0,
                        0
                );
            }

            double totalSales = 0;
            double highestSale =
                    records.get(0).getSaleAmount();

            double lowestSale =
                    records.get(0).getSaleAmount();

            for (SalesRecord record : records) {

                double amount =
                        record.getSaleAmount();

                totalSales += amount;

                if (amount > highestSale) {
                    highestSale = amount;
                }

                if (amount < lowestSale) {
                    lowestSale = amount;
                }
            }

            double averageSale =
                    totalSales / records.size();

            return new SalesReport(
                    fileName,
                    records.size(),
                    totalSales,
                    highestSale,
                    lowestSale,
                    averageSale
            );
        }
    }

    // ============================================================
    // Version 1 - Runnable
    // ============================================================
    static class SalesCalculationRunnable
            implements Runnable {

        private final String fileName;
        private final FileProcessor processor;

        public SalesCalculationRunnable(
                String fileName,
                FileProcessor processor) {

            this.fileName = fileName;
            this.processor = processor;
        }

        @Override
        public void run() {

            try {

                SalesReport report =
                        processor.processFile(fileName);

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> "
                                + fileName
                                + " completed"
                                + " | Records: "
                                + report.getNumberOfRecords()
                                + " | Total: ₹"
                                + report.getTotalSales()
                );

            } catch (IOException e) {

                System.out.println(
                        Thread.currentThread().getName()
                                + " -> Error processing "
                                + fileName
                                + " : "
                                + e.getMessage()
                );
            }
        }
    }

    // ============================================================
    // Version 2 - Callable
    // ============================================================
    static class SalesCalculationTask
            implements Callable<SalesReport> {

        private final String fileName;
        private final FileProcessor processor;

        public SalesCalculationTask(
                String fileName,
                FileProcessor processor) {

            this.fileName = fileName;
            this.processor = processor;
        }

        @Override
        public SalesReport call()
                throws Exception {

            return processor.processFile(
                    fileName
            );
        }
    }

    // ============================================================
    // ReportGenerator
    // ============================================================
    static class ReportGenerator {

        /*
         * Displays individual file reports.
         */
        public void displayReport(
                SalesReport report) {

            System.out.println();
            System.out.println(
                    "----------------------------------------"
            );

            System.out.println(
                    "File Name      : "
                            + report.getFileName()
            );

            System.out.println(
                    "Number Records : "
                            + report.getNumberOfRecords()
            );

            System.out.println(
                    "Total Sales    : ₹"
                            + String.format(
                                    "%.2f",
                                    report.getTotalSales()
                            )
            );

            System.out.println(
                    "Highest Sale   : ₹"
                            + String.format(
                                    "%.2f",
                                    report.getHighestSale()
                            )
            );

            System.out.println(
                    "Lowest Sale    : ₹"
                            + String.format(
                                    "%.2f",
                                    report.getLowestSale()
                            )
            );

            System.out.println(
                    "Average Sale   : ₹"
                            + String.format(
                                    "%.2f",
                                    report.getAverageSale()
                            )
            );

            System.out.println(
                    "----------------------------------------"
            );
        }

        /*
         * Generates the final monthly report.
         */
        public void generateMonthlyReport(
                List<SalesReport> reports) {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "              MONTHLY SALES REPORT"
            );

            System.out.println(
                    "================================================"
            );

            double grandTotal = 0;

            for (SalesReport report : reports) {

                String month =
                        getMonthName(
                                report.getFileName()
                        );

                System.out.printf(
                        "%-12s : ₹%.2f%n",
                        month,
                        report.getTotalSales()
                );

                grandTotal +=
                        report.getTotalSales();
            }

            System.out.println(
                    "------------------------------------------------"
            );

            System.out.printf(
                    "%-12s : ₹%.2f%n",
                    "Grand Total",
                    grandTotal
            );

            System.out.println(
                    "================================================"
            );
        }

        private String getMonthName(
                String fileName) {

            String name =
                    new File(fileName)
                            .getName();

            int dotIndex =
                    name.lastIndexOf('.');

            if (dotIndex != -1) {
                name =
                        name.substring(
                                0,
                                dotIndex
                        );
            }

            if (name.startsWith("sales_")) {
                name =
                        name.substring(
                                6
                        );
            }

            if (name.isEmpty()) {
                return name;
            }

            return name.substring(0, 1).toUpperCase()
                    + name.substring(1);
        }
    }

    // ============================================================
    // Create Sample Files
    // ============================================================
    private static void createSampleFiles()
            throws IOException {

        createFile(
                "sales_january.txt",
                "Laptop,75000\n"
                        + "Mouse,1500\n"
                        + "Keyboard,2500\n"
                        + "Monitor,18000\n"
                        + "Printer,12000\n"
        );

        createFile(
                "sales_february.txt",
                "Laptop,80000\n"
                        + "Mouse,1800\n"
                        + "Keyboard,2800\n"
                        + "Monitor,20000\n"
                        + "Printer,15000\n"
        );

        createFile(
                "sales_march.txt",
                "Laptop,70000\n"
                        + "Mouse,1600\n"
                        + "Keyboard,3000\n"
                        + "Monitor,19000\n"
                        + "Printer,14000\n"
        );

        createFile(
                "sales_april.txt",
                "Laptop,85000\n"
                        + "Mouse,1700\n"
                        + "Keyboard,2700\n"
                        + "Monitor,21000\n"
                        + "Printer,13000\n"
        );

        createFile(
                "sales_may.txt",
                "Laptop,90000\n"
                        + "Mouse,2000\n"
                        + "Keyboard,3200\n"
                        + "Monitor,22000\n"
                        + "Printer,16000\n"
        );
    }

    private static void createFile(
            String fileName,
            String content)
            throws IOException {

        File file =
                new File(fileName);

        /*
         * Do not overwrite an existing file.
         */
        if (file.exists()) {
            return;
        }

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(file))) {

            writer.write(content);
        }
    }

    // ============================================================
    // Version 1 Demonstration
    // ExecutorService + Runnable
    // ============================================================
    private static void runRunnableVersion(
            String[] files) {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "       VERSION 1 - EXECUTOR + RUNNABLE"
        );

        System.out.println(
                "================================================"
        );

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        FileProcessor processor =
                new FileProcessor();

        /*
         * Runnable does not return a result.
         *
         * Therefore this version only demonstrates
         * parallel processing.
         */

        for (String file : files) {

            executor.execute(
                    new SalesCalculationRunnable(
                            file,
                            processor
                    )
            );
        }

        /*
         * No new tasks can be submitted after shutdown().
         * Existing tasks are allowed to finish.
         */
        executor.shutdown();

        try {

            /*
             * Wait until all tasks finish.
             */
            if (!executor.awaitTermination(
                    1,
                    TimeUnit.MINUTES)) {

                System.out.println(
                        "Tasks did not finish within the expected time."
                );
            }

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();

            System.out.println(
                    "Main thread was interrupted."
            );
        }

        System.out.println();
        System.out.println(
                "Runnable version completed."
        );
    }

    // ============================================================
    // Version 2 Demonstration
    // ExecutorService + Callable + Future
    // ============================================================
    private static void runCallableVersion(
            String[] files) {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "     VERSION 2 - EXECUTOR + CALLABLE + FUTURE"
        );

        System.out.println(
                "================================================"
        );

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        FileProcessor processor =
                new FileProcessor();

        List<Future<SalesReport>> futures =
                new ArrayList<>();

        /*
         * Submit all files to the thread pool.
         *
         * Each Callable returns a SalesReport.
         */
        for (String file : files) {

            Future<SalesReport> future =
                    executor.submit(
                            new SalesCalculationTask(
                                    file,
                                    processor
                            )
                    );

            futures.add(future);
        }

        /*
         * The main thread waits for all tasks
         * to complete using Future.get().
         */
        List<SalesReport> reports =
                new ArrayList<>();

        for (Future<SalesReport> future : futures) {

            try {

                /*
                 * Future.get() waits if the task
                 * has not completed yet.
                 */
                SalesReport report =
                        future.get();

                reports.add(report);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "Main thread was interrupted."
                );

            } catch (ExecutionException e) {

                System.out.println(
                        "Error while processing file: "
                                + e.getCause()
                );
            }
        }

        executor.shutdown();

        /*
         * Generate the final report only after
         * all Future objects have completed.
         */
        ReportGenerator generator =
                new ReportGenerator();

        for (SalesReport report : reports) {

            generator.displayReport(
                    report
            );
        }

        generator.generateMonthlyReport(
                reports
        );
    }

    // ============================================================
    // Main
    // ============================================================
    public static void main(String[] args)
            throws Exception {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "       PARALLEL FILE PROCESSING ENGINE"
        );

        System.out.println(
                "================================================"
        );

        System.out.println();
        System.out.println(
                "Thread Pool Size : 3"
        );

        // --------------------------------------------------------
        // Create sample sales files
        // --------------------------------------------------------

        createSampleFiles();

        String[] files = {

                "sales_january.txt",
                "sales_february.txt",
                "sales_march.txt",
                "sales_april.txt",
                "sales_may.txt"
        };

        // --------------------------------------------------------
        // Version 1
        // ExecutorService + Runnable
        // --------------------------------------------------------

        runRunnableVersion(files);

        // --------------------------------------------------------
        // Version 2
        // ExecutorService + Callable + Future
        // --------------------------------------------------------

        runCallableVersion(files);

        // --------------------------------------------------------
        // Program completed
        // --------------------------------------------------------

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "       FILE PROCESSING COMPLETED"
        );

        System.out.println(
                "================================================"
        );
    }
}