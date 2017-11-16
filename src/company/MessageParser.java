package company;

public class MessageParser {
    public static Message parse(String message){

        String []splitedMessage=message.split(",");
        Message ms = new Message() ;
        if(splitedMessage.length>0)
        ms.setCommand(splitedMessage[0]);

        if(splitedMessage.length>1)
        ms.setPayload(splitedMessage[1]);

        return ms;
    }
}
