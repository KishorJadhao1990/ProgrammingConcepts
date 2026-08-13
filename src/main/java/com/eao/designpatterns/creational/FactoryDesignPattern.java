package com.eao.designpatterns.creational;

public class FactoryDesignPattern {
    public static void main(String[] args) throws Exception {
        PaymentGateway paymentGateway =  GatewayFactory.create("alepay");
        paymentGateway.pay(2000L);
    }
}

class GatewayFactory  {
    public static PaymentGateway create(String type) throws Exception {
        switch (type.toUpperCase()) {
            case "STRIPE" : return new StripePaymentGateway();
            case "RAZERPAY" : return new RazerPaymentGateway();
            case "ALEPAY" : return new AlePaymentGateway();
            default:
                throw new Exception("Type not supported");
        }
    }
}

//
interface PaymentGateway {
    void pay(Long amount);
}

class StripePaymentGateway implements PaymentGateway {

    @Override
    public void pay(Long amount) {
        System.out.println(amount+" sent using stripe payment gateway");
    }
}

class AlePaymentGateway implements PaymentGateway {
    @Override
    public void pay(Long amount) {
        System.out.println("Money sent using ale pay payment gateway");
    }
}

class RazerPaymentGateway implements PaymentGateway {
    @Override
    public void pay(Long amount) {
        System.out.println("Money sent using razer payment gateway");
    }
}

