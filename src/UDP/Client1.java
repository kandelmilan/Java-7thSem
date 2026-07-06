package UDP;

import java.net.*;

public class Client1 {

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket();

        String smsg = "D";

        byte[] sdata = smsg.getBytes();

        InetAddress ia = InetAddress.getByName("localhost");

        DatagramPacket dp = new DatagramPacket(
                sdata,
                sdata.length,
                ia,
                555
        );

        ds.send(dp);

        System.out.println("Character sent from Client 1");

        ds.close();
    }
}