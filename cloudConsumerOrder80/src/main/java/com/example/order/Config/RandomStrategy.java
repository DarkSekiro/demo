package com.example.order.Config;



import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.*;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class RandomStrategy {
    ReactorLoadBalancer<ServiceInstance> randomLoadBalance(Environment environment,
                                                           LoadBalancerClientFactory loadBalancerClientFactory){
        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        return new RoundRobinLoadBalancer(loadBalancerClientFactory
                .getLazyProvider(name,ServiceInstanceListSupplier.class),name);
//        return new RandomLoadBalancer(loadBalancerClientFactory
//                .getLazyProvider(name,ServiceInstanceListSupplier.class),name);
    }
}
