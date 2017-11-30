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
    }
}

