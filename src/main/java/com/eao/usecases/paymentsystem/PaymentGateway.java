package com.eao.usecases.paymentsystem;

import java.util.UUID;

public interface PaymentGateway {
    PaymentResponse pay(Payment payment);
    default String randomId() {
        return UUID.randomUUID().toString();
    }
}
