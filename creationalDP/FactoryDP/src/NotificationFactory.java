public class NotificationFactory {
    public static Notification createNotification(String notificationType){
        switch(notificationType){
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SmsNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Invalid notification type");
        }
    }
}
