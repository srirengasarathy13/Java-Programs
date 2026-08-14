package Networking.EmployeeSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EmployeeSearchServer{

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(5000);

        System.out.println("HRMS Server started...");
        System.out.println("Waiting for client...");

        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected...");

        BufferedReader input = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));

        PrintWriter output = new PrintWriter(
                clientSocket.getOutputStream(), true);

        String employeeId = input.readLine();

        System.out.println("Employee ID received: " + employeeId);

        output.println("Employee Details");
        output.println("------------------------");
        output.println("Employee ID   : EMP1001");
        output.println("Employee Name : Rama");
        output.println("Department    : SAP");
        output.println("Status        : Active");
        output.println("------------------------");

        clientSocket.close();
        serverSocket.close();
    }
}