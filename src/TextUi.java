import java.util.Scanner;

public class TextUi {

    private final Scanner scanner;
    private final UserHandler userHandler;

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
        if (userHandler.login(userName, password)) {
            System.out.println("Welcome " + userName);
            System.out.println("Press Enter to check the questionnaire");
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
            createUserMenu();
        }
    }

    public void showId() {
        System.out.println("List of Cancer Program IDs:");
        for (CancerProgram cp : CancerInfo.ciList) {
            System.out.println(cp.getId());
        }
    }

    public void showSymptoms() {
    }

    public void showChances() {
    }
}