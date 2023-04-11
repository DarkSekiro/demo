package com.example.consumer.controller;


import com.example.consumer.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getServerPort(@PathVariable("id")Integer id){
        return openFeignService.getPayment(id);
    }
}
