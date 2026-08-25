package Assignments;

import java.lang.reflect.*;
import java.util.Scanner;

public class Assignment3_ReflectionInspector {

    // ============================================================
    // Employee
    // ============================================================
    static class Employee {

        private int id;
        private String name;
        private String department;
        private double salary;

        // --------------------------------------------------------
        // Default Constructor
        // --------------------------------------------------------
        public Employee() {
            this.id = 0;
            this.name = "Unknown";
            this.department = "Unknown";
            this.salary = 0.0;
        }

        // --------------------------------------------------------
        // Parameterized Constructor
        // --------------------------------------------------------
        public Employee(
                int id,
                String name,
                String department,
                double salary) {

            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        // --------------------------------------------------------
        // Getters
        // --------------------------------------------------------
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        // --------------------------------------------------------
        // Setters
        // --------------------------------------------------------
        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        // --------------------------------------------------------
        // Display Method
        // --------------------------------------------------------
        public void displayDetails() {

            System.out.println();
            System.out.println("Employee Details");
            System.out.println("----------------");
            System.out.println("ID         : " + id);
            System.out.println("Name       : " + name);
            System.out.println("Department : " + department);
            System.out.println("Salary     : ₹" + salary);
        }

        // --------------------------------------------------------
        // Another method for reflection demonstration
        // --------------------------------------------------------
        public String getEmployeeSummary() {

            return name
                    + " works in "
                    + department
                    + " department.";
        }
    }

    // ============================================================
    // ReflectionInspector
    // ============================================================
    static class ReflectionInspector {

        // --------------------------------------------------------
        // Inspect Class
        // --------------------------------------------------------
        public void inspectClass(Class<?> clazz) {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "              CLASS INFORMATION"
            );

            System.out.println(
                    "================================================"
            );

            // ----------------------------------------------------
            // Class Name
            // ----------------------------------------------------

            System.out.println();
            System.out.println(
                    "Class Name : "
                            + clazz.getSimpleName()
            );

            System.out.println(
                    "Full Name  : "
                            + clazz.getName()
            );

            // ----------------------------------------------------
            // Fields
            // ----------------------------------------------------

            System.out.println();
            System.out.println("FIELDS");
            System.out.println("------");

            Field[] fields =
                    clazz.getDeclaredFields();

            for (Field field : fields) {

                System.out.println(
                        field.getName()
                                + " : "
                                + field.getType().getSimpleName()
                );
            }

            // ----------------------------------------------------
            // Constructors
            // ----------------------------------------------------

            System.out.println();
            System.out.println("CONSTRUCTORS");
            System.out.println("------------");

            Constructor<?>[] constructors =
                    clazz.getDeclaredConstructors();

            for (Constructor<?> constructor
                    : constructors) {

                System.out.println(
                        getConstructorDescription(
                                constructor
                        )
                );
            }

            // ----------------------------------------------------
            // Methods
            // ----------------------------------------------------

            System.out.println();
            System.out.println("METHODS");
            System.out.println("-------");

            Method[] methods =
                    clazz.getDeclaredMethods();

            for (Method method : methods) {

                System.out.println(
                        getMethodDescription(
                                method
                        )
                );
            }
        }

        // --------------------------------------------------------
        // Constructor Description
        // --------------------------------------------------------
        private String getConstructorDescription(
                Constructor<?> constructor) {

            StringBuilder result =
                    new StringBuilder();

            result.append(
                    constructor.getDeclaringClass()
                            .getSimpleName()
            );

            result.append("(");

            Class<?>[] parameterTypes =
                    constructor.getParameterTypes();

            for (int i = 0;
                 i < parameterTypes.length;
                 i++) {

                result.append(
                        parameterTypes[i]
                                .getSimpleName()
                );

                if (i < parameterTypes.length - 1) {
                    result.append(", ");
                }
            }

            result.append(")");

            return result.toString();
        }

        // --------------------------------------------------------
        // Method Description
        // --------------------------------------------------------
        private String getMethodDescription(
                Method method) {

            StringBuilder result =
                    new StringBuilder();

            result.append(
                    method.getName()
            );

            result.append("(");

            Class<?>[] parameterTypes =
                    method.getParameterTypes();

            for (int i = 0;
                 i < parameterTypes.length;
                 i++) {

                result.append(
                        parameterTypes[i]
                                .getSimpleName()
                );

                if (i < parameterTypes.length - 1) {
                    result.append(", ");
                }
            }

            result.append(")");

            result.append(" : ");

            result.append(
                    method.getReturnType()
                            .getSimpleName()
            );

            return result.toString();
        }

        // ========================================================
        // Access Private Field
        // ========================================================
        public void accessPrivateField(
                Object object,
                String fieldName)
                throws Exception {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "          PRIVATE FIELD ACCESS"
            );

            System.out.println(
                    "================================================"
            );

            Class<?> clazz =
                    object.getClass();

            Field field =
                    clazz.getDeclaredField(
                            fieldName
                    );

            System.out.println(
                    "Field Name : "
                            + field.getName()
            );

            System.out.println(
                    "Field Type : "
                            + field.getType()
                                    .getSimpleName()
            );

            /*
             * The field is private.
             *
             * setAccessible(true) allows reflection
             * to access it.
             */
            field.setAccessible(true);

            Object value =
                    field.get(object);

            System.out.println(
                    "Field Value: "
                            + value
            );
        }

        // ========================================================
        // Modify Private Field
        // ========================================================
        public void modifyPrivateField(
                Object object,
                String fieldName,
                Object newValue)
                throws Exception {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "         MODIFY PRIVATE FIELD"
            );

            System.out.println(
                    "================================================"
            );

            Class<?> clazz =
                    object.getClass();

            Field field =
                    clazz.getDeclaredField(
                            fieldName
                    );

            field.setAccessible(true);

            System.out.println(
                    "Old Value : "
                            + field.get(object)
            );

            /*
             * Modify the private field dynamically.
             */
            field.set(
                    object,
                    newValue
            );

            System.out.println(
                    "New Value : "
                            + field.get(object)
            );
        }

        // ========================================================
        // Invoke Method Dynamically
        // ========================================================
        public Object invokeMethod(
                Object object,
                String methodName)
                throws Exception {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "          DYNAMIC METHOD INVOCATION"
            );

            System.out.println(
                    "================================================"
            );

            Class<?> clazz =
                    object.getClass();

            Method method =
                    clazz.getDeclaredMethod(
                            methodName
                    );

            method.setAccessible(true);

            /*
             * The method is invoked dynamically.
             *
             * We are NOT doing:
             *
             * employee.getName()
             *
             * Instead Reflection invokes the method.
             */
            Object result =
                    method.invoke(object);

            System.out.println(
                    "Method Name : "
                            + method.getName()
            );

            System.out.println(
                    "Return Type : "
                            + method.getReturnType()
                                    .getSimpleName()
            );

            System.out.println(
                    "Return Value: "
                            + result
            );

            return result;
        }

        // ========================================================
        // Invoke displayDetails()
        // ========================================================
        public void invokeDisplayDetails(
                Object object)
                throws Exception {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "        INVOKING displayDetails()"
            );

            System.out.println(
                    "================================================"
            );

            Class<?> clazz =
                    object.getClass();

            Method method =
                    clazz.getDeclaredMethod(
                            "displayDetails"
                    );

            method.setAccessible(true);

            /*
             * Dynamic method invocation.
             */
            method.invoke(object);
        }
    }

    // ============================================================
    // Create Employee Dynamically
    // ============================================================
    private static Employee createEmployee()
            throws Exception {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "       DYNAMIC OBJECT CREATION"
        );

        System.out.println(
                "================================================"
        );

        Class<?> employeeClass =
                Employee.class;

        /*
         * Get the parameterized constructor dynamically.
         */
        Constructor<?> constructor =
                employeeClass.getDeclaredConstructor(
                        int.class,
                        String.class,
                        String.class,
                        double.class
                );

        /*
         * Create Employee object using Reflection.
         */
        Object object =
                constructor.newInstance(
                        101,
                        "Sri",
                        "Software Development",
                        75000.0
                );

        System.out.println(
                "Employee object created dynamically."
        );

        return (Employee) object;
    }

    // ============================================================
    // Main
    // ============================================================
    public static void main(String[] args)
            throws Exception {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "        DYNAMIC EMPLOYEE OBJECT INSPECTOR"
        );

        System.out.println(
                "================================================"
        );

        Scanner scanner =
                new Scanner(System.in);

        // --------------------------------------------------------
        // Ask user for class name
        // --------------------------------------------------------

        System.out.println();
        System.out.print(
                "Enter Class Name [Employee]: "
        );

        String className =
                scanner.nextLine().trim();

        /*
         * If user presses Enter, use Employee.
         */
        if (className.isEmpty()) {
            className = "Employee";
        }

        // --------------------------------------------------------
        // Get Class object dynamically
        // --------------------------------------------------------

        Class<?> clazz;

        if (className.equals("Employee")) {

            clazz = Employee.class;

        } else {

            /*
             * Try to load a class dynamically.
             */
            try {

                clazz =
                        Class.forName(
                                className
                        );

            } catch (ClassNotFoundException e) {

                System.out.println();
                System.out.println(
                        "Class not found: "
                                + className
                );

                scanner.close();
                return;
            }
        }

        // --------------------------------------------------------
        // Reflection Inspector
        // --------------------------------------------------------

        ReflectionInspector inspector =
                new ReflectionInspector();

        inspector.inspectClass(
                clazz
        );

        // --------------------------------------------------------
        // Create Employee object
        // --------------------------------------------------------

        if (clazz == Employee.class) {

            Employee employee =
                    createEmployee();

            // ----------------------------------------------------
            // Access private field
            // ----------------------------------------------------

            inspector.accessPrivateField(
                    employee,
                    "name"
            );

            // ----------------------------------------------------
            // Modify private field
            // ----------------------------------------------------

            inspector.modifyPrivateField(
                    employee,
                    "name",
                    "R Sri Rengasarathy"
            );

            // ----------------------------------------------------
            // Verify modified private field
            // ----------------------------------------------------

            inspector.accessPrivateField(
                    employee,
                    "name"
            );

            // ----------------------------------------------------
            // Invoke getName() dynamically
            // ----------------------------------------------------

            inspector.invokeMethod(
                    employee,
                    "getName"
            );

            // ----------------------------------------------------
            // Invoke getSalary() dynamically
            // ----------------------------------------------------

            inspector.invokeMethod(
                    employee,
                    "getSalary"
            );

            // ----------------------------------------------------
            // Invoke displayDetails() dynamically
            // ----------------------------------------------------

            inspector.invokeDisplayDetails(
                    employee
            );
        }

        scanner.close();

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "       REFLECTION INSPECTION COMPLETED"
        );

        System.out.println(
                "================================================"
        );
    }
}