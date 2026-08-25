package Assignments;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Assignment1_BankApplication {

    // ============================================================
    // BankAccount
    // ============================================================
    static class BankAccount {

        private final String accountNumber;
        private double balance;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        // Thread-safe deposit
        public synchronized boolean deposit(double amount) {

            if (amount <= 0) {
                return false;
            }

            balance += amount;
            return true;
        }

        // Thread-safe withdrawal
        public synchronized boolean withdraw(double amount) {

            if (amount <= 0 || balance < amount) {
                return false;
            }

            balance -= amount;
            return true;
        }

        // Thread-safe balance enquiry
        public synchronized double getBalance() {
            return balance;
        }

        /*
         * Deadlock-safe fund transfer.
         *
         * Both accounts are always locked in the same order
         * based on account number.
         */
        public static boolean transfer(
                BankAccount from,
                BankAccount to,
                double amount) {

            if (from == to || amount <= 0) {
                return false;
            }

            BankAccount first;
            BankAccount second;

            // Always acquire locks in the same order.
            if (from.accountNumber.compareTo(to.accountNumber) < 0) {
                first = from;
                second = to;
            } else {
                first = to;
                second = from;
            }

            synchronized (first) {
                synchronized (second) {

                    if (from.balance < amount) {
                        return false;
                    }

                    from.balance -= amount;
                    to.balance += amount;

                    return true;
                }
            }
        }

        /*
         * --------------------------------------------------------
         * UNSAFE WITHDRAW
         * --------------------------------------------------------
         *
         * This method intentionally does NOT use synchronized.
         *
         * It is used only to demonstrate the race condition
         * problem of concurrent access.
         */
        public boolean unsafeWithdraw(double amount) {

            if (amount <= 0 || balance < amount) {
                return false;
            }

            /*
             * Artificial delay makes it easier for two threads
             * to read the same balance at the same time.
             */
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            balance -= amount;
            return true;
        }
    }

    // ============================================================
    // Transaction
    // ============================================================
    static class Transaction {

        private final String transactionId;
        private final String accountNumber;
        private final String transactionType;
        private final double amount;

        public Transaction(
                String transactionId,
                String accountNumber,
                String transactionType,
                double amount) {

            this.transactionId = transactionId;
            this.accountNumber = accountNumber;
            this.transactionType = transactionType;
            this.amount = amount;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public String getTransactionType() {
            return transactionType;
        }

        public double getAmount() {
            return amount;
        }
    }

    // ============================================================
    // TransactionProcessor
    // ============================================================
    static class TransactionProcessor {

        private final AtomicInteger successful =
                new AtomicInteger(0);

        private final AtomicInteger failed =
                new AtomicInteger(0);

        public void process(
                Transaction transaction,
                Map<String, BankAccount> accounts) {

            String threadName =
                    Thread.currentThread().getName();

            BankAccount account =
                    accounts.get(transaction.getAccountNumber());

            // Account does not exist
            if (account == null) {

                failed.incrementAndGet();

                System.out.println(
                        threadName
                                + " | "
                                + transaction.getTransactionId()
                                + " | FAILED - Account not found"
                );

                return;
            }

            boolean success = false;

            String transactionType =
                    transaction.getTransactionType().toUpperCase();

            switch (transactionType) {

                case "DEPOSIT":

                    success = account.deposit(
                            transaction.getAmount()
                    );

                    break;

                case "WITHDRAW":

                    success = account.withdraw(
                            transaction.getAmount()
                    );

                    break;

                default:

                    System.out.println(
                            threadName
                                    + " | "
                                    + transaction.getTransactionId()
                                    + " | Invalid transaction type"
                    );

                    break;
            }

            if (success) {

                successful.incrementAndGet();

                System.out.println(
                        threadName
                                + " | "
                                + transaction.getTransactionId()
                                + " | SUCCESS"
                                + " | "
                                + transaction.getTransactionType()
                                + " | Amount: ₹"
                                + transaction.getAmount()
                                + " | Balance: ₹"
                                + account.getBalance()
                );

            } else {

                failed.incrementAndGet();

                System.out.println(
                        threadName
                                + " | "
                                + transaction.getTransactionId()
                                + " | FAILED"
                                + " | "
                                + transaction.getTransactionType()
                                + " | Amount: ₹"
                                + transaction.getAmount()
                );
            }
        }

        public int getSuccessfulCount() {
            return successful.get();
        }

        public int getFailedCount() {
            return failed.get();
        }
    }

    // ============================================================
    // TransactionTask
    // ============================================================
    static class TransactionTask implements Runnable {

        private final Transaction transaction;
        private final Map<String, BankAccount> accounts;
        private final TransactionProcessor processor;

        public TransactionTask(
                Transaction transaction,
                Map<String, BankAccount> accounts,
                TransactionProcessor processor) {

            this.transaction = transaction;
            this.accounts = accounts;
            this.processor = processor;
        }

        @Override
        public void run() {

            processor.process(
                    transaction,
                    accounts
            );
        }
    }

    // ============================================================
    // Concurrent Access Demonstration
    // ============================================================
    private static void demonstrateRaceCondition()
            throws InterruptedException {

        System.out.println();
        System.out.println("================================================");
        System.out.println("   CONCURRENT ACCESS DEMONSTRATION");
        System.out.println("================================================");

        System.out.println();
        System.out.println("1. WITHOUT SYNCHRONIZATION");
        System.out.println("--------------------------------");

        /*
         * Starting balance = ₹1000
         *
         * Two threads will simultaneously withdraw ₹600.
         *
         * Correct result should be:
         *
         *     One withdrawal succeeds
         *     One withdrawal fails
         *
         * Final balance = ₹400
         *
         * But because unsafeWithdraw() is not synchronized,
         * both threads may read ₹1000 before either updates it.
         */
        BankAccount unsafeAccount =
                new BankAccount("TEST-UNSAFE", 1000);

        Thread thread1 = new Thread(() -> {

            boolean result =
                    unsafeAccount.unsafeWithdraw(600);

            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrawal result: "
                            + result
            );

        }, "Unsafe-Thread-1");

        Thread thread2 = new Thread(() -> {

            boolean result =
                    unsafeAccount.unsafeWithdraw(600);

            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrawal result: "
                            + result
            );

        }, "Unsafe-Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(
                "Final balance WITHOUT synchronization: ₹"
                        + unsafeAccount.getBalance()
        );

        System.out.println();
        System.out.println("Expected correct balance: ₹400");

        System.out.println();
        System.out.println(
                "Problem: Both threads can read the same balance"
                        + " before updating it."
        );

        // --------------------------------------------------------
        // Correct synchronized implementation
        // --------------------------------------------------------

        System.out.println();
        System.out.println("2. WITH SYNCHRONIZATION");
        System.out.println("--------------------------------");

        BankAccount safeAccount =
                new BankAccount("TEST-SAFE", 1000);

        Thread safeThread1 = new Thread(() -> {

            boolean result =
                    safeAccount.withdraw(600);

            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrawal result: "
                            + result
            );

        }, "Safe-Thread-1");

        Thread safeThread2 = new Thread(() -> {

            boolean result =
                    safeAccount.withdraw(600);

            System.out.println(
                    Thread.currentThread().getName()
                            + " withdrawal result: "
                            + result
            );

        }, "Safe-Thread-2");

        safeThread1.start();
        safeThread2.start();

        safeThread1.join();
        safeThread2.join();

        System.out.println(
                "Final balance WITH synchronization: ₹"
                        + safeAccount.getBalance()
        );

        System.out.println();
        System.out.println(
                "Because withdraw() is synchronized,"
                        + " only one thread can execute it"
                        + " at a time for the same account."
        );
    }

    // ============================================================
    // Fund Transfer Demonstration
    // ============================================================
    private static void demonstrateFundTransfer(
            Map<String, BankAccount> accounts)
            throws InterruptedException {

        System.out.println();
        System.out.println("================================================");
        System.out.println("           FUND TRANSFER TEST");
        System.out.println("================================================");

        BankAccount accountA =
                accounts.get("ACC101");

        BankAccount accountB =
                accounts.get("ACC102");

        System.out.println();
        System.out.println(
                "Before transfer:"
        );

        System.out.println(
                accountA.getAccountNumber()
                        + " : ₹"
                        + accountA.getBalance()
        );

        System.out.println(
                accountB.getAccountNumber()
                        + " : ₹"
                        + accountB.getBalance()
        );

        /*
         * Thread 1:
         *
         * ACC101 -> ACC102
         *
         * Thread 2:
         *
         * ACC102 -> ACC101
         *
         * Both operations happen concurrently.
         *
         * BankAccount.transfer() locks both accounts
         * in a consistent order to prevent deadlock.
         */

        Thread transfer1 = new Thread(() -> {

            boolean result =
                    BankAccount.transfer(
                            accountA,
                            accountB,
                            1000
                    );

            System.out.println(
                    Thread.currentThread().getName()
                            + " | ACC101 -> ACC102"
                            + " | Amount: ₹1000"
                            + " | Result: "
                            + result
            );

        }, "Transfer-Thread-1");

        Thread transfer2 = new Thread(() -> {

            boolean result =
                    BankAccount.transfer(
                            accountB,
                            accountA,
                            500
                    );

            System.out.println(
                    Thread.currentThread().getName()
                            + " | ACC102 -> ACC101"
                            + " | Amount: ₹500"
                            + " | Result: "
                            + result
            );

        }, "Transfer-Thread-2");

        transfer1.start();
        transfer2.start();

        transfer1.join();
        transfer2.join();

        System.out.println();
        System.out.println(
                "After transfer:"
        );

        System.out.println(
                accountA.getAccountNumber()
                        + " : ₹"
                        + accountA.getBalance()
        );

        System.out.println(
                accountB.getAccountNumber()
                        + " : ₹"
                        + accountB.getBalance()
        );
    }

    // ============================================================
    // Main
    // ============================================================
    public static void main(String[] args)
            throws InterruptedException {

        System.out.println();
        System.out.println("================================================");
        System.out.println("       BANK TRANSACTION PROCESSOR");
        System.out.println("================================================");

        // --------------------------------------------------------
        // Create shared bank accounts
        // --------------------------------------------------------

        Map<String, BankAccount> accounts =
                new HashMap<>();

        accounts.put(
                "ACC101",
                new BankAccount("ACC101", 10000)
        );

        accounts.put(
                "ACC102",
                new BankAccount("ACC102", 5000)
        );

        // --------------------------------------------------------
        // Create TransactionProcessor
        // --------------------------------------------------------

        TransactionProcessor processor =
                new TransactionProcessor();

        // --------------------------------------------------------
        // Create transactions
        // --------------------------------------------------------

        List<Transaction> transactions =
                Arrays.asList(

                        new Transaction(
                                "T001",
                                "ACC101",
                                "DEPOSIT",
                                10000
                        ),

                        new Transaction(
                                "T002",
                                "ACC101",
                                "WITHDRAW",
                                3000
                        ),

                        new Transaction(
                                "T003",
                                "ACC102",
                                "DEPOSIT",
                                5000
                        ),

                        new Transaction(
                                "T004",
                                "ACC101",
                                "WITHDRAW",
                                4000
                        ),

                        // This transaction should fail because
                        // the account does not have ₹50,000.
                        new Transaction(
                                "T005",
                                "ACC101",
                                "WITHDRAW",
                                50000
                        )
                );

        // --------------------------------------------------------
        // Create and start transaction threads
        // --------------------------------------------------------

        System.out.println();
        System.out.println("===== PROCESSING TRANSACTIONS =====");

        List<Thread> threads =
                new ArrayList<>();

        int threadNumber = 1;

        for (Transaction transaction : transactions) {

            Thread thread =
                    new Thread(
                            new TransactionTask(
                                    transaction,
                                    accounts,
                                    processor
                            ),
                            "Transaction-" + threadNumber++
                    );

            threads.add(thread);

            thread.start();
        }

        // --------------------------------------------------------
        // Wait for all transaction threads
        // --------------------------------------------------------

        for (Thread thread : threads) {
            thread.join();
        }

        // --------------------------------------------------------
        // Transaction Summary
        // --------------------------------------------------------

        System.out.println();
        System.out.println("================================================");
        System.out.println("          TRANSACTION SUMMARY");
        System.out.println("================================================");

        System.out.println(
                "Successful Transactions : "
                        + processor.getSuccessfulCount()
        );

        System.out.println(
                "Failed Transactions     : "
                        + processor.getFailedCount()
        );

        // --------------------------------------------------------
        // Final account balances
        // --------------------------------------------------------

        System.out.println();
        System.out.println("===== FINAL BALANCES =====");

        for (BankAccount account : accounts.values()) {

            System.out.println(
                    account.getAccountNumber()
                            + " : ₹"
                            + account.getBalance()
            );
        }

        // --------------------------------------------------------
        // Demonstrate race condition
        // --------------------------------------------------------

        demonstrateRaceCondition();

        // --------------------------------------------------------
        // Demonstrate fund transfer
        // --------------------------------------------------------

        demonstrateFundTransfer(accounts);

        // --------------------------------------------------------
        // Program completed
        // --------------------------------------------------------

        System.out.println();
        System.out.println("================================================");
        System.out.println("       BANK APPLICATION COMPLETED");
        System.out.println("================================================");
    }
}