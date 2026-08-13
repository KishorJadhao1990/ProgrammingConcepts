package com.eao.usecases.paymentsystem;

import java.time.LocalDate;

import static com.eao.usecases.paymentsystem.PaymentGateways.PAYPAL_PAYMENT_GATEWAY;
import static com.eao.usecases.paymentsystem.PaymentStatus.SUCCESS;

public class PaypalPaymentGateway implements PaymentGateway {
    @Override
    public PaymentResponse pay(Payment payment) {
        return PaymentResponse.builder()
                .status(SUCCESS)
                .payment(payment)
                .transactionId(randomId())
                .transactionDate(LocalDate.now())
                .paymentGateway(PAYPAL_PAYMENT_GATEWAY)
                .build();
    }
}
