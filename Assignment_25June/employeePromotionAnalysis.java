package Assignment_25June;
import java.util.*;
import java.util.stream.Collectors;

public class employeePromotionAnalysis {

    public static void main(String[] args) {

        ArrayList<Integer> scores = new ArrayList<>(
                Arrays.asList(75, 82, 91, 67, 88, 79, 95, 81, 70, 85));

        System.out.println("Employee Scores:");
        System.out.println(scores);

        System.out.println("\nEmployees Eligible for Promotion (Score > 80):");
        scores.stream()
              .filter(score -> score > 80)
              .forEach(System.out::println);

        long count = scores.stream()
                           .filter(score -> score > 80)
                           .count();

        System.out.println("\nNumber of Eligible Employees: " + count);
        System.out.println();

        Optional<Integer> firstEmployee = scores.stream()
                                                .filter(score -> score > 80)
                                                .findFirst();

        if (firstEmployee.isPresent()) {
            System.out.println("First Eligible Employee Score: " + firstEmployee.get());
        } else {
            System.out.println("No Eligible Employee Found.");
        }
        System.out.println();

        List<Integer> eligibleEmployees = scores.stream()
                                                .filter(score -> score > 80)
                                                .collect(Collectors.toList());

        System.out.println("Eligible Employee Scores List: " + eligibleEmployees);
        
    }
}