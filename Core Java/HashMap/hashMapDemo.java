package HashMap;
import java.util.*;
 class hashMapDemp{
    public static void main(String[] args) {
        HashMap<Integer, Stu> student = new HashMap<>();
        student.put(101, new Stu(101, "Sri", "CSE"));
        student.put(102, new Stu(102, "Renga", "ECE"));
        student.put(103, new Stu(103, "Sarathy", "IT"));
        System.out.println("---------------------------");
        Stu stu = student.get(101);
        stu.display();
    }
 }  

 class Stu{
    int id;
    String name;
    String dept;

    Stu(int id, String name, String dept){
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    void display(){
        System.out.println("Id         : "+id);
        System.out.println("Name       : "+name);
        System.out.println("Department : "+dept);
        System.out.println("---------------------------");
    }
}