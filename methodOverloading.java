import java.util.*;
public class methodOverloading {
    public static void main(String[] args) {
        arithmeticOperation op1 = new arithmeticOperation();
     op1.add();
     op1.add(3,4);

    }
    
}

class arithmeticOperation{
    
    void add(){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println("The sum is : "+(x+y));
        sc.close();

    }

    void add(int a, int b){
        System.out.println("The sum is : "+(a+b));

    }
}

