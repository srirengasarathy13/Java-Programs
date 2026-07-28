import java.util.*;

public class validInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        checkInput(num);
        sc.close();

    }

    public static void checkInput(int n) {
        Scanner sc1 = new Scanner(System.in);
        while (!(n >= 0 && n <= 100)) {
            System.out.print("Invalid Input!, Enter a valid one: ");
            n = sc1.nextInt();

        }

        sc1.close();

    }
}
