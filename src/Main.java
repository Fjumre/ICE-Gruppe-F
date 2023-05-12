import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<User> userList = DBConnector.createUser();

        List<CancerInfo> cancerList = DBConnector.getCancerData();

    }
}