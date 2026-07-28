import java.util.*;

class ArrayListAndHashMap {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, Student> student2 = new HashMap<>();

    public static void main(String[] args) {
        ArrayList<Student> student1 = new ArrayList<>();
        student1.add(new Student(101, "Sri", "CSE"));
        student1.add(new Student(102, "Yuvaraj", "CSE"));
        student1.add(new Student(103, "Daniel", "AIDS"));
        student1.add(new Student(104, "Prawin", "ECE"));
        student2.put(105, new Student(105, "Harini", "CSE"));
        student2.put(106, new Student(106, "Prithika", "CSE"));
        student2.put(107, new Student(107, "Sethu", "ECE"));
        student2.put(108, new Student(108, "Kirubanidhi", "EEE"));
        student2.put(109, new Student(109, "Naveen", "CSE"));

        boolean running = true;
        
        while (running) {
            System.out.println("\n1. View Students in ArrayList");
            System.out.println("2. View Students data in HashMap");
            System.out.println("3. Find any Student in HashMap");
            System.out.println("4. Remove any student from HashMap");
            System.out.println("5. Exit");
            System.out.print("Enter Any Option : ");
            
            int op = sc.nextInt();
            
            switch (op) {
                case 1:
                    System.out.println("\n------------------------------");
                    System.out.println("Printing Students in ArrayList");
                    System.out.println("------------------------------");
                    for (Student s : student1) {
                        s.display();
                    }
                    break;
                    
                case 2:
                    System.out.println("\n------------------------------");
                    System.out.println("Printing Students in HashMap");
                    System.out.println("------------------------------");
                    for (Student s : student2.values()) {
                        s.display();
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter an id to find : ");
                    int id = sc.nextInt();
                    checkStudentAvailability(id);
                    break;
                    
                case 4:
                    System.out.print("Enter an id to remove : ");
                    int sid = sc.nextInt();
                    removeStudent(sid);
                    break;
                    
                case 5:
                    System.out.println("Exiting application...");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid Option Input !");
                    break;
            }
        }
    }

    static void checkStudentAvailability(int id) {
        if (student2.containsKey(id)) {
            System.out.println("Student's data Exist !");
            Student data = student2.get(id);
            data.display();
        } else {
            System.out.println("Student's data doesn't exist");
        }
    }

    static void removeStudent(int id) {
        if (student2.containsKey(id)) {
            student2.remove(id);
            System.out.println("Student's data removed successfully !");
        } else {
            System.out.println("Student's data doesn't exist");
        }
    }
}

class Student {
    int id;
    String name;
    String dept;

    Student(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    void display() {
        System.out.println("Id : " + id);
        System.out.println("Name : " + name);
        System.out.println("Department : " + dept);
        System.out.println("---------------------------");
    }
}
