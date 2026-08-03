package Threads;

class Counter{
    int counter = 0;
    public synchronized void increment(){ // Here this "synchronised" keyword helps the increment method
        counter++;                        // to be executed by only one thread at time. Not more than 1 
    }                                     // thread can execute this method at once. Thus performing 
                                          // Mutation in Thread safely.
}
public class ThreadSafwWithSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable a = () ->{
            for(int i=0;i<1000;i++){
                 c.increment();
           }
        };

        Runnable b = () ->{
        for(int i=0;i<1000;i++){
              c.increment();
        }
        };
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(c.counter);
    }
}
