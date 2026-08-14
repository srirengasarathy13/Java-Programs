package Networking;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class HRMSClient{
    public static void main(String[] args) throws Exception {
        Socket clientSocket = new Socket("localhost",5000);
        BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
        output.println("EMP1001");
        String response = input.readLine();
        System.out.println("HRMS Server Response : "+response);
        clientSocket.close();
    }
}