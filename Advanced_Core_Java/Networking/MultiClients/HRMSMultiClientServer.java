package Networking.MultiClients;

import java.io.*;
import java.net.*;

class ClientHandler extends Thread
{
    private Socket socket;
    private String employeeId;

    ClientHandler(Socket socket, String employeeId)
    {
        this.socket = socket;
        this.employeeId = employeeId;
    }

    @Override
    public void run()
    {
        try
        {
            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(),
                    true);

            System.out.println(
                    Thread.currentThread().getName()
                    + " processing " + employeeId);

            output.println(
                    "Employee " + employeeId + " is Active");

            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

public class HRMSMultiClientServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket server = new ServerSocket(5000);

        System.out.println("HRMS Server Started...");

        while (true)
        {
            Socket socket = server.accept();

            System.out.println("Client Connected");

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            PrintWriter output = new PrintWriter(
                    socket.getOutputStream(),
                    true);

            String message = input.readLine();

            if ("EXIT".equals(message))
            {
                output.println("Server stopped waiting for clients.");

                socket.close();

                System.out.println(
                        "Server stopped waiting for clients.");

                break;
            }

            ClientHandler handler =
                    new ClientHandler(socket, message);

            handler.start();
        }

        server.close();

        System.out.println("HRMS Server Closed");
    }
}