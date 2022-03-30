public class User { 
    private String login; 
    private String password; 
    private String name; 
 
    public User(String login, String password, String name) { 
        this.login = login; 
        this.password = password; 
        this.name = name; 
    } 
    
    
    public User createUser(String login, String password, String name) { 
        return new User(login, password, name); 
    } 
 
    public User editUser(String login, String password, String name) { 
        return new User(login, password, name); 
    } 
 
    public void sendFriendRequest(User user) { 
        System.out.println("Friend request sent to " + user.getName()); 
    } 
 
    public void acceptFriendRequest(User user) { 
        System.out.println("Friend request accepted by " + user.getName()); 
    } 
 
    public String getLogin() { 
        return login; 
    } 
 
    public void setLogin(String login) { 
        this.login = login; 
    } 
 
    public String getPassword() { 
        return password; 
    } 
 
    public void setPassword(String password) { 
        this.password = password; 
    } 
 
    public String getName() { 
        return name; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
    } 
    public void readMessage(Message message) { 
        System.out.println("Message from " + message.getSender().getName() + ": " + message.getText()); 
    }
    
}
