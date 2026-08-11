import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employeee{

    private String employeeId = "EMP1001";
    private String employeeName = "Rama";
    private String department = "SAP";
    private String designation = "Developer";

    public void displayEmployee() {
        System.out.println("Employee Details");
        System.out.println("Employee ID   : " + employeeId);
        System.out.println("Employee Name : " + employeeName);
        System.out.println("Department    : " + department);
        System.out.println("Designation   : " + designation);
    }

    public void updateDepartment(String department) {
        this.department = department;
    }

    public void updateDesignation(String designation) {
        this.designation = designation;
    }
}

public class HRMSDynamicUpdateDemo {

    public static void main(String[] args) throws Exception {

        Employeee employee = new Employeee();

        System.out.println("HRMS Employee Processing");

      
        Field departmentField =
                Employeee.class.getDeclaredField("department");

        departmentField.setAccessible(true);

        System.out.println("Original Department : "
                + departmentField.get(employee));

        departmentField.set(employee, "Finance");

        System.out.println("Updated Department  : "
                + departmentField.get(employee));

       
        Method displayMethod =
                Employeee.class.getDeclaredMethod("displayEmployee");

        
        System.out.println("\nInvoking displayEmployee()...");
        displayMethod.invoke(employee);

       
        Method designationMethod =
                Employeee.class.getDeclaredMethod(
                        "updateDesignation",
                        String.class
                );

        
        designationMethod.invoke(
                employee,
                "Senior Consultant"
        );

      
        System.out.println("\nFinal Employee Details:");
        displayMethod.invoke(employee);
    }
}