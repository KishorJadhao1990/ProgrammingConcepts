package com.eao.usecases.paymentsystem;

import java.time.LocalDate;

import static com.eao.usecases.paymentsystem.PaymentGateways.RAZARPAY_PAYMENT_GATEWAY;
import static com.eao.usecases.paymentsystem.PaymentStatus.*;

public class RazarPayPaymentGateway implements PaymentGateway {
    @Override
    public PaymentResponse pay(Payment payment) {
        return PaymentResponse.builder()
                .status(PENDING)
                .payment(payment)
                .transactionId(randomId())
                .transactionDate(LocalDate.now())
                .paymentGateway(RAZARPAY_PAYMENT_GATEWAY)
                .build();
    }
}
