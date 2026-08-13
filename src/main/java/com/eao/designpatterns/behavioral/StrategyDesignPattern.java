package com.eao.designpatterns.behavioral;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new CardPayment());
        paymentService.processPayment();

        PaymentService paymentService1 = new PaymentService(new NetBankingPayment());
        paymentService1.processRefund();
    }
}

class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void processPayment() {
        paymentStrategy.pay();
    }

    void processRefund() {
        paymentStrategy.refund();
    }
}


interface PaymentStrategy {
    void pay();
    void refund();
}

class CardPayment implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Amount paid using card");
    }

    @Override
    public void refund() {
        System.out.println("Amount refunded to card");
    }
}

class UPIPayment implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Amount paid using UPI");
    }

    @Override
    public void refund() {
        System.out.println("Amount refunded to UPI");
    }
}

class NetBankingPayment implements PaymentStrategy {

    @Override
    public void pay() {
        System.out.println("Amount paid using NetBanking");
    }

    @Override
    public void refund() {
        System.out.println("Amount refunded to NetBanking");
    }
}