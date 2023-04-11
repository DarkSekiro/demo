package com.example.order.service.impl;

import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import com.example.order.service.OpenFeignService;
import org.springframework.stereotype.Component;


@Component
public class OpenFeignServiceImpl implements OpenFeignService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult(4444,"服务降级返回",new Payment(id,null));
    }
}
