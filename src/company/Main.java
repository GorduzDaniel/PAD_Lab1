package company;

public class Main {

    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        Thread socketThread = new Thread(socketServer);
        socketThread.start();
    }
}
