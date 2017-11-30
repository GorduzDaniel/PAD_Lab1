
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client implements  Runnable {

    @Override
    public void run() {
        int serverPort = 8888;
        String address = "127.0.0.1";
        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);
            System.out.println("Connection established <@>");

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
                        System.out.println("Message received:" + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            while ((line=keyboard.readLine())!=null){

                System.out.println("Sending this line to server...");
                out.writeUTF(line);
                out.flush();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
