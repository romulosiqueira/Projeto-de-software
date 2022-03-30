public class Message {
    private User sender;
    private User receiver;
    private String text;
    public Message(User sender, User receiver, String text){
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
    }
    public User getSender(){
        return sender;
    }
    public void setSender(User sender){
        this.sender = sender;
    }
     public User getReceiver(){

        return receiver;

    }
    public void setReceiver(User receiver){
        this.receiver = receiver;
    }
    public String getText(){
        return text;
    }
}