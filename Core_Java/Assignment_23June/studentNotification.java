package Assignment_23June;

interface Notification {
    void sendNotification(String message);
}

public class studentNotification {

    public static void main(String[] args) {
        Notification notification = (message) -> System.out.println("Notification: " + message);
        notification.sendNotification("Tomorrow's class is cancelled.");
    }
}