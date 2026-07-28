public class constructorJava {
    public static void main(String[] args) {
    Employee1 emp1 = new Employee1(101,"Sri",45000.00);
    Employee1 emp2 = new Employee1(102, "Sarathy", 50000.00);
    emp1.display();
    emp2.display();
 }   
}

class Employee1{
    int id;
    String name;
    double salary;
    Employee1(int empId, String empName, double empSalary){
        this.id = empId;
        this.name = empName;
        this.salary = empSalary;
    }
    void display(){
        System.out.println("----------------Employee Details----------------");
        System.out.println("Id        : "+id);
        System.out.println("Name      : "+name);
        System.out.println("Salary    : Rs."+salary);
        System.out.println("------------------------------------------------");
    }
}