package StreamAPI;

import java.util.ArrayList;

public class streamCount {

    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();
        scores.add(70);  
        scores.add(85);
        scores.add(90);
        scores.add(60);
        scores.add(95);
        long count = scores.stream().filter(x -> x >= 80).count();     
        System.out.println("Employees Eligible for Promotion : " + count);  
    }
}