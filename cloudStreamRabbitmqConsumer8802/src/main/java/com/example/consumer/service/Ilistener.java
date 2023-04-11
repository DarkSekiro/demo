package com.example.consumer.service;

import java.util.function.Consumer;

public interface Ilistener {

    Consumer<String> myChannel();
}
