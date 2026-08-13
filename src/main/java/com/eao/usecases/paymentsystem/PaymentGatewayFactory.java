package com.eao.usecases.paymentsystem;

import java.util.HashMap;
import java.util.Map;

import static com.eao.usecases.paymentsystem.PaymentGateways.*;


public class PaymentGatewayFactory {

    private static final Map<PaymentGateways, Class<? extends PaymentGateway>> classMap = new HashMap<>();

    PaymentGatewayFactory() {
        classMap.put(PAYPAL_PAYMENT_GATEWAY, PaypalPaymentGateway.class);
        classMap.put(STRIPE_PAYMENT_GATEWAY, StripePaymentGateway.class);
        classMap.put(RAZARPAY_PAYMENT_GATEWAY, RazarPayPaymentGateway.class);
    }

    public static PaymentGateway createPaymentGateway(PaymentGateways paymentGateway) throws RuntimeException {
        switch (paymentGateway) {
            case PAYPAL_PAYMENT_GATEWAY:
                return new PaypalPaymentGateway();
            case STRIPE_PAYMENT_GATEWAY:
                return new StripePaymentGateway();
            case RAZARPAY_PAYMENT_GATEWAY:
                return new RazarPayPaymentGateway();
            default:
                throw new RuntimeException(paymentGateway +" Payment Gateway not supported.");
        }
    }

}

