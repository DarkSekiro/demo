package com.example.order.lb.impl;

import com.example.order.lb.LoadBanlabce;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoadBanlabceImpl implements LoadBanlabce {

    private AtomicInteger current = new AtomicInteger(0);

    public final Integer getAndIncreament(){
        int next;
//        int current = atomicInteger.get();
        do {
             next = current.get() == 2147483647?0:current.get() + 1;
        }while(!current.compareAndSet(current.get(),next));
        return next;
    }

    @Override
    public ServiceInstance getInstance(List<ServiceInstance> instances) {

        int index = getAndIncreament() % instances.size();
        return instances.get(index);
    }
}
