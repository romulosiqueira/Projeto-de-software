public class User {
    private String login;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String birthday;
    private User[] friends = new User[0];
    private User[] friendsRequests = new User[0];
    private Comunity[] comunities = new Comunity[0];
    private Message[] messages = new Message[0];

    public User(String login, String password, String name) {
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public void addComunity(Comunity comunity) {
        Comunity[] newComunities = new Comunity[comunities.length + 1];
        for (int i = 0; i < comunities.length; i++) {
            newComunities[i] = comunities[i];
        }
        newComunities[comunities.length] = comunity;
        comunities = newComunities;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public User[] getFriends() {
        return this.friends;
    }

    public User[] getFriendRequests() {
        return this.friendsRequests;
    }

    public Message[] getMessages() {
        return this.messages;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void sendFriendRequest(User user) {
        friendsRequests = new User[1];
        friendsRequests[0] = user;
    }

    public String getName() {
        return name;
    }

    public void acceptFriendRequest(User user) {
        friends = new User[1];
        friends[0] = user;
    }

    public void displayFriends() {
        for (int i = 0; i < friends.length; i++) {
            System.out.println(friends[i].getName());
        }
    }

    public void displayFriendsRequests() {
        for (int i = 0; i < friendsRequests.length; i++) {
            System.out.println(friendsRequests[i].getName());
        }
    }

    public void displayUserInfo() {
        System.out.println("Login: " + login);
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("Birthday: " + birthday);
    }

    public void displayComunities() {
        for (int i = 0; i < comunities.length; i++) {
            System.out.println(comunities[i].getName());
        }
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

    public User[] getFriendsRequests() {
        return friendsRequests;
    }

    public void removeFriendRequest(User user) {
        User[] newFriendsRequests = new User[friendsRequests.length - 1];
        int j = 0;
        for (int i = 0; i < friendsRequests.length; i++) {
            if (friendsRequests[i] != user) {
                newFriendsRequests[j] = friendsRequests[i];
                j++;
            }
        }
        friendsRequests = newFriendsRequests;
    }

}
