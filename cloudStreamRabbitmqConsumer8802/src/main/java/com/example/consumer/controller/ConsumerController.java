package com.example.consumer.controller;

import com.example.consumer.service.Ilistener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private Ilistener ilistener;

    @GetMapping(value = "/getMessage")
    public String getMessage(){
      return ilistener.myChannel().toString();
    }
}
