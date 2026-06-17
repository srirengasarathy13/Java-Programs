package Assignment_17June;
import java.util.*;

public class studentAdmissionSystem extends customExe{
     public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        try{
            System.out.print("Enter age : ");
            int age = sc.nextInt();
            validateAge(age);

     }catch(InvalidAgeException e){
        System.out.println(e.getMessage());
     }
     sc.close();     
}
}

class InvalidAgeException extends Exception{
    InvalidAgeException(String message){
        super(message);
    }
}

class customExe{
    static void validateAge(int age) throws InvalidAgeException{
      if(age<18){
        System.out.println("Invalid Age Exception : Age must be greater than or equal to 18");
      }
    }
}