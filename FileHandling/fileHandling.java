package FileHandling;
import java.io.FileWriter;
import java.io.FileReader;
public class fileHandling {
  public static void main(String[] args) {
    try{
       FileWriter fw = new FileWriter("employee.txt");
       fw.write("Employee Id   : 101\nEmployee Name : Sri\nDesignation   : Software Engineer\nSalary        : Rs. 50000");
       fw.close();

       FileReader fr = new FileReader("employee.txt");
       int i;
       while((i=fr.read())!=-1){
           System.out.print((char)i);
       }
       fr.close();

    }catch(Exception e){
        System.out.println(e.getMessage());
   

    }
  }
    
}