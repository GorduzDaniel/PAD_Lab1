package company;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueManager {
   private static Queue messageQueue = new LinkedBlockingQueue() ;

    public String getMessageQueue() {
        return (String) messageQueue.poll();
    }
    public void addMessage(String message){
        messageQueue.add(message);
    }

}
