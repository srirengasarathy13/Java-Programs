package StreamAPI;
import java.util.*; 
public class streamSorted {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(90);
        marks.add(80);
        marks.add(70);
        marks.add(60);
        marks.add(50);
        System.out.println("Marks in sorted order are :");
        marks.stream().sorted().forEach(System.out::println);
    }
}
