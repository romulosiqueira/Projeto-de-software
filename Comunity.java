public class Comunity {
    private String name;
    private String description;
    private User admin;
    private User[] members = new User[0];
    private Message[] messages = new Message[0];

    public Comunity(String name, String description, User admin) {
        this.name = name;
        this.description = description;
        this.admin = admin;

    }

    public String getName() {
        return name;
    }

    public User getOwner() {
        return admin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public User[] getMembers() {
        return members;
    }

    public void setMembers(User[] members) {
        this.members = members;
    }

    public void addMember(User member) {
        User[] newMembers = new User[members.length + 1];
        for (int i = 0; i < members.length; i++) {
            newMembers[i] = members[i];
        }
        newMembers[members.length] = member;
        members = newMembers;
    }

    public void displayMessages() {
        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i].getSender().getName() + ": " + messages[i].getText());
        }
    }

    public void addMessage(Message message) {
        Message[] newMessages = new Message[messages.length + 1];
        for (int i = 0; i < messages.length; i++) {
            newMessages[i] = messages[i];
        }
        newMessages[messages.length] = message;
        messages = newMessages;
    }

    public void displayMembers() {
        for (int i = 0; i < members.length; i++) {
            System.out.println(members[i].getName());
        }
    }

}
