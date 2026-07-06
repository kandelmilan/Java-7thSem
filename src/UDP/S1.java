
import java.net.*;

public class S1 {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(55);

        //receive message
        byte[] rdata = new byte[1000];
        DatagramPacket dp = new DatagramPacket(rdata, rdata.length);
        ds.receive(dp);
        String rmsg = new String(dp.getData(), 0, dp.getLength());

        System.out.println("Received Message :" + rmsg);

        //send message 
        String smsg = "Hello";
        byte[] sdata = smsg.getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(sdata, sdata.length, ia, 55);
        ds.send(dp1);
        System.out.println(" Message Send");
        
        ds.close();
    }
}
