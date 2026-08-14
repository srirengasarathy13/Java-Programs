package Networking;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HRMSServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("HRMS Server started...");
        System.out.println("Waiting for client...");
        Socket clienSocket = serverSocket.accept();
        System.out.println("Client connected...");
        BufferedReader input = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
        PrintWriter output = new PrintWriter(clienSocket.getOutputStream(), true);
        String employeeId = input.readLine();
        System.out.println("Employee ID recieved "+employeeId);
        output.println("Employee "+employeeId+" Active");
        clienSocket.close();
        serverSocket.close();
    }
}
