package Self_Learnt.TryCatchFinally;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResource {
    public static void main(String[] args) throws IOException {
        int num ;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.print("Enter : ");
            num = Integer.parseInt(br.readLine());     
        }
    }
}

// Here in this code, We doesn't neeed to close the resource br.
// br.close is not necessary here.
// This practise of passing the resourse into the try as argument will 
// automatically close the resourse.
// This is called Try with Resource.