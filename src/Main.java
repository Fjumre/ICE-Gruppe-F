import java.util.List;
import java.util.Scanner;

public class Main {
    static UserHandler userhandler = new UserHandler("user.txt");
    static TextUi textUi = new TextUi(userhandler);
    static List<CancerInfo> ciList = DBConnector.getCancerData();
    static boolean showCancer = false;
    static boolean showChance = false;
    static boolean showSymptoms = false;
    static boolean showId = false;
    private static int chosenOption;

    public static void main(String[] args) {
        //List<User> users= DBConnector.createUser();
        UserHandler userhandler = new UserHandler("user.txt");
        TextUi textUi = new TextUi(userhandler);


        try {
            userhandler.loadUsers();
        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Desværre kan vi ikke køre programmet lige nu");
            System.exit(0);

        }
        giveUserOptions();
    }


    private static void giveUserOptions() {

        String userInput = TextUi.getUserInput();
        System.out.println(userInput);
        switch (userInput) {
            case "1":
                textUi.loginMenu();
                break;
            case "2":
                textUi.createUserMenu();
                break;
            default:
                System.out.println("Wrong input, please try again");
                giveUserOptions();
        }

        Scanner sc = new Scanner(System.in);
        boolean loginMenu = true;

        if (loginMenu) {
            System.out.println("In the following questioner, answer Yes with Y or No with N");
            String a1, a2, a3;

            System.out.println("Do you smoke? (y/n)");
            System.out.print("");
            a1 = sc.nextLine();  // consume the newline character

            System.out.println("Do you regularly do any form for exercise or motion? (y/n)");
            System.out.print("");
            a2 = sc.nextLine();

            System.out.println("Do you take any type of sun bath or walk under the sun at least 4 hours a day? (y/n)");
            System.out.print("");
            a3 = sc.nextLine();

            System.out.println("Your answers: ");
            System.out.println("Question 1: " + a1);
            System.out.println("Question 2: " + a2);
            System.out.println("Question 3: " + a3);

            sc.close();

        }

        if (showCancer) {
            for (int i = 1; i <= ciList.size(); i++) {
                System.out.println(i + " " + ciList.get(i - 1).getName());
            }
            try {
                chosenOption = Integer.parseInt(TextUi.scanner.nextLine());
                String st = ciList.get(chosenOption - 1).getName();
                System.out.println("You have chosen: " + st);
                showCancer = false;
            } catch (NumberFormatException e) {
                System.out.println("Your input is not valid, please try again.");
            }

            if (showChance) {
                for (int i = 1; i <= ciList.size(); i++) {
                    System.out.println(i + " " + ciList.get(i - 1).getChance());
                }
                try {
                    chosenOption = Integer.parseInt(TextUi.scanner.nextLine());
                    String st = String.valueOf(ciList.get(chosenOption - 1).getChance());
                    System.out.println("You have chosen: " + st);
                    showChance = false;
                } catch (NumberFormatException e) {
                    System.out.println("Your input is not valid, please try again.");
                }

            }
            if (showSymptoms) {
                for (int i = 1; i <= ciList.size(); i++) {
                    System.out.println(i + " " + ciList.get(i - 1).getSymptoms());
                }
                try {
                    chosenOption = Integer.parseInt(TextUi.scanner.nextLine());
                    String st = String.valueOf(ciList.get(chosenOption - 1).getSymptoms());
                    System.out.println("You have chosen: " + st);
                    showChance = false;
                } catch (NumberFormatException e) {
                    System.out.println("Your input is not valid, please try again.");
                }

            }
            if (showId) {
                for (int i = 1; i <= ciList.size(); i++) {
                    System.out.println(i + " " + ciList.get(i - 1).getID());
                }
                try {
                    chosenOption = Integer.parseInt(TextUi.scanner.nextLine());
                    String st = String.valueOf(ciList.get(chosenOption - 1).getID());
                    System.out.println("You have chosen: " + st);
                    showChance = false;
                } catch (NumberFormatException e) {
                    System.out.println("Your input is not valid, please try again.");
                }
            }
        }
    }
}