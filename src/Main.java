import java.util.Scanner;

public class Main {
    static UserHandler userhandler = new UserHandler("user.txt");
    static TextUi textUi = new TextUi(userhandler);
    public static void main(String[] args) {
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


    private static void giveUserOptions () {

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



    }



        Scanner scanner = new Scanner(System.in);
        boolean questionnaire = true;
        boolean symptoms = true;

        String y = null;
        String n = null;

        if (questionnaire) {
            System.out.println("In the following questioner, answer Yes with Y or No with N");
            String a1, a2, a3;

            System.out.println("Do you smoke? (y/n)");
            System.out.print("");
            a1 = scanner.nextLine();  // consume the newline character

            System.out.println("Do you regularly do any form for exercise or motion? (y/n)");
            System.out.print("");
            a2 = scanner.nextLine();

            System.out.println("Do you take any type of sun bath or walk under the sun at least 4 hours a day? (y/n)");
            System.out.print("");
            a3 = scanner.nextLine();

            System.out.println("Your answers: ");
            System.out.println("Question 1: " + a1);
            System.out.println("Question 2: " + a2);
            System.out.println("Question 3: " + a3);

            if (a1 + a2 + a3 == y){
                System.out.println();
            }

            scanner.close();

        }


    }
