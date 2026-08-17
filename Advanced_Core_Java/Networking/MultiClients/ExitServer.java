package Networking.MultiClients;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ExitServer {
    public static void main(String[] args) throws Exception
    {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader input =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));

        PrintWriter output =
                new PrintWriter(
                        socket.getOutputStream(),
                        true);

        output.println("EXIT");

        System.out.println("Server Response:");
        System.out.println(input.readLine());

        socket.close();
    }
}
