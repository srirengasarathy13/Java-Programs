

public class customException {
    static void validateSalary(double salary) throws InvalidSalaryException{
        if(salary<0){
            throw new InvalidSalaryException("Salary must be greater than 0 !");
        }
    }
    
    public static void main(String[] args) {
        try{
            validateSalary(-100000);
        }catch(InvalidSalaryException e){
           System.out.println(e.getMessage());
        }
    }

}

class InvalidSalaryException extends Exception{
   InvalidSalaryException(String message){
    super(message);
   }
}