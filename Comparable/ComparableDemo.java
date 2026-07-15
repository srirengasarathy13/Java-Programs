package Comparable;
import java.util.*;

class Employee implements Comparable<Employee>
{
    int id;
    String name;

    Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

     @Override
    public int compareTo(Employee e)
    {
        return this.id - e.id;    
    }
}

public class ComparableDemo
{
    public static void main(String[] args)
    {
        
        ArrayList<Employee> list = new ArrayList<>();

        
        list.add(new Employee(103, "Priya"));
        list.add(new Employee(101, "Ganesh"));
        list.add(new Employee(102, "Hari"));

        Collections.sort(list);

        
        System.out.println("Employee List");
        for (Employee e : list)
        {
            System.out.println(e.id + " " + e.name);
        }
    }
}