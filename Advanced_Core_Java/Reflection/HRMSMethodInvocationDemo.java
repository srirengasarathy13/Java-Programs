import java.lang.reflect.Method;

class Employee_RefMtdInvokeDemo {

    public void displayEmployee() {
        System.out.println("Employee ID   : EMP1001");
        System.out.println("Employee Name : Rama");
        System.out.println("Department    : SAP");
    }
}

public class HRMSMethodInvocationDemo {

    public static void main(String[] args) throws Exception {

        Employee_RefMtdInvokeDemo employee = new Employee_RefMtdInvokeDemo();
        Method method = Employee_RefMtdInvokeDemo.class.getDeclaredMethod("displayEmployee");
        method.invoke(employee);
    }
}