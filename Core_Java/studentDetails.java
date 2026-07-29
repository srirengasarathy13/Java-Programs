import java.util.*;
public class studentDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Student's name       : ");
        String name = sc.nextLine();
        System.out.print("Enter the Student's rollno     : ");
        int rollno = sc.nextInt();
        System.out.print("Enter the Student's department :");
        String dept = sc.next();
        System.out.print("Enter the Student's native     : ");
        String loc = sc.next();
        System.out.println();
        System.out.println("---------------------Student Details---------------------");
        System.out.println();
        System.out.println("Name       :" +name);
        System.out.println("RollNo     :"+rollno);
        System.out.println("Department :"+dept);
        System.out.println("Native     :"+loc); 
        sc.close();
    }
}
