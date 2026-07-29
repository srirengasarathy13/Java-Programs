package Advanced_Core_Java.Thread.BankingTransactionPortal;
class Deposit implements Runnable {

    @Override
    public void run() {
        System.out.println("Deposit Transaction Started...");
    }
}

class Withdraw implements Runnable {

    @Override
    public void run() {
        System.out.println("Withdraw Transaction Started...");
    }
}

class BalanceEnquiry implements Runnable {

    @Override
    public void run() {
        System.out.println("Balance Enquiry Started...");
    }
}

class MiniStatement implements Runnable {

    @Override
    public void run() {
        System.out.println("Mini Statement Generated...");
    }
}

public class BankingPortal {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Deposit());
        Thread t2 = new Thread(new Withdraw());
        Thread t3 = new Thread(new BalanceEnquiry());
        Thread t4 = new Thread(new MiniStatement());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
