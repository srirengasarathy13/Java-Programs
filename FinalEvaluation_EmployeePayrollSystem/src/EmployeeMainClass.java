import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMainClass{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        int choice = 0;

        do {

            System.out.println("\n==================================");
            System.out.println("     EMPLOYEE PAYROLL SYSTEM");
            System.out.println("==================================");
            System.out.println("1. Register Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Sort by Name");
            System.out.println("7. Sort by Salary");
            System.out.println("8. Export to File");
            System.out.println("9. Exit");
            System.out.print("Enter your choice : ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); 
            } catch (InputMismatchException e) {
                System.out.println("Invalid Menu Choice!");
                sc.nextLine();
                continue;
            }

            switch (choice) {

                case 1:

                    try {

                        System.out.print("Enter Employee ID : ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        if (id <= 0) {
                            System.out.println("Employee ID must be greater than 0.");
                            break;
                        }

                        System.out.print("Enter Employee Name : ");
                        String name = sc.nextLine();

                        if (!name.matches("[A-Za-z ]+")) {
                            System.out.println("Employee Name should contain only alphabets and spaces.");
                            break;
                        }

                        System.out.print("Enter Department : ");
                        String department = sc.nextLine();

                        if (department.trim().isEmpty()) {
                            System.out.println("Department cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Designation : ");
                        String designation = sc.nextLine();

                        if (designation.trim().isEmpty()) {
                            System.out.println("Designation cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Salary : ");
                        double salary = sc.nextDouble();

                        if (salary <= 0) {
                            System.out.println("Salary must be greater than 0.");
                            break;
                        }

                        Employee emp = new Employee(id, name, department, designation, salary);

                        dao.registerEmployee(emp);

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid Salary Input.");
                        sc.nextLine();

                    }

                    break;

                case 2:

                    dao.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter Employee ID : ");
                    int searchId = sc.nextInt();

                    dao.searchEmployee(searchId);

                    break;

                case 4:

                    try {

                        System.out.print("Enter Employee ID : ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Salary : ");
                        double newSalary = sc.nextDouble();

                        if (newSalary <= 0) {
                            System.out.println("Salary must be greater than 0.");
                            break;
                        }

                        dao.updateSalary(updateId, newSalary);

                    } catch (InputMismatchException e) {

                        System.out.println("Invalid Salary.");
                        sc.nextLine();

                    }

                    break;

                case 5:

                    System.out.print("Enter Employee ID : ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Are you sure (Y/N)? : ");
                    char confirm = sc.nextLine().toUpperCase().charAt(0);

                    if (confirm == 'Y') {

                        dao.deleteEmployee(deleteId);

                    } else {

                        System.out.println("Delete Cancelled.");

                    }

                    break;

                case 6:

                    dao.sortByName();

                    break;

                case 7:

                    dao.sortBySalary();

                    break;

                case 8:

                    dao.exportToFile();

                    break;

                case 9:

                    System.out.println("Thank You!");
                    System.out.println("Exiting Employee Payroll System...");

                    break;

                default:

                    System.out.println("Invalid Menu Choice!");

            }

        } while (choice != 9);

        sc.close();
    }
}