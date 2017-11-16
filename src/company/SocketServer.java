package company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class SocketServer implements Runnable {
    private final Map<Socket, ServerClient> socketClientMap = new ConcurrentHashMap<>();
    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while(true){
                Socket socket = serverSocket.accept();
                ServerClient client = new ServerClient(socket);
                socketClientMap.put(socket,client);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

 /*       try {

            System.out.println("Asteptam clientul.......");
            Socket socket = serverSocket.accept();
            System.out.println("Client conectat");
            System.out.println();

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
        }*/
        }
    }

