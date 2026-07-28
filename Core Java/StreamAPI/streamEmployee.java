package StreamAPI;
import java.util.*;;
public class streamEmployee {
public static void main(String[] args) {
    ArrayList<Integer> salaries = new ArrayList<>();
    salaries.add(90000);
    salaries.add(100000);
    salaries.add(80000);
    salaries.add(95000);
    salaries.add(120000);
    System.out.println("Employee salaries greater than 85000 are :");
    salaries.stream().filter(salary -> salary > 85000).forEach(System.out::println);
}
    
}