package com.example.order.controller;

import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import com.example.order.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OpenFeignService openFeignService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")long id){
        return openFeignService.getById(id);
    }

    @GetMapping(value = "consumer/payment/timeout")
    public String setTimeOut(){
        return openFeignService.setTimeout();
    }
}
