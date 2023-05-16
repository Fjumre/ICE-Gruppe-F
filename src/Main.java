import java.util.List;
import java.util.Scanner;

public class Main {
    static UserHandler userhandler = new UserHandler("user.txt");
    static TextUi textUi = new TextUi(userhandler);
    static List<CancerProgram> ciList = DBConnector.getCancerData();
    static boolean showCancer = false;
    static boolean showChance = false;
    static boolean showSymptoms = false;
    static boolean showId = false;
    private static int chosenOption = 0;
    static boolean showMainMenu = false;

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
        while (true) {
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

                //sc.close();

                loginMenu = false;
                showMainMenu = true;

            }
            if (showMainMenu) {
                System.out.println("Welcome to main menu");
                System.out.println("1. See cancer list");
                System.out.println("2. See symptoms list");
                System.out.println("3. See chance list");
                System.out.println("4. See ID list");
                int s = Integer.parseInt(sc.nextLine());
                switch (s) {
                    case 1:
                        showMainMenu = false;
                        showCancer = true;
                        break;
                    case 2:
                        showSymptoms = true;
                        showMainMenu = false;
                        break;
                    case 3:
                        showChance = true;
                        showMainMenu = false;
                        break;
                    case 4:
                        showId = true;
                        showMainMenu = false;
                        break;
                    default:
                        System.out.println("Your input is not valid, please try again.");
                }
            }

            if (showCancer) {
                for (int i = 1; i <= ciList.size(); i++) {
                    System.out.println(i + " " + ciList.get(i - 1).getName());
                }
                try {

                    chosenOption = Integer.parseInt(sc.nextLine());
                    String st1 = ciList.get(chosenOption - 1).getName();
                    System.out.println("You have chosen: " + st1);
                    showCancer = false;
                    showMainMenu = true;
                } catch (NumberFormatException e) {
                    System.out.println("Your input is not valid, please try again.");
                }

                if (showChance) {
                    for (int i = 1; i <= ciList.size(); i++) {
                        System.out.println(i + " " + ciList.get(i - 1).getChance());
                    }
                    try {
                        chosenOption = Integer.parseInt(sc.nextLine());
                        String st2 = String.valueOf(ciList.get(chosenOption - 1).getChance());
                        System.out.println("You have chosen: " + st2);
                        showChance = false;
                        showMainMenu = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Your input is not valid, please try again.");
                    }

                }
                if (showSymptoms) {
                    for (int i = 1; i <= ciList.size(); i++) {
                        System.out.println(i + " " + ciList.get(i - 1).getSymptoms());
                    }
                    try {
                        chosenOption = Integer.parseInt(sc.nextLine());
                        String st3 = String.valueOf(ciList.get(chosenOption - 1).getSymptoms());
                        System.out.println("You have chosen: " + st3);
                        showChance = false;
                        showMainMenu = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Your input is not valid, please try again.");
                    }

                }
                if (showId) {
                    for (int i = 1; i <= ciList.size(); i++) {
                        System.out.println(i + " " + ciList.get(i - 1).getId());
                    }
                    try {
                        chosenOption = Integer.parseInt(sc.nextLine());
                        String st4 = String.valueOf(ciList.get(chosenOption - 1).getId());
                        System.out.println("You have chosen: " + st4);
                        showChance = false;
                        showMainMenu = true;
                    } catch (NumberFormatException e) {
                        System.out.println("Your input is not valid, please try again.");
                    }
                }
            }
        }
    }
}