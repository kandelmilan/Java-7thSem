//2. Write a java program using TCP that enables chatting between client and Server.
import java.net.*;
import java.io.*;

public class TCPServer {

    public static void main(String[] args) throws Exception {

        // Step 1: Start server
        System.out.println("Server Started...");

        // Step 2: Create ServerSocket on port 8080
        ServerSocket ss = new ServerSocket(8080);

        System.out.println("Waiting for Client...");

        // Step 3: Accept client connection (blocking call)
        Socket cs = ss.accept();

        System.out.println("Client Connected!");

        // Step 4: Read data coming from client
        BufferedReader br = new BufferedReader(
                new InputStreamReader(cs.getInputStream()));

        // Step 5: Send data to client
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

        // Step 6: Read data from keyboard (server side input)
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));

        // Step 7: Chat loop
        while (true) {

            // Read message from client
            String clientMsg = br.readLine();
            System.out.println("Client: " + clientMsg);

            // Check exit condition
            if (clientMsg == null || clientMsg.equalsIgnoreCase("bye"))
                break;

            // Send reply to client
            System.out.print("Server: ");
            String serverMsg = in.readLine();
            out.println(serverMsg);

            // Exit condition
            if (serverMsg.equalsIgnoreCase("bye"))
                break;
        }

        // Step 8: Close resources
        br.close();
        out.close();
        cs.close();
        ss.close();

        System.out.println("Server Closed...");
    }
}