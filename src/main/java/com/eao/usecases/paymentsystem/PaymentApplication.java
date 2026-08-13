package com.eao.usecases.paymentsystem;

public class PaymentApplication {
    public static void main(String[] args) throws RuntimeException {
        Payment payment = new Payment();
        payment.setAmount(50000L);
        payment.setCustomerId("1");
        payment.setCustomerName("Raman");
        PaymentGateway paymentGateway = PaymentGatewayFactory.createPaymentGateway(PaymentGateways.RAZARPAY_PAYMENT_GATEWAY);
        PaymentResponse paymentResponse = paymentGateway.pay(payment);
        System.out.println(paymentResponse);
    }
}
