package Self_Learnt.BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInRead {
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a number : ");
        // int num = System.in.read(); // returns the ASCI value of the input
        // System.err.println(num);

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(in);
        int num = Integer.parseInt(bf.readLine());
        System.out.println(num);
        bf.close(); // good practise
    }
}
