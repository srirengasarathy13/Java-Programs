package InterfaceAndLambda;
interface Greetings{
    void display();
}

class Hello implements Greetings{
    public void display(){
        System.out.println("Hello!");
    }
}

public class functionalInterface {

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.display();  
    }
}