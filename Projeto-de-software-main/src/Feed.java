import java.util.ArrayList;
import java.util.List;

public class Feed {
    private VisualizationControl visualizationControl;
    private List<Message> messages;
    private User user;

    public Feed(User user) {
        this.visualizationControl = VisualizationControl.ALL;
        this.messages = new ArrayList<Message>();
    }

    public void sendMessage() {
        // ...
    }

    public void setVisualizationControl(VisualizationControl visualizationControl) {
        this.visualizationControl = visualizationControl;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public List<Message> getMessages() {
        // ...
        if (visualizationControl == VisualizationControl.FRIENDS) {
            // ...
            ArrayList<Message> friendsMessages = new ArrayList<Message>();
            for (Message message : messages) {
                if (!message.getSender().equals(user) && user.getFriends().contains(message.getSender())) {
                    // ...
                    friendsMessages.add(message);
                }
            }
            return friendsMessages;
        } else {
            return messages;
        }
    }
}
