import java.util.ArrayList;
import java.util.List;

public class User {

    String PassWord;
    String UserName;
    List<CancerInfo> ci;


    public void user(String userName, String passWord) {
        this.UserName = userName;
        this.PassWord = passWord;
        this.ci = new ArrayList<>();
    }
}