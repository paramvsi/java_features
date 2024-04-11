package multithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
A common real-world example of multithreading in use is a web server handling multiple client requests
simultaneously. Each request is handled by a separate thread, allowing the server to serve multiple clients
concurrently. Here's a simplified version of how this might be implemented in Java:
*/
public class Th04ClientServerExample {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080.");

        while (true) {
            // Accept a client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create a new thread to handle the client request
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clientHandler.start();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    // Echo the received message back to the client
                    out.println("Server response: " + inputLine);
                    if ("bye".equalsIgnoreCase(inputLine)) {
                        break;
                    }
                }

                in.close();
                out.close();
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


