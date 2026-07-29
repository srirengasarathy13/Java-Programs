abstract class Empp{
   int id;
   String name;
   double salary;

   Empp(int id, String name, double salary){
    this.id = id;
    this.name = name;
    this.salary = salary;
   }

   abstract void work();
   
   void display(){
    System.out.println("Id      : "+id);
    System.out.println("Name    : "+name);
    System.out.println("Salary   : Rs."+salary);
    
   }
}

class Devv extends Empp{

    Devv(int id, String name, double salary){
        super(id, name, salary);
    }


    void work(){
        System.out.println("Developer is working !");
    }
}


class abstraction{
    public static void main(String[] args) {
        Devv dev1 = new Devv(101, "Sri", 100000);
        dev1.display();
        dev1.work();
    }
}