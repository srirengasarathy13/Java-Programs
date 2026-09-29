package Test.Week5;
import java.util.ArrayList;
import java.util.List;

class NotificationRequest {

    private String notificationId;
    private String customerId;
    private String customerName;
    private String message;
    private String notificationType;

    public NotificationRequest(String notificationId, String customerId, String customerName, String message, String notificationType) {
        this.notificationId = notificationId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.message = message;
        this.notificationType = notificationType;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMessage() {
        return message;
    }

    public String getNotificationType() {
        return notificationType;
    }
}

interface Notification {
    void process(NotificationRequest request);
}

class EmailNotification implements Notification {
    @Override
    public void process(NotificationRequest request) {
        System.out.println("Email notification created.");
    }
}

class SMSNotification implements Notification {
    @Override
    public void process(NotificationRequest request) {
        System.out.println("SMS notification created.");
    }
}

class PushNotification implements Notification {
    @Override
    public void process(NotificationRequest request) {
        System.out.println("Push notification created.");
    }
}

class WhatsAppNotification implements Notification {
    @Override
    public void process(NotificationRequest request) {
        System.out.println("WhatsApp notification created.");
    }
}

class NotificationFactory {

    public static Notification createNotification(String type)
            throws Exception {

        switch (type.toLowerCase()) {

            case "email":
                return new EmailNotification();

            case "sms":
                return new SMSNotification();

            case "push":
                return new PushNotification();

            case "whatsapp":
                return new WhatsAppNotification();

            default:
                throw new Exception("Invalid notification type: " + type);
        }
    }
}

interface DeliveryStrategy {
    void send(NotificationRequest request);
}

class EmailDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending Email to customer: "+ request.getCustomerName());
    }
}
class SMSDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending SMS to customer: "+ request.getCustomerName());
    }
}

class PushDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending Push Notification to customer: "+ request.getCustomerName());
    }
}

class WhatsAppDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void send(NotificationRequest request) {
        System.out.println("Sending WhatsApp message to customer: "+ request.getCustomerName());
    }
}

interface NotificationObserver {
    void update(NotificationRequest request, String status);
}

class NotificationLog implements NotificationObserver {
    @Override
    public void update(NotificationRequest request, String status) {
        System.out.println("Notification "+ request.getNotificationId()+ " status = "+ status);
    }
}
class NotificationMonitor implements NotificationObserver {
    @Override
    public void update(NotificationRequest request, String status) {
        System.out.println("Monitor: "+ request.getNotificationType()+ " notification processed with status "+ status);
    }
}

class NotificationProcessor {

    private DeliveryStrategy strategy;
    private List<NotificationObserver> observers = new ArrayList<>();
    public void setDeliveryStrategy(DeliveryStrategy strategy) {
        this.strategy = strategy;
    }
    public void addObserver(NotificationObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(NotificationRequest request, String status) {
        for (NotificationObserver observer : observers) {
            observer.update(request, status);
        }
    }
    public void process(NotificationRequest request) {
        try {
            Notification notification = NotificationFactory.createNotification(request.getNotificationType());
            notification.process(request);
            strategy.send(request);
            System.out.println();
            System.out.println("Notification ID : "+ request.getNotificationId());
            System.out.println("Customer ID     : "+ request.getCustomerId());
            System.out.println("Notification Type : "+ request.getNotificationType());
            System.out.println("Message         : "+ request.getMessage());
            System.out.println("Processing Status : Success");
            notifyObservers(request, "Success");
        } catch (Exception e) {
            System.out.println();
            System.out.println("Processing Status : Failed");
            System.out.println("Error : " + e.getMessage());
            notifyObservers(request, "Failed");
        }
    }
}
public class Main {

    public static void main(String[] args) {
        
        System.out.println("------Notification Management System------");
        NotificationProcessor processor = new NotificationProcessor();
        processor.addObserver(new NotificationLog());
        processor.addObserver(new NotificationMonitor());
        NotificationRequest request1 = new NotificationRequest("N101","C101","Sri","Your order has been shipped.","email");
        processor.setDeliveryStrategy(new EmailDeliveryStrategy());
        processor.process(request1);
        NotificationRequest request2 = new NotificationRequest("N102","C102","Ravi","Your OTP is 4589.", "sms");
        processor.setDeliveryStrategy(new SMSDeliveryStrategy());
        processor.process(request2);
        NotificationRequest request3 = new NotificationRequest("N103","C103","Arun","You have a new notification.","push");
        processor.setDeliveryStrategy(new PushDeliveryStrategy());
        processor.process(request3);
        NotificationRequest request4 = new NotificationRequest("N104","C104","Kumar","Your appointment is tomorrow.","whatsapp");
        processor.setDeliveryStrategy(new WhatsAppDeliveryStrategy());
        processor.process(request4);
        NotificationRequest request5 =new NotificationRequest("N105","C105","John","Test invalid notification.", "telegram");
        processor.setDeliveryStrategy(new SMSDeliveryStrategy());
        processor.process(request5);
        System.out.println();
        System.out.println("Process completed");
    }
}