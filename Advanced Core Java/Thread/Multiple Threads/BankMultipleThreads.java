class WithdrawMoneyThread extends Thread {
  @Override
  public void run(){
    System.out.println("Withdrawing Money...");
  }
}

class DepositMoneyThread extends Thread {
  @Override
  public void run(){
    System.out.println("Depositing Money...");
  }
}

class CheckBalanceThread extends Thread {
  @Override
  public void run(){
    System.out.println("Checking Balance...");
  }
}

public class BankMultipleThreads {
        public static void main(String[] args) {
            WithdrawMoneyThread withdraw = new WithdrawMoneyThread();
            DepositMoneyThread deposit = new DepositMoneyThread();
            CheckBalanceThread checkBalance = new CheckBalanceThread();
            withdraw.start();
            deposit.start();
            checkBalance.start();
        }
}
