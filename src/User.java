import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User extends Account implements Profile {
    private String nickname;
    private List<User> friendRequests;
    private List<User> friends;
    private List<Message> messages;
    private List<Community> communities;

    public User(String nickname, String login, String password) {
        super(login, password);
        this.nickname = nickname;
        this.friendRequests = new ArrayList<User>();
        this.friends = new ArrayList<User>();
        this.messages = new ArrayList<Message>();
        this.communities = new ArrayList<Community>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogin() {
        return super.getLogin();
    }

    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void getProfile() {
        // TODO Auto-generated method stub
    }

    @Override
    public void createProfile() {
        // TODO Auto-generated method stub

    }

    @Override
    public void editProfile() {
        // TODO Auto-generated method stub
    }

    public void addFriend(User user) {
        // TODO Auto-generated method stub

        user.friendRequests.add(this);
        System.out.println("Friend request sent");
    }

    public void acceptFriendRequest(User user) {
        // TODO Auto-generated method stub
        this.friends.add(user);
    }

    public void rejectFriendRequest(User user) {
        // TODO Auto-generated method stub
        this.friendRequests.remove(user);
        System.out.println("Friend request rejected");
    }

    public void sendMesaage(User user) {
        // TODO Auto-generated method stub

    }

    public void sendMesaageToCommunity(Community community) {
        // TODO Auto-generated method stub

    }

    public void createCommunity(Community community) {
        // TODO Auto-generated method stub

    }

    public void menageCommunity(Community community) {
        // TODO Auto-generated method stub

    }

    public void joinCommunity(Community community) {
        // TODO Auto-generated method stub

    }

    public List<User> getFriendRequests() {
        return this.friendRequests;
    }

    public void sendMessageToFriend(User user) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message: ");
        String message = scanner.nextLine();
        user.addMessage(new Message(message, this, user));
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public void addCommunity(Community community) {
        this.communities.add(community);
    }

    public void sendMessageToCommunity(Community community) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message: ");
        String message = scanner.nextLine();
        community.addMessage(new Message(message, this, community));
    }

    public void sendMessageToFeed(Feed feed) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your message: ");
        String message = scanner.nextLine();
        feed.addMessage(new Message(message, this, feed));
    }

    public List<Community> getComunities() {
        return this.communities;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public List<User> getFriends() {
        return this.friends;
    }

}
