package Recursion;

import java.util.*;
public class RecursionDemo {
    public static void display(int n){
        if(n==0){
            return;
        }
        System.out.println("Employee ID : Emp10" + n);
        display(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of employees : ");
        int n = sc.nextInt();
        display(n);
    }
}
