package ExamPractice.SocketPrograming;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws Exception {

        // Step 1: Start client
        System.out.println("Client Started...");

        // Step 2: Connect to server (localhost = same machine)
        Socket cs = new Socket("localhost", 8080);

        System.out.println("Connected to Server!");

        // Step 3: Read data from server
        BufferedReader br = new BufferedReader(
                new InputStreamReader(cs.getInputStream()));

        // Step 4: Send data to server
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);

        // Step 5: Read keyboard input (client side)
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));

        // Step 6: Chat loop
        while (true) {

            // Send message to server
            System.out.print("Client: ");
            String clientMsg = in.readLine();
            out.println(clientMsg);

            // Exit condition
            if (clientMsg.equalsIgnoreCase("bye"))
                break;

            // Read response from server
            String serverMsg = br.readLine();
            System.out.println("Server: " + serverMsg);

            // Exit condition
            if (serverMsg == null || serverMsg.equalsIgnoreCase("bye"))
                break;
        }

        // Step 7: Close resources
        br.close();
        out.close();
        cs.close();

        System.out.println("Client Closed...");
    }
}