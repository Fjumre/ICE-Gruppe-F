
import java.util.Scanner;

public class TextUi {


    static Scanner scanner = new Scanner(System.in);
    static UserHandler userHandler;

    public TextUi(UserHandler userHandler) {
        this.userHandler = userHandler;
        this.scanner = new Scanner(System.in);
    }

    public static String getUserInput() {
        System.out.println("Hello. Would you like to 1) Log in or 2) Create user? Please write 1 or 2 and press Enter.");
        return scanner.nextLine();
    }

    public String loginMenu() {

        System.out.println("Please enter your username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password: ");
        String password = scanner.nextLine();
        if (UserHandler.login(userName, password)) {
            System.out.println("Welcome " + userName);
            return scanner.nextLine();
        } else {

            System.out.println("Sorry, the username or password is incorrect");
            return loginMenu();
        }
    }



    public void createUserMenu() {

        System.out.println("Please enter a username: ");
        String userName = scanner.nextLine();
        System.out.println("Please enter a password: ");
        String password = scanner.nextLine();
        if (userHandler.createUser(userName, password)) {

            userHandler.saveUsers();
            System.out.println("Welcome " + userName);
        } else {
            System.out.println("Sorry, the username or password can not be used");
        }

    }
}
