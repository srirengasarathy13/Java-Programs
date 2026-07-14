package StringBuilders;

import java.util.Scanner;
public class EmailGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter your domain: ");
        String domain = sc.nextLine().trim();
        StringBuilder email = new StringBuilder();
        email.append(name.toLowerCase().replace(" ", "."));
        email.append("@");
        email.append(domain.toLowerCase().replace(" ", ""));
        email.append(".com");
        System.out.println("Generated Email: " + email.toString());
        sc.close();
    }
}
