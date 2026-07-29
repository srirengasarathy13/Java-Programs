import java.util.ArrayList;

public class arrayList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Sri");
        students.add("Renga");
        students.add("Sarathy");
        for(String student : students){
            System.out.println(student);
        }

        
    }
}
