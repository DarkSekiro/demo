package com.example.order.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBanlabce {

    ServiceInstance getInstance(List<ServiceInstance> instances);
}
