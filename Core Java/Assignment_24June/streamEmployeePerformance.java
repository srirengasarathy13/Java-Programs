package Assignment_24June;
import java.util.*;
public class streamEmployeePerformance {

    public static void main(String[] args) {
        ArrayList<Integer> performanceScores = new ArrayList<>();
        performanceScores.add(72);
        performanceScores.add(90);
        performanceScores.add(88);
        performanceScores.add(65);
        performanceScores.add(95);
        performanceScores.add(80);
        performanceScores.add(91);
        performanceScores.add(78);
        performanceScores.add(86);
        performanceScores.add(70);

        System.out.println("Employee performance scores greater than 85 are :");
        performanceScores.stream().filter(score -> score > 85).forEach(System.out::println);
    }
}