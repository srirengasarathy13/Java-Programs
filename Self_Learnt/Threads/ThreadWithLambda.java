package Threads;

public class ThreadWithLambda {
    public static void main(String[] args) {
        Runnable obj1 = () -> {
            try {

                for (int i = 0; i <= 100; i++) {
                    System.out.println("Hi");
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        };

        Runnable obj2 = () -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    System.out.println("Hello");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

    }
}