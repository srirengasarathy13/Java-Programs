public class encapsulation {
    public static void main(String[] args) {
        Emp2 e1 = new Emp2(101, "Sri", 100000);
        e1.display();
        System.out.println();
        System.out.println("Salary returned from GETTER method : Rs."+ e1.getSalary());;

    }
}

class Emp2{
    private int id;
    private String name;
    private double salary;

    Emp2(int id, String name, double salary){
        this.id = id;
        this.name = name;
        setSalary(salary);

    }

    void setSalary(double salary){
        if(salary>0){
            this.salary = salary;
        }
        else{
            System.out.println("Invalid Salary Input...");
        }
    }


    void display(){
       System.out.println("ID     : "+id);
       System.out.println("NAME   : "+name);
       System.out.println("SALARY : Rs."+salary);

    }


  double getSalary(){
    return salary;
  }

}