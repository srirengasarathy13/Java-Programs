
        import java.util.*;
        public class ifStatement {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the age: ");
        int age = sc.nextInt();
        if(age>=18){
            System.out.println("Eligible to vote");
        }
        else{
            System.out.println("Not Eligible to vote, Comeback after "+(18-age)+" years");
        }
        sc.close();
}

}

