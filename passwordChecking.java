import java.util.*;

public class passwordChecking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = "agnie@123"; 
        int limit = 3;
        int attempt = 0;
        boolean unlocked = false;

        while (attempt < limit) {
            System.out.print("Enter Password: ");
            String inputPassword = sc.nextLine(); 

            if (inputPassword.equals(password)) {
                System.out.println("Unlocked!");
                unlocked = true;
                break; 
            } else {
                attempt++;
                if (attempt < limit) {
                    System.out.println("Wrong Password, " + (limit - attempt) + " attempts left!");
                }
            }
        }

        if (!unlocked) {
            System.out.println("Locked!");
        }
        
        sc.close();
    }
}
