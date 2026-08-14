package Networking.EmployeeSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EmployeeSearchClient {

    public static void main(String[] args) throws Exception {

        Socket clientSocket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter output = new PrintWriter(
                clientSocket.getOutputStream(), true);

        output.println("EMP1001");

        String response;

        while ((response = input.readLine()) != null) {
            System.out.println(response);
        }

        clientSocket.close();
    }
}