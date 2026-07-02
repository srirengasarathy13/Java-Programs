import java.util.*;
import java.sql.*;
public class deleteEmployee {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
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
            System.out.println("Enter the employee ID to delete:");
            int empId = sc.nextInt();
            String sql = "DELETE FROM employee WHERE empId=" + empId;
            int rowsAffected = stmt.executeUpdate(sql);
            System.out.println();
            if (rowsAffected > 0) {
                System.out.println("Employee record deleted successfully.");
            } else {
                System.out.println("No employee record found with the specified ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}
