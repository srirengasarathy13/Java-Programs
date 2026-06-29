/**
 * methodInterface
 */

import java.util.ArrayList;
public class methodInterface {
public static void main(String[] args) {
    ArrayList<String> names = new ArrayList<>();
    names.add("John");
    names.add("Alice");
    names.add("Bob");
    names.add("Eve");
    names.add("Charlie");
    System.out.println("Employee Names");
    System.out.println("----------------");
    names.forEach(System.out::println);
}
    
}