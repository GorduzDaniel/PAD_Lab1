package company;

public class Message {
    private String command;
    private String payload;

    public String getPayload(){
        return payload;
    }
    public void setPayload(String payload){
        this.payload = payload;
    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
