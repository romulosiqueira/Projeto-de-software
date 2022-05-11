import java.util.List;

public class Community {
    private String name;
    private User owner;
    private List<User> members;
    private List<Message> messages;

    public Community(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

}
