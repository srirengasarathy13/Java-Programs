package Assignments;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Assignment5_ChatApplication {

    // ============================================================
    // ClientHandler
    // ============================================================
    static class ClientHandler implements Runnable {

        private final Socket socket;
        private final ChatServer server;

        private BufferedReader reader;
        private PrintWriter writer;

        private String username;

        public ClientHandler(
                Socket socket,
                ChatServer server) {

            this.socket = socket;
            this.server = server;
        }

        // --------------------------------------------------------
        // Get Username
        // --------------------------------------------------------
        public String getUsername() {
            return username;
        }

        // --------------------------------------------------------
        // Send Message To This Client
        // --------------------------------------------------------
        public void sendMessage(String message) {

            if (writer != null) {
                writer.println(message);
            }
        }

        // --------------------------------------------------------
        // Run
        // --------------------------------------------------------
        @Override
        public void run() {

            try {

                /*
                 * InputStream receives data from the client.
                 */
                InputStream inputStream =
                        socket.getInputStream();

                /*
                 * OutputStream sends data to the client.
                 */
                OutputStream outputStream =
                        socket.getOutputStream();

                /*
                 * BufferedReader makes reading text easier.
                 */
                reader =
                        new BufferedReader(
                                new InputStreamReader(
                                        inputStream
                                )
                        );

                /*
                 * PrintWriter makes sending text easier.
                 */
                writer =
                        new PrintWriter(
                                outputStream,
                                true
                        );

                // ------------------------------------------------
                // Ask for username
                // ------------------------------------------------

                writer.println(
                        "Enter your username:"
                );

                username =
                        reader.readLine();

                if (username == null
                        || username.trim().isEmpty()) {

                    writer.println(
                            "Invalid username."
                    );

                    return;
                }

                username =
                        username.trim();

                // ------------------------------------------------
                // Register client
                // ------------------------------------------------

                server.addClient(this);

                writer.println(
                        "Welcome to the chat, "
                                + username
                                + "!"
                );

                writer.println(
                        "Type /exit to leave the chat."
                );

                writer.println(
                        "Type /status to view JVM status."
                );

                server.broadcast(
                        "[SERVER] "
                                + username
                                + " joined the chat.",
                        this
                );

                // ------------------------------------------------
                // Receive messages
                // ------------------------------------------------

                String message;

                while ((message =
                        reader.readLine()) != null) {

                    message =
                            message.trim();

                    if (message.isEmpty()) {
                        continue;
                    }

                    // --------------------------------------------
                    // /exit
                    // --------------------------------------------

                    if (message.equalsIgnoreCase(
                            "/exit")) {

                        writer.println(
                                "Goodbye, "
                                        + username
                                        + "!"
                        );

                        break;
                    }

                    // --------------------------------------------
                    // /status
                    // --------------------------------------------

                    if (message.equalsIgnoreCase(
                            "/status")) {

                        sendJVMStatus();
                        continue;
                    }

                    // --------------------------------------------
                    // Normal chat message
                    // --------------------------------------------

                    String formattedMessage =
                            username
                                    + " : "
                                    + message;

                    System.out.println(
                            formattedMessage
                    );

                    server.broadcast(
                            formattedMessage,
                            this
                    );
                }

            } catch (IOException e) {

                System.out.println(
                        "Connection error for "
                                + username
                                + " : "
                                + e.getMessage()
                );

            } finally {

                // ------------------------------------------------
                // Remove client
                // ------------------------------------------------

                server.removeClient(this);

                if (username != null) {

                    server.broadcast(
                            "[SERVER] "
                                    + username
                                    + " left the chat.",
                            this
                    );
                }

                closeConnection();
            }
        }

        // --------------------------------------------------------
        // JVM Status
        // --------------------------------------------------------
        private void sendJVMStatus() {

            Runtime runtime =
                    Runtime.getRuntime();

            long availableProcessors =
                    runtime.availableProcessors();

            long totalMemory =
                    runtime.totalMemory();

            long freeMemory =
                    runtime.freeMemory();

            long maxMemory =
                    runtime.maxMemory();

            sendMessage(
                    "================ JVM STATUS ================"
            );

            sendMessage(
                    "Available Processors : "
                            + availableProcessors
            );

            sendMessage(
                    "Total Memory         : "
                            + formatMemory(totalMemory)
            );

            sendMessage(
                    "Free Memory          : "
                            + formatMemory(freeMemory)
            );

            sendMessage(
                    "Used Memory          : "
                            + formatMemory(
                                    totalMemory
                                            - freeMemory
                            )
            );

            sendMessage(
                    "Max Memory           : "
                            + formatMemory(maxMemory)
            );

            sendMessage(
                    "============================================"
            );
        }

        // --------------------------------------------------------
        // Format Memory
        // --------------------------------------------------------
        private String formatMemory(long bytes) {

            double megabytes =
                    bytes / (1024.0 * 1024.0);

            return String.format(
                    "%.2f MB",
                    megabytes
            );
        }

        // --------------------------------------------------------
        // Close Connection
        // --------------------------------------------------------
        private void closeConnection() {

            try {

                if (reader != null) {
                    reader.close();
                }

                if (writer != null) {
                    writer.close();
                }

                if (socket != null
                        && !socket.isClosed()) {

                    socket.close();
                }

            } catch (IOException e) {

                System.out.println(
                        "Error closing connection: "
                                + e.getMessage()
                );
            }
        }
    }

    // ============================================================
    // ChatServer
    // ============================================================
    static class ChatServer {

        private final int port;

        private ServerSocket serverSocket;

        /*
         * CopyOnWriteArrayList is used because multiple client
         * handler threads can add/remove clients while another
         * thread is broadcasting messages.
         */
        private final List<ClientHandler> clients =
                new CopyOnWriteArrayList<>();

        private volatile boolean running = true;

        public ChatServer(int port) {
            this.port = port;
        }

        // --------------------------------------------------------
        // Start Server
        // --------------------------------------------------------
        public void start() {

            try {

                serverSocket =
                        new ServerSocket(port);

                System.out.println();
                System.out.println(
                        "================================================"
                );

                System.out.println(
                        "              CHAT SERVER STARTED"
                );

                System.out.println(
                        "================================================"
                );

                System.out.println(
                        "Port : "
                                + port
                );

                System.out.println();
                System.out.println(
                        "Waiting for clients..."
                );

                // ------------------------------------------------
                // Accept Clients
                // ------------------------------------------------

                while (running) {

                    Socket clientSocket =
                            serverSocket.accept();

                    System.out.println(
                            "New client connected: "
                                    + clientSocket
                                            .getInetAddress()
                    );

                    /*
                     * Create a separate ClientHandler thread
                     * for every client.
                     */
                    ClientHandler clientHandler =
                            new ClientHandler(
                                    clientSocket,
                                    this
                            );

                    Thread clientThread =
                            new Thread(
                                    clientHandler,
                                    "ClientHandler-"
                                            + (clients.size() + 1)
                            );

                    clientThread.start();
                }

            } catch (IOException e) {

                if (running) {

                    System.out.println(
                            "Server error: "
                                    + e.getMessage()
                    );
                }

            } finally {

                stop();
            }
        }

        // --------------------------------------------------------
        // Add Client
        // --------------------------------------------------------
        public void addClient(
                ClientHandler client) {

            clients.add(client);

            System.out.println(
                    "Client joined: "
                            + client.getUsername()
            );

            System.out.println(
                    "Online Clients: "
                            + clients.size()
            );
        }

        // --------------------------------------------------------
        // Remove Client
        // --------------------------------------------------------
        public void removeClient(
                ClientHandler client) {

            clients.remove(client);

            System.out.println(
                    "Client disconnected: "
                            + client.getUsername()
            );

            System.out.println(
                    "Online Clients: "
                            + clients.size()
            );
        }

        // --------------------------------------------------------
        // Broadcast
        // --------------------------------------------------------
        public void broadcast(
                String message,
                ClientHandler sender) {

            for (ClientHandler client
                    : clients) {

                /*
                 * Send to all clients except the sender.
                 */
                if (client != sender) {

                    client.sendMessage(
                            message
                    );
                }
            }
        }

        // --------------------------------------------------------
        // Stop Server
        // --------------------------------------------------------
        public void stop() {

            running = false;

            try {

                if (serverSocket != null
                        && !serverSocket.isClosed()) {

                    serverSocket.close();
                }

            } catch (IOException e) {

                System.out.println(
                        "Error stopping server: "
                                + e.getMessage()
                );
            }
        }
    }

    // ============================================================
    // ChatClient
    // ============================================================
    static class ChatClient {

        private final String host;
        private final int port;

        private Socket socket;

        private BufferedReader serverReader;
        private PrintWriter serverWriter;

        private volatile boolean running = true;

        public ChatClient(
                String host,
                int port) {

            this.host = host;
            this.port = port;
        }

        // --------------------------------------------------------
        // Start Client
        // --------------------------------------------------------
        public void start() {

            try {

                // ------------------------------------------------
                // Connect to Server
                // ------------------------------------------------

                socket =
                        new Socket(
                                host,
                                port
                        );

                System.out.println();
                System.out.println(
                        "Connected to chat server."
                );

                /*
                 * InputStream receives data from server.
                 */
                InputStream inputStream =
                        socket.getInputStream();

                /*
                 * OutputStream sends data to server.
                 */
                OutputStream outputStream =
                        socket.getOutputStream();

                serverReader =
                        new BufferedReader(
                                new InputStreamReader(
                                        inputStream
                                )
                        );

                serverWriter =
                        new PrintWriter(
                                outputStream,
                                true
                        );

                // ------------------------------------------------
                // Receive Thread
                // ------------------------------------------------

                Thread receiveThread =
                        new Thread(
                                this::receiveMessages,
                                "ChatClient-Receive"
                        );

                receiveThread.start();

                // ------------------------------------------------
                // Send Thread
                // ------------------------------------------------

                Thread sendThread =
                        new Thread(
                                this::sendMessages,
                                "ChatClient-Send"
                        );

                sendThread.start();

                /*
                 * Wait for sending thread to finish.
                 */
                sendThread.join();

                running = false;

                /*
                 * Wait for receiving thread.
                 */
                receiveThread.join();

            } catch (IOException e) {

                System.out.println(
                        "Unable to connect to server: "
                                + e.getMessage()
                );

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "Client interrupted."
                );

            } finally {

                closeConnection();
            }
        }

        // --------------------------------------------------------
        // Receive Messages
        // --------------------------------------------------------
        private void receiveMessages() {

            try {

                String message;

                while (running
                        && (message =
                        serverReader.readLine()) != null) {

                    System.out.println(
                            message
                    );
                }

            } catch (IOException e) {

                if (running) {

                    System.out.println(
                            "Connection to server lost."
                    );
                }
            }
        }

        // --------------------------------------------------------
        // Send Messages
        // --------------------------------------------------------
        private void sendMessages() {

            Scanner scanner =
                    new Scanner(System.in);

            try {

                while (running) {

                    String message =
                            scanner.nextLine();

                    if (message == null) {
                        continue;
                    }

                    serverWriter.println(
                            message
                    );

                    /*
                     * If the user types /exit,
                     * stop the client after sending it.
                     */
                    if (message.equalsIgnoreCase(
                            "/exit")) {

                        running = false;
                        break;
                    }
                }

            } catch (Exception e) {

                if (running) {

                    System.out.println(
                            "Error sending message: "
                                    + e.getMessage()
                    );
                }
            }
        }

        // --------------------------------------------------------
        // Close Connection
        // --------------------------------------------------------
        private void closeConnection() {

            running = false;

            try {

                if (serverReader != null) {
                    serverReader.close();
                }

                if (serverWriter != null) {
                    serverWriter.close();
                }

                if (socket != null
                        && !socket.isClosed()) {

                    socket.close();
                }

            } catch (IOException e) {

                System.out.println(
                        "Error closing client connection: "
                                + e.getMessage()
                );
            }
        }
    }

    // ============================================================
    // Main
    // ============================================================
    public static void main(String[] args) {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "        MULTI-CLIENT SOCKET CHAT"
        );

        System.out.println(
                "================================================"
        );

        Scanner scanner =
                new Scanner(System.in);

        System.out.println();
        System.out.println(
                "1. Start Chat Server"
        );

        System.out.println(
                "2. Start Chat Client"
        );

        System.out.print(
                "Enter your choice: "
        );

        String choice =
                scanner.nextLine().trim();

        // ========================================================
        // Server
        // ========================================================

        if (choice.equals("1")) {

            System.out.print(
                    "Enter server port [5000]: "
            );

            String portInput =
                    scanner.nextLine().trim();

            int port = 5000;

            if (!portInput.isEmpty()) {

                try {

                    port =
                            Integer.parseInt(
                                    portInput
                            );

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Invalid port. Using 5000."
                    );
                }
            }

            ChatServer server =
                    new ChatServer(port);

            server.start();
        }

        // ========================================================
        // Client
        // ========================================================

        else if (choice.equals("2")) {

            System.out.print(
                    "Enter server host [localhost]: "
            );

            String host =
                    scanner.nextLine().trim();

            if (host.isEmpty()) {
                host = "localhost";
            }

            System.out.print(
                    "Enter server port [5000]: "
            );

            String portInput =
                    scanner.nextLine().trim();

            int port = 5000;

            if (!portInput.isEmpty()) {

                try {

                    port =
                            Integer.parseInt(
                                    portInput
                            );

                } catch (NumberFormatException e) {

                    System.out.println(
                            "Invalid port. Using 5000."
                    );
                }
            }

            ChatClient client =
                    new ChatClient(
                            host,
                            port
                    );

            client.start();
        }

        // ========================================================
        // Invalid Choice
        // ========================================================

        else {

            System.out.println(
                    "Invalid choice."
            );
        }

        scanner.close();
    }
}