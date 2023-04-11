package com.example.payment.dao;

import com.example.commons.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {
     Integer add(Payment payment);
     Payment getById(long id);
}
