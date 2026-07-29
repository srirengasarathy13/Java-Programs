public class Employee implements Comparable<Employee> {

    private int empId;
    private String empName;
    private String department;
    private String designation;
    private double salary;


    public Employee() {

    }

    public Employee(int empId, String empName, String department,
                    String designation, double salary) {

        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getDepartment() {
        return department;
    }

    public String getDesignation() {
        return designation;
    }

    public double getSalary() {
        return salary;
    }

 
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return this.empName.compareToIgnoreCase(other.empName);
    }

    @Override
    public String toString() {

        return String.format(
                "%-6d %-20s %-15s %-15s %-10.2f",
                empId,
                empName,
                department,
                designation,
                salary
        );
    }
}