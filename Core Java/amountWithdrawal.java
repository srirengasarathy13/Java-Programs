import java.util.*;
public class amountWithdrawal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int balance = 5000;
        System.out.print("Enter amount to withdraw: ");
        int withdrawalAmount = sc.nextInt();
        if(balance>=withdrawalAmount){
            System.out.println("Rs."+withdrawalAmount+" withdrawn successfully!\nCurrent Balance: Rs."+(balance-withdrawalAmount));
        }
        else{
            System.out.println("Sorry, Not enough balance to withdraw!\nCurrent Balance: Rs."+balance);
        }
    sc.close();
    }
}
