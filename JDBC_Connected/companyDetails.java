import java.sql.*;

public class companyDetails {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected successfully!");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}