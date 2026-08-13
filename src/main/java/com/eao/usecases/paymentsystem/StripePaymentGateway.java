package com.eao.usecases.paymentsystem;

import java.time.LocalDate;


public class StripePaymentGateway implements PaymentGateway {
    @Override
    public PaymentResponse pay(Payment payment) {
        return PaymentResponse.builder()
                .status(PaymentStatus.FAILED)
                .payment(payment)
                .transactionId(randomId())
                .transactionDate(LocalDate.now())
                .paymentGateway(PaymentGateways.STRIPE_PAYMENT_GATEWAY)
                .build();
    }
}
