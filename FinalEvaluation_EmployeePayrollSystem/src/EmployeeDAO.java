
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import java.util.ArrayList;
import java.util.Collections;

import java.io.FileWriter;
import java.io.IOException;

public class EmployeeDAO {

    // Register Employee
    public void registerEmployee(Employee emp) {

        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp.getEmpId());
            ps.setString(2, emp.getEmpName());
            ps.setString(3, emp.getDepartment());
            ps.setString(4, emp.getDesignation());
            ps.setDouble(5, emp.getSalary());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nEmployee Registered Successfully.");
            }

        } catch (SQLIntegrityConstraintViolationException e) {

            System.out.println("Duplicate Employee ID.");

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }

    // View All Employees
    public void viewEmployees() {

        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n==============================================================");
            System.out.printf("%-8s %-20s %-15s %-15s %-10s%n",
                    "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY");
            System.out.println("==============================================================");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-8d %-20s %-15s %-15s %-10.2f%n",
                        rs.getInt("empid"),
                        rs.getString("empname"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDouble("salary"));

            }

            if (!found) {
                System.out.println("No Employee Records Found.");
            }

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }

    // Search Employee by ID
    public void searchEmployee(int empId) {

        String sql = "SELECT * FROM employee WHERE empid = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n========== Employee Found ==========");

                System.out.println("Employee ID   : " + rs.getInt("empid"));
                System.out.println("Employee Name : " + rs.getString("empname"));
                System.out.println("Department    : " + rs.getString("department"));
                System.out.println("Designation   : " + rs.getString("designation"));
                System.out.println("Salary        : " + rs.getDouble("salary"));

            } else {

                System.out.println("Employee Not Found.");

            }

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }


    // Update Employee Salary
    public void updateSalary(int empId, double newSalary) {

        String sql = "UPDATE employee SET salary = ? WHERE empid = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, newSalary);
            ps.setInt(2, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Salary Updated Successfully.");

            } else {

                System.out.println("Employee Not Found.");

            }

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }


    // Delete Employee
    public void deleteEmployee(int empId) {

        String sql = "DELETE FROM employee WHERE empid = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, empId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("Employee Deleted Successfully.");

            } else {

                System.out.println("Employee Not Found.");

            }

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }

        // Load Employees into ArrayList
    public ArrayList<Employee> getEmployees() {

        ArrayList<Employee> employeeList = new ArrayList<>();

        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Employee emp = new Employee(
                        rs.getInt("empid"),
                        rs.getString("empname"),
                        rs.getString("department"),
                        rs.getString("designation"),
                        rs.getDouble("salary")
                );

                employeeList.add(emp);
            }

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }

        return employeeList;
    }


    // Sort Employees by Name (Comparable)
    public void sortByName() {

        ArrayList<Employee> employeeList = getEmployees();

        if (employeeList.isEmpty()) {

            System.out.println("No Employee Records Found.");
            return;

        }

        Collections.sort(employeeList);

        System.out.println("\n========= Employees Sorted by Name =========");

        System.out.printf("%-8s %-20s %-15s %-15s %-10s%n",
                "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY");

        for (Employee emp : employeeList) {

            System.out.println(emp);

        }
    }


    // Sort Employees by Salary (Descending)
    public void sortBySalary() {

        ArrayList<Employee> employeeList = getEmployees();

        if (employeeList.isEmpty()) {

            System.out.println("No Employee Records Found.");
            return;

        }

        Collections.sort(employeeList, new SalaryComparator());

        System.out.println("\n======= Employees Sorted by Salary =======");

        System.out.printf("%-8s %-20s %-15s %-15s %-10s%n",
                "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY");

        for (Employee emp : employeeList) {

            System.out.println(emp);

        }
    }


    // Export Employee Details to File
    public void exportToFile() {

        ArrayList<Employee> employeeList = getEmployees();

        if (employeeList.isEmpty()) {

            System.out.println("No Employee Records Available.");
            return;

        }

        try (FileWriter fw = new FileWriter("employee.txt")) {

            fw.write("============================================================\n");
            fw.write("Employee Payroll Report\n");
            fw.write("============================================================\n");

            fw.write(String.format("%-8s %-20s %-15s %-15s %-10s%n",
                    "ID", "NAME", "DEPARTMENT", "DESIGNATION", "SALARY"));

            for (Employee emp : employeeList) {

                fw.write(emp.toString());
                fw.write("\n");

            }

            System.out.println("Employee details exported successfully.");

        } catch (IOException e) {

            System.out.println("File Error : " + e.getMessage());

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());

        }
    }

}