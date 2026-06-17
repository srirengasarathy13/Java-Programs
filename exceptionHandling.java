public class exceptionHandling {

    public static void main(String[] args) {
        try{
            int salary = -100000;
            if(salary<=0){
                System.out.println(10/0);
            }
        }catch(Exception e){
            System.out.println("Invalid Salary !");
        }
        System.out.println("Employee Salary processed !");
    }
}