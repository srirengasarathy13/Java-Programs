
import java.sql.*;

public class viewEmployee {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            if (con != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to connect to the database.");
            }
            System.out.println();
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("Employee ID     : " + rs.getInt("empId"));
                System.out.println("Employee Name   : " + rs.getString("empName"));
                System.out.println("Employee Salary : Rs." + rs.getDouble("salary"));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
