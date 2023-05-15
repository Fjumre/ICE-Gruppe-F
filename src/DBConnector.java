import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;



public class DBConnector {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/ice";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "G5no394E!";
    private static String[] newUser;

    public static List<User> createUser() {
            List<User> users = new ArrayList<>();
            Connection conn = null;
            PreparedStatement pstmnt = null;

            try {

                String query = "CREATE USER 'username'@'localhost'IDENTIFIED BY PASSWORD 'password' FROM ice.user; ";
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                pstmnt = conn.prepareStatement(query);

                for (int i=0;  i < newUser.length; i++) {
                    pstmnt.setString(i, newUser[0]);
                }
                pstmnt.execute();
                pstmnt.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return users;
        }


    public static List<CancerInfo> getCancerData() {
        List<CancerInfo> ci = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM ice.cancerinfo";

            stmt = conn.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();


            //STEP 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name

                String name = rs.getString("Name");
                String symptoms = rs.getString("Symptoms");
                String chanceprocent = rs.getString("ChanceProcent");
                String cancerinfo = rs.getString("CancerInfo");
                String lifestyle = rs.getString("LifeStyle");
                List<String> allSymptoms = new ArrayList<>();
                String[] symptom = symptoms.split(", ");
                for(int i = 0; i < symptom.length; i++){
                    allSymptoms.add(symptom[i]);
                }

                System.out.println(name + ": " + symptoms + ": " + chanceprocent + ": " + cancerinfo + ": " + lifestyle);
                //Cancer ca = new Cancer(name, symptoms, chanceprocent, cancerinfo);
            }
            //STEP 5: Clean-up environment
            rs.close();

            stmt.close();

            conn.close();


        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        return ci;
    }
    public void readName(String cancer) {

        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            //STEP 1: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT name FROM ice.cancerinfo";
            stmt = conn.prepareStatement(sql);



            ResultSet rs = stmt.executeQuery();

            //STEP 4: Extract data from result set
            while(rs.next()){
                //Retrieve by column name

                String name = rs.getString( "name");
                System.out.println(name);

            }
            //STEP 5: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try



    }
}
