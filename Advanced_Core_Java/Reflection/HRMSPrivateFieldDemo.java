import java.lang.reflect.Field;

class Employee {

    private String employeeId = "EMP1001";
    private String employeeName = "Rama";
    private String department = "SAP";
}

public class HRMSPrivateFieldDemo {

    public static void main(String[] args) throws Exception {

        Employee employee = new Employee();

        Field field = Employee.class.getDeclaredField("employeeName");

        field.setAccessible(true);

        String name = (String) field.get(employee);

        System.out.println("Employee Name : " + name);
    }
}