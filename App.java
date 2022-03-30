import java.util.Scanner;

public class App {

    public static User[] addUser(User[] users, User user) {
        User[] newUsers = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            newUsers[i] = users[i];
        }
        newUsers[users.length] = user;
        return newUsers;
    }

    public static void main(String[] args) throws Exception {

        
        User[] users = new User[0];
        
        System.out.println("Do you want to create an account? (y/n)");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        
        if (answer.equals("y")) {
            System.out.println("Enter your login:");
            String login = scanner.nextLine();
            System.out.println("Enter your password:");
            String password = scanner.nextLine();
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            User user = new User(login, password, name);
            System.out.println("Your account has been created!");
            
            users = addUser(users, user);
        }

        
        while (!answer.equals("exit")) {
            System.out.println(
                    "Do you want to send a message, add a friend, edit your profile or create another account? (send/add/edit/create/exit)");
            answer = scanner.nextLine();
            
            if (answer.equals("send")) {
                
                System.out.println("Enter receiver's login:");
                String receiverLogin = scanner.nextLine();
               
                User receiver = null;
                for (User user : users) {
                    if (user.getLogin().equals(receiverLogin)) {
                        receiver = user;
                    }
                }
                
                if (receiver == null) {
                    System.out.println("User with login " + receiverLogin + " not found!");
                } else {
                   
                    System.out.println("Enter message text:");
                    String text = scanner.nextLine();
                   
                    Message message = new Message(users[0], receiver, text);
                    
                    receiver.readMessage(message);
                }
            }
            
            if (answer.equals("add")) {
                
                System.out.println("Enter receiver's login:");
                String receiverLogin = scanner.nextLine();
                
                User receiver = null;
                for (User user : users) {
                    if (user.getLogin().equals(receiverLogin)) {
                        receiver = user;
                    }
                }
                
                if (receiver == null) {
                    System.out.println("User with login " + receiverLogin + " not found!");
                } else {
                    
                    users[0].sendFriendRequest(receiver);
                }
            }
            
            if (answer.equals("edit")) {

                System.out.println("Enter your login:");
                String login = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();
                
                for (int i = 0; i < users.length; i++) {
                    if (users[i].getLogin().equals(login) && users[i].getPassword().equals(password)) {
                        System.out.println("Enter your new login:");
                        String newLogin = scanner.nextLine();
                        System.out.println("Enter your new password:");
                        String newPassword = scanner.nextLine();
                        System.out.println("Enter your new name:");
                        String newName = scanner.nextLine();
                        User newUser = users[i].editUser(newLogin, newPassword, newName);
                        users[i] = newUser;
                    }
                }
            }

            
            if (answer.equals("create")) {
                System.out.println("Enter your login:");
                String login = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                User user = new User(login, password, name);
                System.out.println("Your account has been created!");
                
                users = addUser(users, user);
            }
        }
    }

}