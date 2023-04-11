package com.example.payment.serivce.impl;

import com.example.commons.domain.Payment;
import com.example.payment.dao.PaymentDao;

import com.example.payment.serivce.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment getById(long id) {
        return paymentDao.getById(id);
    }
}
