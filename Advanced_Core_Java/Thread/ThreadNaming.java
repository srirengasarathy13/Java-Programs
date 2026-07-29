class ReturnThreadName extends Thread{
    @Override
    public void run(){
        System.out.println("Thread Name : "+ Thread.currentThread().getName());
    }
}

public class ThreadNaming {
    public static void main(String[] args) {
        ReturnThreadName threadName = new ReturnThreadName();
        threadName.setName("Employee Registration Thread");
        threadName.start();
    }
}
