package com.example.order.controller;

import com.example.commons.domain.CommonResult;
import com.example.order.domain.Order;
import com.example.order.service.OrderSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderSercice orderSercice;

    @GetMapping("order/add")
    CommonResult add(Order order){
        orderSercice.add(order);
        return new CommonResult(200,"下订单成功！");
    }
}
