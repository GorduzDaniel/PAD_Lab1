package company;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements  Runnable {

    @Override
    public void run() {
        int serverPort = 8888;
        String address = "127.0.0.1";
        QueueManager queueManager = new QueueManager();
        try {
            InetAddress ipAddress = InetAddress.getByName(address);
            System.out.println("Any of you heard of a socket with IP address " + address + " and port " + serverPort + "?");

            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Conectat <3");

            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            BufferedReader keyboard = new BufferedReader( new InputStreamReader(System.in));
            String line = null;

            new Thread(()->{

                String response;
                try {
                    while ((response=in.readUTF())!=null) {
                        System.out.println("primit message:" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

            while ((line=keyboard.readLine())!=null){

                System.out.println("Seding this line to server...");
                out.writeUTF(line);
                out.flush();

            }




        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
