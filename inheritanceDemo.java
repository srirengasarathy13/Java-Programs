public class inheritanceDemo {

    public static void main(String[] args) {
        Developer dev = new Developer(101, "Sri", 100000, "Java");
        dev.display();
    }
}

class Emp{
    int id;
    String name;
    double salary;

    Emp(int id, String name, double salary ){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

}

class Developer extends Emp{
    String programmingLanguage;
    Developer(int id, String name, double salary, String programmingLanguage){
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;
        
    }


    void display(){
        System.out.println("Employee ID           : "+id);
        System.out.println("Employee Name         : "+name);
        System.out.println("Employee Salary       : Rs."+salary);
        System.out.println("Programming Languages : "+programmingLanguage);
    }

}