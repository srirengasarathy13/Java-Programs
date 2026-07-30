

public class ThreadSleep{
    public static void main(String args[]){
       ThreadGonnaSleep thread = new ThreadGonnaSleep();
       thread.start();
    }
}

class ThreadGonnaSleep extends Thread{
    @Override
    public void run(){
        try{
            System.out.println("Started...");
            Thread.sleep(3000);
            System.out.println("Completed...");
        }catch(Exception e){
        e.printStackTrace();
    }
}
}