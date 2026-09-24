package Test.Week4;

public class JVMDemo {

    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = new String("Python");
        String s3 = new String("C++");
        System.out.println("Objects created.");
        s2 = null;
        s3 = null;
        System.out.println("s2 and s3 references are removed and now they are eligible for Garbage Collection.");
        System.gc();
        System.out.println("Garbage collection requested.");
    }
}