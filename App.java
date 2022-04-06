import java.io.Console;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // ask if user wants to create a new user or login until user enters "q"
        Iface iface = new Iface();
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        while (!userInput.equals("q")) {
            System.out.println("Do you want to create a new user or login? (c/l/q)");
            userInput = scanner.nextLine();
            if (userInput.equals("c")) {
                iface.createUser();
            } else if (userInput.equals("l")) {
                iface.login();
            }
        }

    }

}