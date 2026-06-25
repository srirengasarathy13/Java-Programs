package StreamAPI;
import java.util.*;
import java.util.stream.Collectors;
public class streamToList {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(70);  
        scores.add(85);
        scores.add(90);
        scores.add(60);
        scores.add(95);
        List<Integer> eligibleEmployee = scores.stream().filter(x -> x >=80).collect(Collectors.toList());
        System.out.println(eligibleEmployee);
    }
}
