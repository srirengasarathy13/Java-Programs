package Factory;

interface PaymentF {
    void processPayment(double amount);
}

class SalaryPayment implements PaymentF {
    public void processPayment(double amount) {
        System.out.println("Salary paid: Rs." + amount);
    }
}

class BonusPayment implements PaymentF {
    public void processPayment(double amount) {
        System.out.println("Bonus paid: Rs." + amount);
    }
}

class ReimbursementPayment implements PaymentF {
    public void processPayment(double amount) {
        System.out.println("Reimbursement paid: Rs." + amount);
    }
}

class PaymentFactory {

    public PaymentF createPayment(String type) {

        if ("SALARY".equalsIgnoreCase(type)) {
            return new SalaryPayment();
        }
        else if ("BONUS".equalsIgnoreCase(type)) {
            return new BonusPayment();
        }
        else if ("REIMBURSEMENT".equalsIgnoreCase(type)) {
            return new ReimbursementPayment();
        }

        throw new IllegalArgumentException(
            "Invalid payment type: " + type
        );
    }
}

public class HRMSPaymentFactoryDemo {

    public static void main(String[] args) {

        PaymentFactory factory = new PaymentFactory();

        PaymentF payment1 = factory.createPayment("SALARY");
        payment1.processPayment(30000);

        PaymentF payment2 = factory.createPayment("BONUS");
        payment2.processPayment(5000);

        PaymentF payment3 = factory.createPayment("REIMBURSEMENT");
        payment3.processPayment(2500);
    }
}