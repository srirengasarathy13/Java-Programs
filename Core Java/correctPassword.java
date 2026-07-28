import java.util.*;
public class correctPassword {
    public static void main(String[] args) {
        String password = "agnie";
        Scanner sc  = new Scanner(System.in);
        String input = sc.nextLine();
        while (!(input.equals(password))) {
            System.out.println("Invalid Password!,Enter a correct Password: ");
            input = sc.nextLine();
        }
    sc.close();
    }
}
