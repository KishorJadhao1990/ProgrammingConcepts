package com.eao.designpatterns.creational;

// Object should be created once
public class SingletonDesignPattern {

    public static void main(String[] args) {
        System.out.println("======Check eager implementation======");
        NotificationService notificationService = NotificationService.getInstance();
        notificationService.sendEmailNotification();

        System.out.println("======Check for same object======");
        NotificationService notificationService1 = NotificationService.getInstance();
        // Same object return due to static variable and created on class level
        System.out.println(notificationService);
        System.out.println(notificationService1);

        System.out.println("======Check lazy implementation======");
        PaymentService paymentService = PaymentService.getInstance();
        paymentService.pay();
        PaymentService paymentService1 = PaymentService.getInstance();
        System.out.println(paymentService);
        System.out.println(paymentService1);

        System.out.println("======Check Thread safety check======");
        Runnable runnable = () -> {
            PaymentService paymentService2 = PaymentService.getInstance();
            System.out.println(paymentService2);
        };

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.run();
        thread1.run();
    }
}

// Eager singleton pattern
class NotificationService {

    private static NotificationService notificationService =  new NotificationService();

    // Make constructor private to overwrite existing public no arg constructor to disallow object creation outside
    private NotificationService() {
    }

    // No need to check
    public static NotificationService getInstance() {
        return notificationService;
    }

    public void sendSmsNotification() {
        System.out.println("SMS notification sent");
    }

    public void sendEmailNotification() {
        System.out.println("Email notification sent");
    }
}

// Lazy singleton pattern
class PaymentService {
    private static PaymentService paymentService;

    // Make constructor private to overwrite existing public no arg constructor to disallow object creation outside
    private PaymentService() {
    }

    public static PaymentService getInstance() {
        if (paymentService == null) {
            paymentService = new PaymentService();
        }
        return paymentService;
    }

    public void pay() {
        System.out.println("Payment done");
    }
}