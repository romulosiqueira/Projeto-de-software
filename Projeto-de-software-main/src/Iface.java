import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Iface {
    private User loggedUser;
    private List<User> users;
    private List<Community> communities;
    private Feed feed;

    public Iface() {
        users = new ArrayList<User>();
        communities = new ArrayList<Community>();
        feed = new Feed(loggedUser);
    }

    public void displayLoginMenu() {
        // display a menu asking if user wants to login or create an account
        System.out.println("1. Login");
        System.out.println("2. Create an account");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                displayLoginMenu();
        }
    }

    public void login() {
        // ask for email and password
        // if email and password are correct, display main menu
        // if email and password are incorrect, display error message
        System.out.println("Enter login: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        for (User user : users) {
            if (user.getLogin().equals(email) && user.getPassword().equals(password)) {
                loggedUser = user;
                displayMainMenu();
                return;
            }
        }
        System.out.println("Invalid login or password");
        displayLoginMenu();
    }

    public void createAccount() {
        // ask for email, nickname, password
        // create a new user with the given information
        // display main menu
        System.out.println("Enter login: ");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        System.out.println("Enter nickname: ");
        String nickname = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(nickname, login, password);
        users.add(user);
        loggedUser = user;
        displayMainMenu();
    }

    public void displayMainMenu() {
        // display a menu asking if user wants to edit profile, view profile, add
        // friend, send invitation, accept invitation, reject invitation, logout
        System.out.println("1. Edit profile");
        System.out.println("2. View profile");
        System.out.println("3. Send Friend Request");
        System.out.println("4. View Friend Requests");
        System.out.println("5. Send Message");
        System.out.println("6. Create Comunity");
        System.out.println("7. View Comunities");
        System.out.println("8. View Feed");
        System.out.println("9. Change Feed Settings");
        System.out.println("10. Delete Account");
        System.out.println("11. Logout");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                editProfile();
                break;
            case 2:
                viewProfile();
                break;
            case 3:
                addFriend();
                break;
            case 4:
                viewFriendRequests();
                break;
            case 5:
                sendMessage();
                break;
            case 6:
                createComunity();
                break;
            case 7:
                viewComunities();
                break;
            case 8:
                viewFeed();
                break;
            case 9:
                changeFeedVisualizationControl();
                break;
            case 10:
                deleteUser();
                break;
            case 11:
                logout();
                break;
            default:
                System.out.println("Invalid choice");
                displayMainMenu();
        }

    }

    public void editProfile() {
        // ask for nickname
        // if nickname is empty, display error message
        // if nickname is not empty, set nickname to the given nickname
        // display main menu
        System.out.println("Enter nickname: ");
        Scanner scanner = new Scanner(System.in);
        String nickname = scanner.nextLine();
        if (nickname.isEmpty()) {
            System.out.println("Nickname cannot be empty");
            displayMainMenu();
        } else {
            loggedUser.setNickname(nickname);
            displayMainMenu();
        }
    }

    public void viewProfile() {
        // display profile of the logged user
        // display main menu

        System.out.println("Nickname: " + loggedUser.getNickname());
        System.out.println("Login: " + loggedUser.getLogin());
        System.out.println("Password: " + loggedUser.getPassword());

        // ask if user wants to see friends or messages or communities
        System.out.println("1. View friends");
        System.out.println("2. View messages");
        System.out.println("3. View communities");
        System.out.println("4. Back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                viewFriends();
                break;
            case 2:
                viewMessages();
                break;
            case 3:
                viewComunities();
                break;
            case 4:
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                displayMainMenu();
        }
    }

    public void addFriend() {
        // ask for email
        // if email is empty, display error message
        // if email is not empty, send invitation to the user with the given email
        // display main menu
        System.out.println("Enter login: ");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        if (login.isEmpty()) {
            System.out.println("Login cannot be empty");
            displayMainMenu();
        } else {
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    loggedUser.addFriend(user);
                    displayMainMenu();
                    return;
                }
            }
            System.out.println("User with the given login does not exist");
            displayMainMenu();
        }
    }

    public void viewFriendRequests() {
        // display friend requests of the logged user
        // display main menu
        System.out.println("Friend requests: ");
        for (User user : loggedUser.getFriendRequests()) {
            // display friend requests and the ability to reject or accept

            System.out.println(user.getLogin());

            // ask user to choose a friend request and accept or reject
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. Accept");
            System.out.println("2. Reject");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loggedUser.acceptFriendRequest(user);
                    break;
                case 2:
                    loggedUser.rejectFriendRequest(user);
                    break;
                default:
                    System.out.println("Invalid choice");
                    viewFriendRequests();
            }
        }
        displayMainMenu();
    }

    public void sendMessage() {
        // ask if user wants to send message to a friend or to a community or to the
        // feed
        // ask for email
        // if email is empty, display error message
        // if email is not empty, send message to the user with the given email
        // display main menu
        System.out.println("1. Send message to a friend");
        System.out.println("2. Send message to a community");
        System.out.println("3. Send message to the feed");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sendMessageToFriend();
                break;
            case 2:
                sendMessageToCommunity();
                break;
            case 3:
                sendMessageToFeed();
                break;
            default:
                System.out.println("Invalid choice");
                displayMainMenu();
        }

    }

    public void sendMessageToFriend() {
        // ask for email
        // if email is empty, display error message
        // if email is not empty, send message to the user with the given email
        // display main menu
        System.out.println("Enter login: ");
        Scanner scanner = new Scanner(System.in);
        String login = scanner.nextLine();
        if (login.isEmpty()) {
            System.out.println("Email cannot be empty");
            displayMainMenu();
        } else {
            for (User user : users) {
                if (user.getLogin().equals(login)) {
                    loggedUser.sendMessageToFriend(user);
                    displayMainMenu();
                    return;
                }
            }
            System.out.println("User with the given email does not exist");
            displayMainMenu();
        }
    }

    public void sendMessageToCommunity() {
        // ask for community name
        // if community name is empty, display error message
        // if community name is not empty, send message to the community with the
        // given name
        // display main menu
        System.out.println("Enter community name: ");
        Scanner scanner = new Scanner(System.in);
        String communityName = scanner.nextLine();
        if (communityName.isEmpty()) {
            System.out.println("Community name cannot be empty");
            displayMainMenu();
        } else {
            for (Community community : communities) {
                if (community.getName().equals(communityName)) {
                    loggedUser.sendMessageToCommunity(community);
                    displayMainMenu();
                    return;
                }
            }
            System.out.println("Community with the given name does not exist");
            displayMainMenu();
        }
    }

    public void sendMessageToFeed() {
        // ask for message
        // if message is empty, display error message
        // if message is not empty, send message to the feed
        // display main menu

        loggedUser.sendMessageToFeed(feed);
        displayMainMenu();
    }

    public void createComunity() {
        // ask for community name
        // if community name is empty, display error message
        // if community name is not empty, create a new community with the given
        // name
        // display main menu
        System.out.println("Enter community name: ");
        Scanner scanner = new Scanner(System.in);
        String communityName = scanner.nextLine();
        if (communityName.isEmpty()) {
            System.out.println("Community name cannot be empty");
            displayMainMenu();
        } else {
            Community community = new Community(communityName, loggedUser);
            communities.add(community);
            loggedUser.addCommunity(community);
            displayMainMenu();
        }
    }

    public void viewComunities() {
        // display comunities of the logged user
        // display main menu
        System.out.println("Comunities: ");
        for (Community community : loggedUser.getComunities()) {
            System.out.println(community.getName());
        }
        // ask if he wants to join a comunity
        System.out.println("1. Join a comunity");
        System.out.println("2. Back");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                joinComunity();
                break;
            case 2:
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                displayMainMenu();
        }

    }

    public void joinComunity() {
        // ask for community name
        // if community name is empty, display error message
        // if community name is not empty, join the community with the given name
        // display main menu
        System.out.println("Enter community name: ");
        Scanner scanner = new Scanner(System.in);
        String communityName = scanner.nextLine();
        if (communityName.isEmpty()) {
            System.out.println("Community name cannot be empty");
            displayMainMenu();
        } else {
            for (Community community : communities) {
                if (community.getName().equals(communityName)) {
                    loggedUser.joinCommunity(community);
                    displayMainMenu();
                    return;
                }
            }
            System.out.println("Community with the given name does not exist");
            displayMainMenu();
        }
    }

    public void viewFeed() {
        // display feed of the logged user
        // display main menu
        System.out.println("Feed: ");
        for (Message message : this.getFeed()) {
            System.out.println(message.getText());
        }
        displayMainMenu();
    }

    public void changeFeedVisualizationControl() {
        // ask for if he wants to see the message from friends or all

        // display main menu
        System.out.println("1. Show messages from friends");
        System.out.println("2. Show all messages");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                feed.setVisualizationControl(VisualizationControl.FRIENDS);
                displayMainMenu();
                break;
            case 2:
                feed.setVisualizationControl(VisualizationControl.ALL);
                displayMainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                displayMainMenu();
        }

        // if (feedVisualizationControl.isEmpty()) {
        // System.out.println("Feed visualization control cannot be empty");
        // displayMainMenu();
        // } else {
        // loggedUser.setFeedVisualizationControl(feedVisualizationControl);
        // displayMainMenu();
        // }

    }

    public void viewFriends() {
        // display friends of the logged user
        // display main menu
        System.out.println("Friends: ");
        for (User friend : loggedUser.getFriends()) {
            System.out.println(friend.getLogin());
        }
        displayMainMenu();
    }

    public void viewMessages() {

        // display messages of the logged user
        // display main menu
        System.out.println("Messages: ");
        for (Message message : loggedUser.getMessages()) {
            System.out.println(message.getText());
        }
        displayMainMenu();
    }

    public void logout() {
        // logout the logged user
        // display main menu
        loggedUser = null;
        displayLoginMenu();
    }

    public void exit() {
        // exit the program
        System.out.println("Bye!");
        System.exit(0);
    }

    public void deleteUser() {

        // ask for user name
        // if user name is empty, display error message
        // if user name is not empty, delete the user with the given name
        // display main menu

        System.out.println("Enter your password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (password.isEmpty()) {
            System.out.println("User name cannot be empty");
            displayMainMenu();
        } else {
            for (User user : users) {
                if (user.getPassword().equals(password)) {
                    users.remove(user);
                    displayLoginMenu();
                    return;
                }
            }
            System.out.println("User with the given name does not exist");
            displayMainMenu();
        }
    }

    public List<Message> getFeed() {
        return this.feed.getMessages();
    }

}
