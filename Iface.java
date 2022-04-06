import java.util.Scanner;

public class Iface {
    private User[] users = new User[0];
    private Comunity[] comunities = new Comunity[0];
    private User currentUser;

    public void displayMenu() {

        int userInput;
        do {
            System.out.println("1. Create a new comunity");
            System.out.println("2. Join a comunity");
            System.out.println("3. Create a new message");
            System.out.println("4. Display messages");
            System.out.println("5. Display comunities");
            System.out.println("6. Display users");
            System.out.println("7. Display friends");
            System.out.println("8. Display friends requests");
            System.out.println("9. Send friend request");
            System.out.println("10. Accept friend request");
            System.out.println("11. Decline friend request");
            System.out.println("12. Edit profile");
            System.out.println("13. Delete account");
            System.out.println("14. Logout");
            System.out.println("15. Exit");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    createComunity();
                    break;
                case 2:
                    joinComunity();
                    break;
                case 3:
                    sendMessageToUser();
                    break;
                case 4:
                    displayMessages();
                    break;
                case 5:
                    displayComunities();
                    break;
                case 6:
                    displayUsers();
                    break;
                case 7:
                    displayFriends();
                    break;
                case 8:
                    displayFriendRequests();
                    break;
                case 9:
                    sendFriendRequest();
                    break;
                case 10:
                    acceptFriendRequest();
                    break;
                case 11:
                    declineFriendRequest();
                    break;
                case 12:
                    editProfile();
                    break;
                case 13:
                    deleteAccount();

                    break;
                case 14:
                    logout();

                    break;
                case 15:
                    exit();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (userInput != 13);
    }

    public void editProfile() {
        System.out.println("Enter your new name");
        Scanner scanner = new Scanner(System.in);
        String newName = scanner.nextLine();
        System.out.println("Enter your new surname");
        String newSurname = scanner.nextLine();
        System.out.println("Enter your new email");
        String newEmail = scanner.nextLine();

        System.out.println("Enter your new password");
        String newPassword = scanner.nextLine();
        System.out.println("Enter your new password again");
        String newPasswordAgain = scanner.nextLine();
        if (newPassword.equals(newPasswordAgain)) {
            currentUser.setName(newName);
            currentUser.setSurname(newSurname);
            currentUser.setEmail(newEmail);
            currentUser.setPassword(newPassword);
        } else {
            System.out.println("Passwords do not match");
        }
    }

    public void deleteAccount() {
        System.out.println("Are you sure you want to delete your account? (y/n)");
        // delete user, his messages and his comunities
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.equals("y")) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].getEmail().equals(currentUser.getEmail())) {
                    users[i] = null;
                }
            }
            for (int i = 0; i < comunities.length; i++) {
                if (comunities[i].getOwner().getEmail().equals(currentUser.getEmail())) {
                    comunities[i] = null;
                }
            }
            for (int i = 0; i < users.length; i++) {
                for (int j = 0; j < users[i].getMessages().length; j++) {
                    if (users[i].getMessages()[j].getSender().getEmail().equals(currentUser.getEmail())) {
                        users[i].getMessages()[j] = null;
                    }
                }
            }
            for (int i = 0; i < users.length; i++) {
                for (int j = 0; j < users[i].getMessages().length; j++) {
                    if (users[i].getMessages()[j].getReceiver().getEmail().equals(currentUser.getEmail())) {
                        users[i].getMessages()[j] = null;
                    }
                }
            }
            for (int i = 0; i < users.length; i++) {
                for (int j = 0; j < users[i].getFriends().length; j++) {
                    if (users[i].getFriends()[j].getEmail().equals(currentUser.getEmail())) {
                        users[i].getFriends()[j] = null;
                    }
                }
            }
            for (int i = 0; i < users.length; i++) {
                for (int j = 0; j < users[i].getFriendRequests().length; j++) {
                    if (users[i].getFriendRequests()[j].getEmail().equals(currentUser.getEmail())) {
                        users[i].getFriendRequests()[j] = null;
                    }
                }
            }
        }
    }

    public void createComunity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter comunity name: ");
        String comunityName = scanner.nextLine();
        System.out.println("Enter comunity description: ");
        String comunityDescription = scanner.nextLine();
        Comunity comunity = new Comunity(comunityName, comunityDescription, currentUser);
        comunities = new Comunity[comunities.length + 1];
        for (int i = 0; i < comunities.length; i++) {
            if (i == comunities.length - 1) {
                comunities[i] = comunity;
            } else {
                comunities[i] = comunities[i];
            }
        }
    }

    public void joinComunity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter comunity name: ");
        String comunityName = scanner.nextLine();
        for (int i = 0; i < comunities.length; i++) {
            if (comunities[i].getName().equals(comunityName)) {
                comunities[i].addMember(currentUser);
                currentUser.addComunity(comunities[i]);
                System.out.println("You have joined the comunity: '" + comunityName + "'");
            }
        }
    }

    public void sendMessageToUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Who do you want to send a message to: ");
        String userName = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(userName)) {
                System.out.println("Enter message: ");
                String message = scanner.nextLine();
                Message message1 = new Message(currentUser, users[i], message);
                users[i].addMessage(message1);
            }
        }

    }

    public void displayMessages() {
        currentUser.displayMessages();
    }

    public void displayComunities() {
        currentUser.displayComunities();
    }

    public void displayUsers() {
        for (int i = 0; i < users.length; i++) {
            System.out.println(users[i].getName());
        }
    }

    public void displayFriends() {
        currentUser.displayFriends();
    }

    public void displayFriendRequests() {
        currentUser.displayFriendsRequests();
    }

    public void sendFriendRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getName().equals(userName)) {
                currentUser.sendFriendRequest(users[i]);
            }
        }
    }

    public void acceptFriendRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();
        for (int i = 0; i < currentUser.getFriendsRequests().length; i++) {
            if (currentUser.getFriendsRequests()[i].getName().equals(userName)) {
                currentUser.acceptFriendRequest(users[i]);
                currentUser.removeFriendRequest(currentUser.getFriendsRequests()[i]);
            }
        }
    }

    public void declineFriendRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user name: ");
        String userName = scanner.nextLine();
        for (int i = 0; i < currentUser.getFriendsRequests().length; i++) {
            if (currentUser.getFriendsRequests()[i].getName().equals(userName)) {
                currentUser.removeFriendRequest(currentUser.getFriendsRequests()[i]);
            }
        }
    }

    public void logout() {
        currentUser = null;
    }

    public void exit() {
        System.exit(0);
    }

    public void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login: ");
        String login = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        User user = new User(login, password, name);
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = user;
        users = newUsers;

    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your login: ");
        String name = scanner.nextLine();
        System.out.println("Enter your password: ");
        String email = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (users[i].getLogin().equals(name) && users[i].getPassword().equals(email)) {
                currentUser = users[i];
                System.out.println("You are logged in!");
                displayMenu();
                return;
            }
        }
        System.out.println("Wrong login or password!");
    }

    public void addUser(User user) {
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = user;
        users = newUsers;
    }

    public void addComunity(Comunity comunity) {
        Comunity[] newComunities = new Comunity[comunities.length + 1];
        for (int i = 0; i < comunities.length; i++) {
            newComunities[i] = comunities[i];
        }
        newComunities[comunities.length] = comunity;
        comunities = newComunities;
    }

    public void removeUser(User user) {
        User[] newUsers = new User[users.length - 1];
        int j = 0;
        for (int i = 0; i < users.length; i++) {
            if (users[i] != user) {
                newUsers[j] = users[i];
                j++;
            }
        }
        users = newUsers;
    }

}
