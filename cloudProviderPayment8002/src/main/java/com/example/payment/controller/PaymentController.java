package com.example.payment.controller;


import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import com.example.payment.serivce.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/add")
//    @ResponseBody
    public CommonResult add(@RequestBody Payment payment){
        Integer result = paymentService.add(payment);
        return result == 1 ? new CommonResult(200,"插入数据库成功" + serverPort)
                : new CommonResult(444,"插入数据库失败");
    }

    @GetMapping(value = "/payment/get/{id}")
//    @ResponseBody
    public CommonResult<Payment> getById(@PathVariable("id") long id){
        Payment payment = paymentService.getById(id);
        return payment != null? new CommonResult(200,"查询成功" + serverPort,payment)
                : new CommonResult(444,"查询失败",null);
    }
    @GetMapping(value = "payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping(value = "/payment/timout")
    public String setTimeout(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serverPort;
    }
}
