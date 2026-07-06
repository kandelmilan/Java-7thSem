
// 3. Write a java program using UDP that enables two way communication between client and server
import java.net.*;
public class UDPClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        System.out.println("Client is ready .................");
        //send message:
        String smsg = "Hello I am Client ...........";
        byte [] sdata = smsg.getBytes();
        InetAddress ia = InetAddress.getByName("localhost");
        DatagramPacket dp = new DatagramPacket(sdata, sdata.length,ia,5555);
        ds.send(dp);
        System.out.println("Message is sent from client ............");
        
        //Receive message
        byte[] rdata = new byte[1000];
        DatagramPacket dp1 = new DatagramPacket(rdata,rdata.length);
        ds.receive(dp1);
        String rmsg = new String (dp1.getData(),0,dp1.getLength());
        System.out.println("Received Message:"+rmsg);
        ds.close();
    }
}