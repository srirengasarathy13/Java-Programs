import java.lang.reflect.Constructor;

class Employee_DynamicObject {

    public Employee_DynamicObject() {
        System.out.println("Employee Object Created");
    }
}



public class HRMSDynamicObjectDemo {

    public static void main(String[] args) throws Exception {

        Constructor<Employee_DynamicObject> constructor =
                Employee_DynamicObject.class.getDeclaredConstructor();

        Employee_DynamicObject employee =
                constructor.newInstance();
    }
}