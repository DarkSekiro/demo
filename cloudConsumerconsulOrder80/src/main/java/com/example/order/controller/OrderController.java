package com.example.order.controller;

import com.example.commons.util.CommonConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController implements CommonConst {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/consumer/payment/consul")
    public String payment(){
        String s = restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
        return s;
    }
}
