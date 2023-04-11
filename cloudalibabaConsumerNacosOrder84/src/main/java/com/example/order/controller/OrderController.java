package com.example.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.commons.domain.CommonResult;
import com.example.commons.domain.Payment;
import com.example.commons.util.CommonConst;
import com.example.order.service.OpenFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController implements CommonConst {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OpenFeignService openFeignService;

    @GetMapping(value = "consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            fallback = "handleFallback",
            blockHandler = "handleBlock")
    public CommonResult<Payment> fallback(@PathVariable("id") long id){
        CommonResult<Payment> result = restTemplate.getForObject(PAYMENT_NACOS_URL + "/paymentSQL/" + id,
                CommonResult.class, id);
        if (id == 4){
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常！");
        }else if (result.getData()==null){
            throw new NullPointerException("NullPointerException,没有对应记录，空指针异常");
        }
        return result;
    }

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> openFeign(@PathVariable("id")long id){
        return openFeignService.paymentSQL(id);
    }

    public CommonResult<Payment> handleFallback(long id,Throwable e){
        Payment payment = new Payment(id,null);
        return new CommonResult(444,"兜底异常处理" + e.getMessage(),payment);
    }

    public CommonResult<Payment> handleBlock(long id, BlockException e){
        Payment payment = new Payment(id,null);
        return new CommonResult(455,"blockHandler-sentinel限流"+e.getMessage(),payment);
    }
}
