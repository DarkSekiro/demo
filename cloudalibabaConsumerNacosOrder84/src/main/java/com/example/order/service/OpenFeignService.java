package com.example.order.service;

import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import com.example.order.service.impl.OpenFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "nacos-payment-provider",fallback = OpenFeignServiceImpl.class)
public interface OpenFeignService {
    @GetMapping(value = "/paymentSQL/{id}")
    CommonResult<Payment> paymentSQL(@PathVariable("id") Long id);
}
