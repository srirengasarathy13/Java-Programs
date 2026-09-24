package Test.Week4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class RemoteClient {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try(Socket socket = new Socket("localhost",5000)){
       DataInputStream input = new DataInputStream(socket.getInputStream());
       DataOutputStream output = new DataOutputStream(socket.getOutputStream());
       System.out.println("-----Remote Client-----");
       System.out.println();
       System.out.print("Enter Request Id : ");
       int requestId = sc.nextInt();
       sc.nextLine();
       System.out.print("Enter Customer Id : ");
       String customerId = sc.nextLine();
       System.out.print("Enter Service type : ");
       String serviceType = sc.nextLine();
       System.out.print("Enter Description : ");
       String description = sc.nextLine();
       output.writeInt(requestId);
       output.writeUTF(customerId);
       output.writeUTF(serviceType);
       output.writeUTF(description);
       output.flush();
       System.out.println();
       System.out.println("Request sent to server.");
       System.out.println("Waiting for response...");
       int responseId = input.readInt();
       String status = input.readUTF();
       String message = input.readUTF();
       System.out.println();
       System.out.println("----Server Response----");
       System.out.println();
       System.out.println("Request ID      : " + responseId);
       System.out.println("Request Status  : " + status);
       System.out.println("Response Message: " + message);
     }catch(ConnectException e){
        System.out.println("Couldn't connect to the Server !");
        System.out.println("Check whether the server is running or not...");
    }catch(IOException e) {
       System.out.println("Communication error : "+e.getMessage());
    }
  }
}
