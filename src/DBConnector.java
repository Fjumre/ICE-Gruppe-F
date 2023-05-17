import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    // database URL
    static final String DB_URL = "jdbc:mysql://localhost/ice";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "G5no394E!";

    public static void createUser(String username, String password) {
        Connection conn = null;
        PreparedStatement pstmnt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            String query = "CREATE USER ?@'localhost' IDENTIFIED BY ?;";
            pstmnt = conn.prepareStatement(query);

            pstmnt.setString(1, username);
            pstmnt.setString(2, password);
            pstmnt.execute();

            System.out.println("User created successfully");

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (pstmnt != null) {
                    pstmnt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<CancerProgram> getCancerData() {
        List<CancerProgram> ciList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT * FROM ice.cancerinfo";

            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name

                String id = rs.getString("Id");
                String name = rs.getString("Name");
                String symptoms = rs.getString("Symptoms");
                String chance = rs.getString("Chance");

               /* // Split symptoms into a list of strings
                String[] symptomArray = symptoms.split(", ");
                List<String> symptomList = new ArrayList<>();
                for (String symptom : symptomArray) {
                    symptomList.add(symptom);
                }*/

                // Create new CancerProgram and add to list
                CancerProgram cancerProgram = new CancerProgram(name, chance);
                ciList.add(cancerProgram);
            }

            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return ciList;
    }
}
    /*public void readName(String cancer) {

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



    }*/

