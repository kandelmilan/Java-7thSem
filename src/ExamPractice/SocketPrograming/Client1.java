
import java.net.*;
import java.io.*;

public class Client1 {

    public static void main(String[] args) throws Exception {
        System.out.println("Client Started");
        Socket cs = new Socket("localhost", 55);
        System.out.println("Client Conneceted");
        
        BufferedReader bw=new BufferedReader(new InputStreamReader(cs.getInputStream()));
        
        PrintWriter out=new PrintWriter(cs.getOutputStream(),true);
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            System.out.println("Client :");
            String clientMsg=in.readLine();
            out.println(clientMsg);
            if(clientMsg.equalsIgnoreCase("bye"))
                break;
            
            String serverMsg=bw.readLine();
            System.out.println("Server :" +serverMsg);
            if(serverMsg==null||serverMsg.equalsIgnoreCase("bye"))
                break;
        }
        bw.close();out.close();cs.close();
    }
}
