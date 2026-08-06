package Advanced_Core_Java.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Employee{

}

class Student{
    private String studentId;
    private String studentName;
    private String departmenString;

    public void getStudents(){

    }
    
    public void setStudents(){

    }

    public void removeStudents(){

    }
}

public class ReflectionDemo {
    public static void main(String[] args) {
        Employee emp = new Employee();
        Class<?> class1 = emp.getClass();
        System.out.println("Class Name : "+class1);
        Class<Student> class2 = Student.class;
        Field[] fields = class2.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
        Method[] methods = class2.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
        

    }
}
