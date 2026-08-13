package com.eao.usecases.paymentsystem;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class PaymentResponse {
    private Payment payment;
    private PaymentStatus status;
    private String transactionId;
    private PaymentGateways paymentGateway;
    private LocalDate transactionDate;

    @Override
    public String toString() {
        return "PaymentResponse {" +
                "\npayment=" + payment +
                ",\nstatus=" + status +
                ",\ntransactionId='" + transactionId + '\'' +
                ",\npaymentGateway='" + paymentGateway + '\'' +
                ",\ntransactionDate=" + transactionDate +
                "\n}";
    }
}

