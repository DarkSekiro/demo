package com.example.payment.service;


public interface PaymentService {
    String paymentOK(Integer id);
    String paymentTimeOut(Integer id);
    String paymentCircuitBreaker(Integer id);
}
