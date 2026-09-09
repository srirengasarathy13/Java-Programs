package src.com.example;

public class EmployeePayroll {

    private String employeeId;
    private String employeeName;
    private String month;
    private int year;
    private double basicSalary;
    private double allowances;
    private double deductions;
    private double netSalary;

    public EmployeePayroll(String employeeId, String employeeName,
                           String month, int year,
                           double basicSalary, double allowances,
                           double deductions) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.month = month;
        this.year = year;
        this.basicSalary = basicSalary;
        this.allowances = allowances;
        this.deductions = deductions;
        this.netSalary = basicSalary + allowances - deductions;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getAllowances() {
        return allowances;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }
}