package com.example.consumer.service.impl;

import com.example.consumer.service.Ilistener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
@Service
@Slf4j
public class IlistenerImpl implements Ilistener {

    @Override
    @Bean
    public Consumer<String> myChannel() {
        return message->{
            log.info("接收消息为：" + message);
        };
    }
}
