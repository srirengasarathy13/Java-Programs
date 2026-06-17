import java.util.*;
public class scannerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome to Java Training, "+name);
        sc.close();
    }
}
