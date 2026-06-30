import java.sql.*;
import java.util.Scanner;

public class insertEmployee {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "root";

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String sql = "INSERT INTO employee(empId, empName, salary) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("How many employees do you want to insert? ");
            int n = sc.nextInt();
            sc.nextLine(); 

            for (int i = 1; i <= n; i++) {

                System.out.println("\nEmployee " + i);

                System.out.print("Enter Employee Id: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();
                
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setDouble(3, salary);

                ps.executeUpdate();
            }

            System.out.println("\nAll employees inserted successfully!");

            ps.close();
            con.close();
            sc.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}