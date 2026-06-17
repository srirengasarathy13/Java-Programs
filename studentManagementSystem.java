import java.util.*;

public class studentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------Enter Student Details---------------------");
        System.out.println();

        System.out.print("Enter Student's name   : ");
        String name = sc.nextLine();

        System.out.print("Enter Student's ID     : ");
        String id = sc.nextLine();

        System.out.println("Now, Enter the marks respectively");

        System.out.print("Enter Maths marks obtained    : ");
        int sub1 = checkInput();

        System.out.print("Enter English marks obtained  : ");
        int sub2 = checkInput();

        System.out.print("Enter Science marks obtained  : ");
        int sub3 = checkInput();

        System.out.print("Enter Social marks obtained   : ");
        int sub4 = checkInput();

        System.out.print("Enter Tamil marks obtained    : ");
        int sub5 = checkInput();

        System.out.println();

        System.out.println("---------------------Student Result---------------------");
        System.out.println();

        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);

        System.out.println();

        System.out.print("Maths   : " + sub1 + "  ");
        gradeCalculation(sub1);

        System.out.print("English : " + sub2 + "  ");
        gradeCalculation(sub2);

        System.out.print("Science : " + sub3 + "  ");
        gradeCalculation(sub3);

        System.out.print("Social  : " + sub4 + "  ");
        gradeCalculation(sub4);

        System.out.print("Tamil   : " + sub5 + "  ");
        gradeCalculation(sub5);

        System.out.println();

        int totalMarks = sub1 + sub2 + sub3 + sub4 + sub5;

        System.out.println("Total Marks obtained out of 500: " + totalMarks);

        System.out.println("Average Mark: " + ((float) totalMarks / 5));

        System.out.println();

        if (sub1 >= 35 && sub2 >= 35 && sub3 >= 35 && sub4 >= 35 && sub5 >= 35) {
            System.out.println("Overall Result Status: Pass");
        } else {
            System.out.println("Overall Result Status: Fail");
        }

        int average = totalMarks / 5;

        System.out.print("Overall Grade: ");
        gradeCalculation(average);
        System.out.println();

        sc.close();
    }

    public static void gradeCalculation(int mark) {

        if (mark >= 95 && mark <= 100) {
            System.out.println("O Grade");
        } else if (mark >= 75) {
            System.out.println("A Grade");
        } else if (mark >= 50) {
            System.out.println("B Grade");
        } else if (mark >= 35) {
            System.out.println("C Grade");
        } else {
            System.out.println("Fail");
        }
    }

    public static int checkInput() {

        int n = sc.nextInt();

        while (!(n >= 0 && n <= 100)) {
            System.out.print("Invalid Input!, Enter a valid one: ");
            n = sc.nextInt();
        }

        return n;
    }
}