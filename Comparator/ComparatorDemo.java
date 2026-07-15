package Comparator;

import java.util.*;

class Employee
{
    int id;
    String name;

    Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

public class ComparatorDemo
{
    public static void main(String[] args)
    {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee(103, "Priya"));
        list.add(new Employee(101, "Ganesh"));
        list.add(new Employee(102, "Hari"));

        Collections.sort(list, new Comparator<Employee>()
        {
            @Override
            public int compare(Employee e1, Employee e2)
            {
                return e1.name.compareTo(e2.name);
            }
        });

        System.out.println("Sorted by Name");
        for (Employee e : list)
        {
            System.out.println(e.id + " " + e.name);
        }
    }
}