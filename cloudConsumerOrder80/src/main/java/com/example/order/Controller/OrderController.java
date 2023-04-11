package com.example.order.Controller;



import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import com.example.commons.util.CommonConst;

import com.example.order.lb.LoadBanlabce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class OrderController implements CommonConst{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBanlabce loadBanlabce;

    @GetMapping(value = "/consumer/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMET_URL + "payment/add",payment,CommonResult.class);
    }

    @GetMapping(value = "consumer/payment/get/{id}")
    public CommonResult<Integer> getById(@PathVariable("id") long id){
        return restTemplate.getForObject(PAYMET_URL + "payment/get/" + id,CommonResult.class);
    }

    @GetMapping(value = "consumer/payment/getForEntity/{id}")
    public CommonResult<Integer> getPayment(@PathVariable("id") long id){
        ResponseEntity<CommonResult> entity = restTemplate
                .getForEntity(PAYMET_URL + "payment/get/" + id, CommonResult.class);
        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else{
            return new CommonResult<>(444,"操作失败");
        }

    }

    @GetMapping(value = "consumer/payment/lb")
    public String getPaymentLb(){
        List<ServiceInstance> services = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = loadBanlabce.getInstance(services);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }


}
