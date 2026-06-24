package StreamAPI;
import java.util.*;;
public class streamStudent {
 public static void main(String[] args) {
    ArrayList<Integer> marks = new ArrayList<>();
    marks.add(90);
    marks.add(80);
    marks.add(70);
    marks.add(60);
    marks.add(50);
    System.out.println("Marks greater than 70 are :");
    marks.stream().filter(mark -> mark > 70).forEach(System.out::println);
 }
    
}