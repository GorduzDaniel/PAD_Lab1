import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueManager {

    private QueueManager() {
    }

    private static final QueueManager _INSTANCE = new QueueManager();

    private final BlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(10) ;

    public static synchronized QueueManager getInstance() {
        return _INSTANCE;
    }

    public String getMessageQueue() {
        return messageQueue.poll();
    }
    public void addMessage(String message){
        messageQueue.add(message);
    }

}
