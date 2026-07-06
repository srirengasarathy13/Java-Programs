package Assignment_06July;
import java.sql.*;
import java.util.Scanner;

public class employeeManagement {

    static final String URL = "jdbc:mysql://localhost:3306/company";
    static final String USER = "root";
    static final String PASSWORD = "root";

   
    public static void insertEmployee(Connection con, Scanner sc) {
        try {
            String sql = "INSERT INTO employee(empId, empName, salary) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            
            System.out.print("Enter Employee ID:");
            int id = sc.nextInt();

            System.out.print("Enter Employee Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();
            
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee inserted successfully!");
            else
                System.out.println("Insertion failed!");

            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void displayEmployees(Connection con) {
        try {
            String sql = "SELECT * FROM employee";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--------------------------------------------");
            System.out.printf("%-10s %-20s %-10s\n", "ID", "NAME", "SALARY");
            System.out.println("--------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-20s %-10.2f\n",
                        rs.getInt("empId"),
                        rs.getString("empName"),
                        rs.getDouble("salary"));
            }

            System.out.println("--------------------------------------------");

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateEmployee(Connection con, Scanner sc) {
        try {
            String sql = "UPDATE employee SET salary=? WHERE empId=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee not found!");

            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void deleteEmployee(Connection con, Scanner sc) {
        try {
            String sql = "DELETE FROM employee WHERE empId=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee deleted successfully!");
            else
                System.out.println("Employee not found!");

            ps.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            int choice;

            do {
                System.out.println("\n========== Employee Management ==========");
                System.out.println("1. Insert Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        insertEmployee(con, sc);
                        break;

                    case 2:
                        displayEmployees(con);
                        break;

                    case 3:
                        updateEmployee(con, sc);
                        break;

                    case 4:
                        deleteEmployee(con, sc);
                        break;

                    case 5:
                        System.out.println("Thank You!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 5);

            con.close();
            sc.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}