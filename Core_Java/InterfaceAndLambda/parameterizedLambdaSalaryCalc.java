package InterfaceAndLambda;
interface SalaryCalculator {
    double calculateSalary(double baseSalary, double allowance);
}

public class parameterizedLambdaSalaryCalc {
    public static void main(String[] args) {
        SalaryCalculator salaryCalculator = (baseSalary, allowance) -> baseSalary + allowance;
        System.out.println("Total Salary: Rs." + salaryCalculator.calculateSalary(50000, 10000));
    }
}
