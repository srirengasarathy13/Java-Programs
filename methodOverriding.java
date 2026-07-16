public class methodOverriding{

    public static void main(String[] args) {
        Emp1 e1 = new Emp1(101,"Sarathy",90000);
        e1.display();
        Developer dev = new Developer(102, "Sri", 100000, "Java");
        dev.display();
        Tester tes = new Tester(103, "Renga", 85000, "Selenium");
        tes.display();
        
    }
}

class Emp1{
    int id;
    String name;
    double salary;

    Emp1(int id, String name, double salary ){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    

    void display(){
        System.out.println("-------------------------------------");
        System.out.println("Employee ID           : "+id);
        System.out.println("Employee Name         : "+name);
        System.out.println("Employee Salary       : Rs."+salary);
    
    }

}

class Developer extends Emp1{
    String programmingLanguage;
    Developer(int id, String name, double salary, String programmingLanguage){
        super(id, name, salary);
        this.programmingLanguage = programmingLanguage;       
    }

    @Override
    void display(){
        System.out.println("Employee ID           : "+id);
        System.out.println("Employee Name         : "+name);
        System.out.println("Employee Salary       : Rs."+salary);
        System.out.println("Programming Languages : "+programmingLanguage);
    }

}


class Tester extends Emp1{
    String testingTool;
    Tester(int id, String name, double salary, String testingTool){
        super(id, name, salary);
        this.testingTool = testingTool;
        
    }

    @Override 
    void display(){
        System.out.println("Employee ID           : "+id);
        System.out.println("Employee Name         : "+name);
        System.out.println("Employee Salary       : Rs."+salary);
        System.out.println("Programming Languages : "+testingTool);
    }

}