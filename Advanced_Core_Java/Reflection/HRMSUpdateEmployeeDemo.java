import java.lang.reflect.Field;

class Employee {

    private String employeeId = "EMP1001";
    private String employeeName = "Rama";
    private String department = "SAP";
}

public class HRMSUpdateEmployeeDemo {

    public static void main(String[] args) throws Exception {

        Employee employee = new Employee();

        Field field = Employee.class.getDeclaredField("department");

        field.setAccessible(true);

        System.out.println("Before Update : " + field.get(employee));

        field.set(employee, "Finance");

        System.out.println("After Update : " + field.get(employee));
    }
}