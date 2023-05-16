
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

    public class CancerInfo {

        static List<CancerProgram> ciList = DBConnector.getCancerData();
        File file;
        Scanner scanner;

        public CancerInfo(String path) {
            try {
                file = new File(path);
                scanner = new Scanner(file);
            } catch (FileNotFoundException e) {
                System.out.println("The file you want to read from does not exist");
            } catch (IOException e) {
                System.out.println("The file you want to write to does not exist");
            } catch (Exception e) {
                System.out.println("Sorry, the system is not working currently");
            }
        }

        /*public void loadCancerInfo() {

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String [] values = input.split(";");
                ciList.add(new CancerProgram(values[0], values[1], values[2], values[3]));
            }
        }*/
    }