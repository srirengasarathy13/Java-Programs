public class tryCatch {

    public static void main(String[] args) {
        try{
            // int val = Integer.parseInt("ABC");
            int[] arr = {1,2,3,4,5};
            System.out.println(arr[8]);

        }catch(Exception a ){
            System.out.println("Exception occured !");
        }
    }
}