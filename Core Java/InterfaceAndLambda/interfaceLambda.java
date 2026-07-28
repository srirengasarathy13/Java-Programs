package InterfaceAndLambda;
interface Greeting {
void sayHello();
}
public class interfaceLambda {
    
    public static void main(String[] args) {
        Greeting greeting = () -> System.out.println("Hello, Lambda!");
        greeting.sayHello();
    }
    
}

