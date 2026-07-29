package Self_Learnt.TryCatchFinally;

public class TryCatchFinally {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        try{
            j =18/i;
        }catch(Exception e){
            System.out.println("Some Exception has been caught !");
        }
        finally{
            System.out.println("This statement is executed by Finally block.");
        }
    }
}
