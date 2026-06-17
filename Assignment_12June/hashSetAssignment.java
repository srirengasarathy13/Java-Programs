package Assignment_12June;
import java.util.*;

public class hashSetAssignment {
    static HashSet<String> students = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    static boolean running = true;
    public static void main(String[] args) {
        
        students.add("Sri");
        students.add("Yuvaraj");
        students.add("Danie");
        students.add("Prawin");
        
        while(running){
            System.out.print("\nCourse Menu \n------------ \n 1.Add a student \n 2.Search a student \n 3.Remove a student \n 4.Display \n 5.Exit \n Enter any option : ");
            int opt = sc.nextInt();
            sc.nextLine();
            switch(opt){
                case 1 :
                    System.out.print("Enter a student name to add : ");
                    String courseAdd = sc.nextLine();
                    addStudent(courseAdd);
                    System.out.println("\n-------------------------------------");
                    break;
                case 2 :
                    System.out.print("Enter a student name to search : ");
                    String courseSearch = sc.nextLine();
                    checkStudentAvailability(courseSearch );
                    System.out.println("\n-------------------------------------");
                    break;
                case 3 :
                    System.out.print("Enter a student name to remove : ");
                    String courseRemove = sc.nextLine();
                    removeStudent(courseRemove);
                    System.out.println("\n-------------------------------------");
                    break;
                case 4 :
                    System.out.println("---------------");
                    System.out.println("  Student List  ");
                    System.out.println("---------------");
                    for(String c : students){
                            System.out.println(" "+c);
                        }
                    System.out.println("\n-------------------------------------");
                    break;
                case 5 :
                    System.out.println("Existing application...");
                    running = false;
                    break;
                default :
                    System.out.println("Invalid Option Input !");
                    System.out.println("\n-------------------------------------");

            }
        }
        
    }

    static void addStudent(String student){
        if(students.contains(student)){
        System.out.println(student+" already exists !");
    }
    else{
        students.add(student);
        System.out.println(student+" added sucessfully !");
    }
    }

    static void checkStudentAvailability(String student){
    if(students.contains(student)){
        System.out.println(student+" available");
    }
    else{
        System.out.println(student+" not available");
       
    }
    }

    static void removeStudent(String student){
     if(students.contains(student)){
        students.remove(student);
        System.out.println(student+" removed sucessfully !");
    }
    else{
        System.out.println(student+" doesn't exist");
       
    }
    }


    
    
}
