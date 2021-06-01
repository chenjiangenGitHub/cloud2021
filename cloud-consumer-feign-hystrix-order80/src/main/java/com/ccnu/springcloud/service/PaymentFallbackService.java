package com.ccnu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "----------------PaymentFallbackService-paymentInfo_ok fall back";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackService-paymentInfoTimeOut fall back";
    }
}
