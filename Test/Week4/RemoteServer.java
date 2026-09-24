package Test.Week4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer {
      public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("-----Remote Server-----");
            System.out.println();
            System.out.println("Server started on port 5000.");
            System.out.println("Waiting for client...");
            while(true){
                try(Socket socket = serverSocket.accept()){
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                    System.out.println("Client connected!");
                    int requestId = input.readInt();
                    String customerId = input.readUTF();
                    String serviceType = input.readUTF();
                    String description = input.readUTF();
                    System.out.println();
                    System.out.println("Request recieved!");
                    System.out.println("Request Id : "+requestId);
                    System.out.println("Customer Id :"+customerId);
                    System.out.println("Service Type : "+serviceType);
                    System.out.println("Description : "+description);
                    String status = null;
                    String message = null;
                    if(customerId.isEmpty()){
                        status = "Rejected!";
                        message = "Customer Id is needed!";
                    }else if(description.isEmpty()){
                        status = "Rejected!";
                        message = "Description is needed!";
                    }else if(serviceType.equalsIgnoreCase("Internet")||serviceType.equalsIgnoreCase("Software")||serviceType.equalsIgnoreCase("Hardware")){
                        status = "Approved!";
                        message = "Service type is approved!";
                    }else {
                        status = "Rejected!";
                        message = "Service type is not supported.";
                    }
                    output.writeInt(requestId);
                    output.writeUTF(status);
                    output.writeUTF(message);
                    output.flush();
                    System.out.println();
                    System.out.println("Response sent!");
                    System.out.println("Request Id :"+requestId);
                    System.out.println("Status : "+status);
                    System.out.println("Message : "+message);
                }
            }
        }catch(IOException e){
            System.out.println("Server error : "+e.getMessage());
        }
    }
}
