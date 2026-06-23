package InterfaceAndLambda;

interface Addition{
    int add(int a, int b);
    
}
public class parameterizedLambdaAddition {
    public static void main(String[] args) {
        Addition addition = (a, b) -> a + b;
        System.out.println("The sum is: " + addition.add(10, 20));
    }
}
