package TryCatchFinally;

public class TryCatch {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        try{
            j = 18/i;  // block of code that may cause Exception
        }catch(Exception e){
            System.out.println("Some Exception has been caught !");  
            //block of code which will be executed if any Exception is caught.
        }
    }
    
}
