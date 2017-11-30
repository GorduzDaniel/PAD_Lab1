import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient implements Runnable {

    private final Socket socket;

    private final QueueManager queueManager = QueueManager.getInstance();

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

                System.out.println("Message received:" + line);
                Message message = MessageParser.parse(line);

                if(message.getCommand().equalsIgnoreCase("put")){
                    System.out.println("<@>Inserting:" + message.getPayload());
                    queueManager.addMessage(message.getPayload());
                }
                else if(message.getCommand().equalsIgnoreCase("get")){

                    String  messagePayload=queueManager.getMessageQueue();

                    out.writeUTF(messagePayload);
                    out.flush();

                    System.out.println("<@>Returning:" + messagePayload);

                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
