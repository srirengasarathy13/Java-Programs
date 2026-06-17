
import java.util.*;
class StudentMarks{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();
        System.out.println("Enter the marks of 5 Students : ");
        for(int i = 0 ; i<5; i++){
            marks.add(sc.nextInt());
        }
        System.out.println("-------------");
        System.out.println("Student Marks");
        System.out.println("-------------");
        int total = 0;
        for(int n : marks){
            System.out.println(n);
            total = total + n;
        }
        System.out.println("Total Marks     : "+(total));
        System.out.println("Average Marks   : "+(total/marks.size()));
        System.out.println("Highest mark    : "+Collections.max(marks));
        System.out.println("Lowest mark     : "+Collections.min(marks));
        sc.close();
    }
}