public class Message {
    private String text;
    private User sender;
    private User recipient;
    private Community community;
    private Feed feed;

    public Message(String text, User sender, User recipient) {
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
    }

    public Message(String text, User sender, Community community) {
        this.text = text;
        this.sender = sender;
        this.community = community;
    }

    public Message(String text, User sender, Feed feed) {
        this.text = text;
        this.sender = sender;
        this.feed = feed;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

}
