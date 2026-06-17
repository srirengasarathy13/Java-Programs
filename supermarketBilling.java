import java.util.*;

public class supermarketBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer's name   : ");
        String customerName = sc.nextLine();
        System.out.print("Enter Product's name    : ");
        String productName = sc.nextLine();
        System.out.print("Enter the price         : ");
        int price = sc.nextInt();
        System.out.print("Enter the quantity      : ");
        int quantity = sc.nextInt();
        int sumTotalAmount = price * quantity;
        int finalAmount;
        int discount;
        sc.close();
        System.out.println("!!-------------SUPERMARKET BILL-------------!!");
        sc.nextLine();
        System.out.println("Customer's Name          : " + customerName);
        System.out.println("Product's Name           : " + productName);
        System.out.println("Price                    : " + price);
        System.out.println("Quantity                 : " + quantity);

        System.out.println("Total Amount             : Rs." + sumTotalAmount);
        if (sumTotalAmount > 5000) {
            discount = (int) (sumTotalAmount * 0.2);
            System.out.println("Discount Obtained        : Rs." + discount);
            finalAmount = sumTotalAmount - discount;
            System.out.println("Final Amount             : Rs." + finalAmount);

        } else if (sumTotalAmount > 3000) {
            discount = (int) (sumTotalAmount * 0.1);
            System.out.println("Discount Obtained        : Rs." + discount);
            finalAmount = sumTotalAmount - discount;
            System.out.println("Final Amount             : Rs." + finalAmount);

        } else {
            discount = (int) (sumTotalAmount * 0);
            System.out.println("Discount Obtained        : Rs." + discount);
            finalAmount = sumTotalAmount - discount;
            System.out.println("Final Amount             : Rs." + finalAmount);
        }

        sc.close();
    }
}
