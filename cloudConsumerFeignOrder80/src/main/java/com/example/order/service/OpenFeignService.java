package com.example.order.service;


import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getById(@PathVariable("id") long id);

    @GetMapping(value = "/payment/timout")
    String setTimeout();
}
