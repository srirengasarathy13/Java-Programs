package Test.Week3;
import java.io.*;
import java.lang.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ConfigurationOperation{
        String operationName();

}
class Configure implements Serializable{
        private static final long serialVersion = 1L;
         private int configurationId;
         private String applicationName;
         private String environment;
         private String version;
         private String status;
public Configure(int configurationId, String applicationName,String environment, String version, String status) {
        this.configurationId = configurationId;
        this.applicationName = applicationName;
        this.environment = environment;
        this.version = version;
        this.status = status;
    }
    public int getConfigurationId() {
        return configurationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEnvironment() {
        return environment;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }
@ConfigurationOperation(operationName = "Configuration Validation")
public String validConfigure(){
        if(applicationName!=null && environment!=null && !environment.isEmpty() && version!=null && !version.isEmpty()){
                return "Valid Configuration !";
        }
        return "Invalid Configuration !";
}
@ConfigurationOperation(operationName = "Loading Configuration")
public String loadConfigure(){
        return "Configuration loaded successfully !";
}
@ConfigurationOperation(operationName = "Configuration Status")
public String configurationStatus(){
        return "Configure Status :  "+status;
}
@ConfigurationOperation(operationName = "Configuration Version")
public String configureVersion(){
        return "Configure Version :"+version;
}

}

public class Main{
        public static void main(String[] args) {
                ArrayList<Configure> configures = new ArrayList<>();
                Configure config1 = new Configure(1, "HRMS Application", "Development", "1.3", "Active");
                Configure config2 = new Configure(2, "Railway Booking Application", "Testing", "1.5", "Testing");
                Configure config3 = new Configure(3, "Restaurant Management Application", "Development", "2.0", "Active");
                configures.add(config1);
                configures.add(config2);
                configures.add(config3);
                try{
                        Class<?> configureClass = Class.forName("Test.Week3.Configure");
                        System.out.println("Class name : "+configureClass.getSimpleName());
                        Method[] methods = configureClass.getDeclaredMethods();
                        for(Configure configure : configures){
                                System.out.println();
                                System.out.println("Configuration Id :"+configure.getConfigurationId());
                                System.out.println();
                                for(Method method : methods){
                                        if(method.isAnnotationPresent(ConfigurationOperation.class)){
                                                ConfigurationOperation operation =  method.getAnnotation(ConfigurationOperation.class);
                                                System.out.println("Method :"+method.getName());
                                                System.out.println("Operation: "+operation.operationName());
                                                Object result = method.invoke(configure);
                                                System.out.println("Configurtion Id : "+configure.getConfigurationId());
                                                System.out.println("Operation result : "+result);
                                        }
        
                                }
                        }
                }catch(ClassNotFoundException e){
                        System.out.println("Class not found : "+e.getMessage());
                }catch(IllegalAccessException e){
                        System.out.println("Illegal access Exceptio caused : "+e.getMessage());
                }catch(InvocationTargetException e){
                        System.out.println("Invocation Target Exception caused : "+e.getMessage());
                }
                System.out.println();
                String fileName = "C:\\Sri\\Java Programs\\Test\\Week3\\configuration.ser";
                try {
                        FileOutputStream file = new FileOutputStream(fileName);
                        ObjectOutputStream output = new ObjectOutputStream(file);
                        output.writeObject(configures);
                        output.close();
                        file.close();
                        System.out.println("Configurations successfully serialized !");
                }catch(IOException e){
                        System.out.println("Serialization error : "+ e.getMessage());
                }
                ArrayList<Configure> restoredConfigures = null;
                try {
                        FileInputStream file =
                        new FileInputStream(fileName);
                        ObjectInputStream input = new ObjectInputStream(file);
                        restoredConfigures = (ArrayList<Configure>) input.readObject();
                        input.close();
                        file.close();
                        System.out.println("Configurations successfully restored !");
                }catch(IOException e){
                        System.out.println("Deserialization error : "+ e.getMessage());

                }catch(ClassNotFoundException e){
                        System.out.println("Class not found during deserialization.");
                }
                if (restoredConfigures != null) {
                        for(Configure configure : restoredConfigures){
                                System.out.println("\nConfiguration Id : "+ configure.getConfigurationId());
                                System.out.println("Application Name : "+ configure.getApplicationName());
                                System.out.println("Environment : "+ configure.getEnvironment());
                                System.out.println("Version : "+ configure.getVersion());
                                System.out.println("Status : "+ configure.getStatus());
                        }
                        System.out.println();
                        for(Configure original : configures){
                                boolean found = false;
                                for(Configure restored : restoredConfigures) {
                                        if (original.getConfigurationId() == restored.getConfigurationId() && original.getApplicationName().equals(restored.getApplicationName()) && original.getEnvironment().equals(restored.getEnvironment()) && original.getVersion().equals(restored.getVersion()) && original.getStatus().equals(restored.getStatus())) {
                                                found = true;
                                                break;
                                        }
                                }
                                if(found){
                                        System.out.println("Configuration "+ original.getConfigurationId()+ " : Restored correctly !");
                                }else{
                                        System.out.println("Configuration "+ original.getConfigurationId()+ " : Verification failed !");
                                }
                        }
        }
        }
}