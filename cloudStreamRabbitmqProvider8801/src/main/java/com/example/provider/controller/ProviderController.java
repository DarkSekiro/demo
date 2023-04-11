package com.example.provider.controller;

import com.example.provider.service.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Autowired
    private IMessage iMessage;

    @GetMapping(value = "/sendMessage")
    public String sendMessage()
    {
        return iMessage.send();
    }
}
