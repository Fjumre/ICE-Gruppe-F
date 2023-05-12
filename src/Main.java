import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<User> userList = DBConnector.createUser();

        List<CancerInfo> cancerList = DBConnector.getCancerData();

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
}