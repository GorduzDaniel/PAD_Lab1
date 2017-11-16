package company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient implements Runnable {

    private final Socket socket;

    public ServerClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream sin = socket.getInputStream();
            OutputStream sout = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sin);
            DataOutputStream out = new DataOutputStream(sout);

            String line = null;

            while((line=in.readUTF())!=null){

                System.out.println("primit message:" + line);
                Message message = MessageParser.parse(line);
                QueueManager queueManager = new QueueManager();

                if(message.getCommand().equals("put")){
                    System.out.println("inseram:" + message.getPayload());
                    queueManager.addMessage(message.getPayload());
                }
                else if(message.getCommand().equals("get")){

                    String  messagePayload=queueManager.getMessageQueue();

                    out.writeUTF(messagePayload);
                    out.flush();

                    System.out.println("returnam:" + messagePayload);

                }

            }


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
