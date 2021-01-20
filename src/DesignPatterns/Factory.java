package DesignPatterns;

// Creation Design Pattern
//Summary: In Factory pattern, we create object without exposing the creation logic to client
// and the client use the same common interface to create new type of object. Its mainly used for loose coupling where we will have an interface and we have multiple
// implementation of that interface. So, the factory class will be responsible for creating the object for those multiple implementations.

// Problem : Consider we want to implement a notification service through email, SMS, and push notification. Let’s try to implement this with the help of factory
// method design pattern.

// Usage: getInstance() method of java.util.Calendar, NumberFormat, and ResourceBundle uses factory method design pattern.
public class Factory {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("EMAIL");
        notification.notifyUser();
    }
}
class NotificationFactory {
    public Notification createNotification(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        } else if ("SMS".equals(str)) {
            return new SMSNotification();
        } else if ("EMAIL".equals(str)) {
            return new EmailNotification();
        } else {
            return new PushNotification();
        }
    }
}
class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an EMAIL notification");
    }
}

class SMSNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

class PushNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Sending an Push notification");
    }
}
interface Notification {
    void notifyUser();
}
