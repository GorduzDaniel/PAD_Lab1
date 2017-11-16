package company;

public class CommandMessageManager {
    QueueManager queueManager = new QueueManager();
    Message message = new Message();

    public void execute(Message message){
        if(message == null){
            return;
        }

        if (message.getCommand().equalsIgnoreCase("get")) {
            queueManager.getMessageQueue();
        }
        else if(message.getCommand().equalsIgnoreCase("put")){
            queueManager.addMessage(message.getPayload());
        }

    }
}
