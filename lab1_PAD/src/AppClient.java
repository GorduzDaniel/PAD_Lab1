public class AppClient {
    public static void main(String[] args){
        Client client = new Client();
        Thread clientThread = new Thread(client);
        clientThread.start();
    }
}