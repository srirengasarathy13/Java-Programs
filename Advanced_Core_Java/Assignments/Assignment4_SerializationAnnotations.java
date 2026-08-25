package Assignments;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Assignment4_SerializationAnnotations {

    // ============================================================
    // @Sensitive Annotation
    // ============================================================
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Sensitive {

    }

    // ============================================================
    // @DisplayName Annotation
    // ============================================================
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface DisplayName {

        String value();
    }

    // ============================================================
    // Address
    // ============================================================
    static class Address implements Serializable {

        private static final long serialVersionUID = 1L;

        private String doorNumber;
        private String street;
        private String city;
        private String pincode;

        public Address(
                String doorNumber,
                String street,
                String city,
                String pincode) {

            this.doorNumber = doorNumber;
            this.street = street;
            this.city = city;
            this.pincode = pincode;
        }

        public String getDoorNumber() {
            return doorNumber;
        }

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }

        @Override
        public String toString() {

            return doorNumber
                    + ", "
                    + street
                    + ", "
                    + city
                    + " - "
                    + pincode;
        }
    }

    // ============================================================
    // Employee
    // ============================================================
    static class Employee implements Serializable {

        private static final long serialVersionUID = 1L;

        private int id;

        private String name;

        private String department;

        @DisplayName("Employee Salary")
        private double salary;

        /*
         * Sensitive information.
         *
         * transient ensures that password is NOT serialized.
         *
         * @Sensitive allows our Reflection utility to identify
         * sensitive fields.
         */
        @Sensitive
        private transient String password;

        private Address address;

        public Employee(
                int id,
                String name,
                String department,
                double salary,
                String password,
                Address address) {

            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
            this.password = password;
            this.address = address;
        }

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

        public String getPassword() {
            return password;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public String toString() {

            return "Employee { "
                    + "id=" + id
                    + ", name='" + name + '\''
                    + ", department='" + department + '\''
                    + ", salary=" + salary
                    + ", password='" + password + '\''
                    + ", address=" + address
                    + " }";
        }
    }

    // ============================================================
    // EmployeeSerializer
    // ============================================================
    static class EmployeeSerializer {

        public void serializeEmployees(
                List<Employee> employees,
                String fileName)
                throws IOException {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "          SERIALIZATION PROCESS"
            );

            System.out.println(
                    "================================================"
            );

            try (ObjectOutputStream outputStream =
                         new ObjectOutputStream(
                                 new FileOutputStream(fileName)
                         )) {

                outputStream.writeObject(
                        employees
                );
            }

            System.out.println(
                    "Employee list serialized successfully."
            );

            System.out.println(
                    "File : " + fileName
            );

            System.out.println(
                    "Number of Employees : "
                            + employees.size()
            );
        }
    }

    // ============================================================
    // EmployeeDeserializer
    // ============================================================
    static class EmployeeDeserializer {

        @SuppressWarnings("unchecked")
        public List<Employee> deserializeEmployees(
                String fileName)
                throws IOException, ClassNotFoundException {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "         DESERIALIZATION PROCESS"
            );

            System.out.println(
                    "================================================"
            );

            try (ObjectInputStream inputStream =
                         new ObjectInputStream(
                                 new FileInputStream(fileName)
                         )) {

                List<Employee> employees =
                        (List<Employee>)
                                inputStream.readObject();

                System.out.println(
                        "Employee list restored successfully."
                );

                System.out.println(
                        "Number of Employees : "
                                + employees.size()
                );

                return employees;
            }
        }
    }

    // ============================================================
    // AnnotationInspector
    // ============================================================
    static class AnnotationInspector {

        // --------------------------------------------------------
        // Find @Sensitive fields
        // --------------------------------------------------------
        public void findSensitiveFields(
                Class<?> clazz) {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "             SENSITIVE FIELDS"
            );

            System.out.println(
                    "================================================"
            );

            Field[] fields =
                    clazz.getDeclaredFields();

            boolean found = false;

            for (Field field : fields) {

                if (field.isAnnotationPresent(
                        Sensitive.class)) {

                    found = true;

                    Sensitive annotation =
                            field.getAnnotation(
                                    Sensitive.class
                            );

                    System.out.println(
                            "Field : "
                                    + field.getName()
                    );

                    System.out.println(
                            "Type  : "
                                    + field.getType()
                                            .getSimpleName()
                    );

                    System.out.println(
                            "Annotation : "
                                    + annotation
                                            .annotationType()
                                            .getSimpleName()
                    );

                    System.out.println();
                }
            }

            if (!found) {

                System.out.println(
                        "No sensitive fields found."
                );
            }
        }

        // --------------------------------------------------------
        // Read @DisplayName
        // --------------------------------------------------------
        public void displayAnnotatedFields(
                Object object)
                throws IllegalAccessException {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "          DISPLAY NAME ANNOTATION"
            );

            System.out.println(
                    "================================================"
            );

            Class<?> clazz =
                    object.getClass();

            Field[] fields =
                    clazz.getDeclaredFields();

            boolean found = false;

            for (Field field : fields) {

                if (field.isAnnotationPresent(
                        DisplayName.class)) {

                    found = true;

                    DisplayName annotation =
                            field.getAnnotation(
                                    DisplayName.class
                            );

                    field.setAccessible(true);

                    Object value =
                            field.get(object);

                    System.out.println(
                            annotation.value()
                                    + " : "
                                    + value
                    );
                }
            }

            if (!found) {

                System.out.println(
                        "No @DisplayName fields found."
                );
            }
        }

        // --------------------------------------------------------
        // Display all runtime annotations
        // --------------------------------------------------------
        public void inspectAnnotations(
                Class<?> clazz) {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "             ANNOTATION INSPECTION"
            );

            System.out.println(
                    "================================================"
            );

            Field[] fields =
                    clazz.getDeclaredFields();

            for (Field field : fields) {

                Annotation[] annotations =
                        field.getDeclaredAnnotations();

                if (annotations.length == 0) {
                    continue;
                }

                System.out.println();
                System.out.println(
                        "Field : "
                                + field.getName()
                );

                for (Annotation annotation
                        : annotations) {

                    System.out.println(
                            "Annotation : "
                                    + annotation
                                            .annotationType()
                                            .getSimpleName()
                    );

                    if (annotation instanceof DisplayName) {

                        DisplayName displayName =
                                (DisplayName)
                                        annotation;

                        System.out.println(
                                "Value      : "
                                        + displayName.value()
                        );
                    }
                }
            }
        }
    }

    // ============================================================
    // EmployeeManager
    // ============================================================
    static class EmployeeManager {

        private final List<Employee> employees =
                new ArrayList<>();

        public void addEmployee(
                Employee employee) {

            employees.add(employee);
        }

        public List<Employee> getEmployees() {

            return employees;
        }

        public void displayEmployees() {

            System.out.println();
            System.out.println(
                    "================================================"
            );

            System.out.println(
                    "              EMPLOYEE LIST"
            );

            System.out.println(
                    "================================================"
            );

            for (Employee employee : employees) {

                System.out.println();
                System.out.println(
                        "Employee ID   : "
                                + employee.getId()
                );

                System.out.println(
                        "Name          : "
                                + employee.getName()
                );

                System.out.println(
                        "Department    : "
                                + employee.getDepartment()
                );

                System.out.println(
                        "Salary        : ₹"
                                + employee.getSalary()
                );

                System.out.println(
                        "Password      : "
                                + employee.getPassword()
                );

                System.out.println(
                        "Address       : "
                                + employee.getAddress()
                );
            }
        }
    }

    // ============================================================
    // Verify Sensitive Information
    // ============================================================
    private static void verifyPasswordNotSerialized(
            List<Employee> employees) {

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "        TRANSIENT FIELD VERIFICATION"
        );

        System.out.println(
                "================================================"
        );

        for (Employee employee : employees) {

            System.out.println(
                    "Employee : "
                            + employee.getName()
            );

            System.out.println(
                    "Password after deserialization : "
                            + employee.getPassword()
            );

            if (employee.getPassword() == null) {

                System.out.println(
                        "Result : PASSWORD WAS NOT SERIALIZED"
                );

            } else {

                System.out.println(
                        "Result : PASSWORD WAS SERIALIZED"
                );
            }

            System.out.println();
        }
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
                "      SERIALIZATION + ANNOTATION SYSTEM"
        );

        System.out.println(
                "================================================"
        );

        // --------------------------------------------------------
        // Create addresses
        // --------------------------------------------------------

        Address address1 =
                new Address(
                        "12",
                        "Anna Nagar",
                        "Chennai",
                        "600040"
                );

        Address address2 =
                new Address(
                        "25",
                        "MG Road",
                        "Bengaluru",
                        "560001"
                );

        Address address3 =
                new Address(
                        "42",
                        "RS Puram",
                        "Coimbatore",
                        "641002"
                );

        // --------------------------------------------------------
        // Create employees
        // --------------------------------------------------------

        Employee employee1 =
                new Employee(
                        101,
                        "Arun",
                        "Development",
                        75000,
                        "arun@123",
                        address1
                );

        Employee employee2 =
                new Employee(
                        102,
                        "Priya",
                        "Testing",
                        65000,
                        "priya@123",
                        address2
                );

        Employee employee3 =
                new Employee(
                        103,
                        "Karthik",
                        "HR",
                        55000,
                        "karthik@123",
                        address3
                );

        // --------------------------------------------------------
        // EmployeeManager
        // --------------------------------------------------------

        EmployeeManager manager =
                new EmployeeManager();

        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(employee3);

        // --------------------------------------------------------
        // Display original employees
        // --------------------------------------------------------

        System.out.println();
        System.out.println(
                "===== ORIGINAL EMPLOYEE DATA ====="
        );

        manager.displayEmployees();

        // --------------------------------------------------------
        // Annotation inspection
        // --------------------------------------------------------

        AnnotationInspector annotationInspector =
                new AnnotationInspector();

        annotationInspector.inspectAnnotations(
                Employee.class
        );

        // --------------------------------------------------------
        // Find sensitive fields
        // --------------------------------------------------------

        annotationInspector.findSensitiveFields(
                Employee.class
        );

        // --------------------------------------------------------
        // Read @DisplayName annotation
        // --------------------------------------------------------

        annotationInspector.displayAnnotatedFields(
                employee1
        );

        // --------------------------------------------------------
        // Serialize employees
        // --------------------------------------------------------

        String fileName =
                "C:\\Sri\\Java Programs\\Advanced_Core_Java\\Assignments\\employees.ser";

        EmployeeSerializer serializer =
                new EmployeeSerializer();

        serializer.serializeEmployees(
                manager.getEmployees(),
                fileName
        );

        // --------------------------------------------------------
        // Deserialize employees
        // --------------------------------------------------------

        EmployeeDeserializer deserializer =
                new EmployeeDeserializer();

        List<Employee> restoredEmployees =
                deserializer.deserializeEmployees(
                        fileName
                );

        // --------------------------------------------------------
        // Display restored employees
        // --------------------------------------------------------

        EmployeeManager restoredManager =
                new EmployeeManager();

        for (Employee employee
                : restoredEmployees) {

            restoredManager.addEmployee(
                    employee
            );
        }

        System.out.println();
        System.out.println(
                "===== RESTORED EMPLOYEE DATA ====="
        );

        restoredManager.displayEmployees();

        // --------------------------------------------------------
        // Verify transient password
        // --------------------------------------------------------

        verifyPasswordNotSerialized(
                restoredEmployees
        );

        // --------------------------------------------------------
        // Read @DisplayName after restoration
        // --------------------------------------------------------

        System.out.println();
        System.out.println(
                "===== RESTORED ANNOTATED FIELD ====="
        );

        annotationInspector.displayAnnotatedFields(
                restoredEmployees.get(0)
        );

        // --------------------------------------------------------
        // File information
        // --------------------------------------------------------

        File serializedFile =
                new File(fileName);

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "             SERIALIZED FILE"
        );

        System.out.println(
                "================================================"
        );

        System.out.println(
                "File Name : "
                        + serializedFile.getName()
        );

        System.out.println(
                "File Size : "
                        + serializedFile.length()
                        + " bytes"
        );

        System.out.println(
                "Location  : "
                        + serializedFile
                                .getAbsolutePath()
        );

        // --------------------------------------------------------
        // Completed
        // --------------------------------------------------------

        System.out.println();
        System.out.println(
                "================================================"
        );

        System.out.println(
                "     SERIALIZATION DEMONSTRATION COMPLETED"
        );

        System.out.println(
                "================================================"
        );
    }
}