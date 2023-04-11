package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallBackService.class)
public interface OrderHystrixService {
    @GetMapping(value = "/payment/hystrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id")Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id")Integer id);
}
