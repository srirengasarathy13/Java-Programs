package StreamAPI;
import java. util.*;;
public class streamMap {
 
    public static void main(String[] args) {
        ArrayList<Integer> salaries = new ArrayList<>();
        salaries.add(90000);
        salaries.add(100000);
        salaries.add(80000);
        salaries.add(95000);
        salaries.add(120000);
        System.out.println("Salaries after 5000 increase :");
        salaries.stream().map(salary -> salary + 5000).forEach(System.out::println);
    }
    
}