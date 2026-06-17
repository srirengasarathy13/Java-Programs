public class classAndObject {
 public static void main(String args[]){
      Employee emp1 = new Employee();
        emp1.empId = 101;
        emp1.empName = "Sri";
        emp1.salary = 60000;
        emp1.display();
      Employee emp2 = new Employee();
        emp2.empId = 102;
        emp2.empName = "Sarathy";
        emp2.salary = 70000;
        emp2.display();


      }
   }
  


class Employee{
    
   int empId;
   String empName;
   double salary;

   public void display(){
    System.out.println("Employee's ID      : "+empId);
    System.out.println("Employee's Name    : "+empName);
    System.out.println("Employee's Salary  : "+salary);
    System.out.print("-------------------------------------");
   }

}
