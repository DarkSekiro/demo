package com.example.payment.serivce;

import com.example.commons.domain.Payment;


public interface PaymentService {
    Integer add(Payment payment);
    Payment getById(long id);
}
