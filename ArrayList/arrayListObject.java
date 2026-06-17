import java.util.*;
public class arrayListObject {
    public static void main(String[] args) {
        ArrayList<Stu> students = new ArrayList<>();
        students.add(new Stu(1,"Sri","CSE"));
        students.add(new Stu(2,"Renga","ECE"));
        students.add(new Stu(3,"Sarathy","IT"));
    

    for(Stu s : students){
        s.display();
    }

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