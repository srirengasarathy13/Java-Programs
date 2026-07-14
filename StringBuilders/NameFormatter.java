package StringBuilders;

import java.util.*;
public class NameFormatter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine().trim();
        String[] nameParts = fullName.split(" ");
        StringBuilder formattedName = new StringBuilder();
        for (String part : nameParts) {
            if (!part.isEmpty()) {
                formattedName.append(Character.toUpperCase(part.charAt(0)));
                formattedName.append(part.substring(1).toLowerCase());
                formattedName.append(" ");
            }
        }
        System.out.println("Formatted Name: " + formattedName.toString().trim());
        sc.close();
    }
}
