package TryCatchFinally;

public class TryFinally {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        try{
            j = 18/i;
        }
        finally{
            System.out.println("This statement is executed by Finally block."); 
            // This codes in finally block runs irrespective of the Exception.
            // It 'll run anyway, whether Exception is caught or not. 
         }
    }
}
