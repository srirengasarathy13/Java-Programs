import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DepositTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Deposit Transaction");
    }
}

class WithdrawTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Withdraw Transaction");
    }
}

class BalanceEnquiryTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Balance Enquiry");
    }
}

class MiniStatementTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()
                + " -> Mini Statement");
    }
}

public class BankingTransactionSystem {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new DepositTask());
        executor.execute(new WithdrawTask());
        executor.execute(new BalanceEnquiryTask());
        executor.execute(new MiniStatementTask());
        executor.shutdown();
    }
}