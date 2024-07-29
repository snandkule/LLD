public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Notification email = NotificationFactory.createNotification("EMAIL");
        email.send("This is an email message.");

        Notification sms = NotificationFactory.createNotification("SMS");
        sms.send("This is an SMS message.");

        Notification push = NotificationFactory.createNotification("PUSH");
        push.send("This is a push notification message.");
    }
}