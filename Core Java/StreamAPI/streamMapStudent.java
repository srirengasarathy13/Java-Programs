package StreamAPI;
import java.util.*;;
public class streamMapStudent {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();
        marks.add(90);
        marks.add(80);
        marks.add(70);  
        marks.add(60);
        marks.add(50);
        System.out.println("Marks after 5 increase :");
        marks.stream().map(mark -> mark + 5).forEach(System.out::println);
    }
}
