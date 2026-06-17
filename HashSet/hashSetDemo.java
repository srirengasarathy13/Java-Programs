package HashSet;
import java.util.*;

public class hashSetDemo {
    static HashSet<String> courses = new HashSet<>();
    static Scanner sc = new Scanner(System.in);
    static boolean running = true;
    public static void main(String[] args) {
        
        courses.add("Java");
        courses.add("Python");
        courses.add("Spring Boot");
        courses.add("MySQL");
        
        

        while(running){
            System.out.print("\nCourse Menu \n------------ \n 1.Add a course \n 2.Search a course \n 3.Remove a course \n 4.Display \n 5.Exit \n Enter any option : ");
            int opt = sc.nextInt();
            sc.nextLine();
            switch(opt){
                case 1 :
                    System.out.print("Enter a course name to add : ");
                    String courseAdd = sc.nextLine();
                    addCourse(courseAdd);
                    System.out.println("\n-------------------------------------");
                    break;
                case 2 :
                    System.out.print("Enter a course name to search : ");
                    String courseSearch = sc.nextLine();
                    checkCourseAvailability(courseSearch );
                    System.out.println("\n-------------------------------------");
                    break;
                case 3 :
                    System.out.print("Enter a course name to remove : ");
                    String courseRemove = sc.nextLine();
                    removeCourse(courseRemove);
                    System.out.println("\n-------------------------------------");
                    break;
                case 4 :
                    System.out.println("---------------");
                    System.out.println("  Course List  ");
                    System.out.println("---------------");
                    for(String c : courses){
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

    static void addCourse(String course){
        if(courses.contains(course)){
        System.out.println(course+" already exists !");
    }
    else{
        courses.add(course);
        System.out.println(course+" added sucessfully !");
    }
    }

    static void checkCourseAvailability(String course){
    if(courses.contains(course)){
        System.out.println(course+" available");
    }
    else{
        System.out.println(course+" not available");
       
    }
    }

    static void removeCourse(String course){
     if(courses.contains(course)){
        courses.remove(course);
        System.out.println(course+" deleted sucessfully !");
    }
    else{
        System.out.println(course+" doesn't exist");
       
    }
    }


    
    
}
