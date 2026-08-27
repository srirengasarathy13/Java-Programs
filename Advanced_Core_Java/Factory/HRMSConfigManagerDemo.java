package Factory;
 
class Managerconfig
{
    private static Managerconfig instance;
    private Managerconfig()
    {
        System.out.println("HRMS Manager configurtion Created");
    }
    public static Managerconfig getInstance()
    {
        if (instance == null)
        {
            instance = new Managerconfig();
        }
        return instance;
    }
    public void showcompanyname()
    {
        System.out.println("Company Name : Agnie Consulting Pvt Ltd");
    }
    public void showdatabase()
    {
        System.out.println("Database display is initiated...");
    }
    public void showversion()
    {
        System.out.println("Version : 202.18.v14");
    }
}
public class HRMSConfigManagerDemo {
    public static void main(String[] args) {
        Managerconfig db1 = Managerconfig.getInstance();
        Managerconfig db2 = Managerconfig.getInstance();
        Managerconfig db3=Managerconfig.getInstance();
        db1.showcompanyname();
        db2.showdatabase();
        db3.showversion();
        System.out.println("Same object : "+(db1==db2 && db2==db3 && db1==db3));
    }
   
}
 
 