import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CancerInfo{

    static List<CancerProgram> ciList = DBConnector.getCancerData();
    File file;
    Scanner scanner;

    public CancerInfo(String path) {
        try {
            file = new File(path);
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("The file you want to read from does not exist");
        } catch (Exception e) {
            System.out.println("Sorry, the system is not working currently");
        }
    }

    public void loadCancerInfo() {
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] values = input.split(";");
            int id = Integer.parseInt(values[0]);
            String name = values[1];
            String symptoms = values[2];
            String chance = String.valueOf(values[3]);
            ciList.add(new CancerProgram(id, name, symptoms, chance));
        }
    }
}