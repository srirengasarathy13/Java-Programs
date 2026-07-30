package Threads;

class A implements Runnable{
    @Override
public void run(){
    for(int i=0; i<=100; i++){
System.out.println("Hi");
   }
 }
}

class B implements Runnable{
@Override
public void run(){
    for(int i=0; i<=100; i++){
System.out.println("Hello");
    }
  }
}

public class RunnableThread {
    public static void main(String[] args) {
        // A obj1 = new A();
        // B obj2 = new B();
        Thread t1 = new Thread(new A());        //Thread t1 = new Thread(obj1); 
        Thread t2 = new Thread(new B());        // Thread t2 = new Thread(obj2);
        
        t1.start();
        t2.start();
    }
}
