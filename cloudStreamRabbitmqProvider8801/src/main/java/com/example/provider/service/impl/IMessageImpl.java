package com.example.provider.service.impl;

import com.example.provider.service.IMessage;
import com.google.inject.spi.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IMessageImpl implements IMessage {
    @Autowired
    private StreamBridge streamBridge;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        streamBridge.send("myChannel-out-0",MessageBuilder.withPayload(serial).build());
        return null;
    }
}
