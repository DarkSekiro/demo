package com.example.order.service.impl;

import com.example.order.dao.OrderDao;
import com.example.order.domain.Order;
import com.example.order.service.AccountService;
import com.example.order.service.OrderSercice;
import com.example.order.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class OrderSerciceImpl implements OrderSercice {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private AccountService accountService;
    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-creat-order",rollbackFor = Exception.class)
    public void add(Order order) {
        log.info(">>>>>开始下订单");
        orderDao.add(order);
        log.info(">>>>>>>>>>>减库存");
        storageService.decrease(order.getProductId(),order.getCount());

        log.info(">>>>>>>>>>>扣余额");
        accountService.decrease(order.getUserId(),order.getMoney());

        log.info(">>>>>>>>>>修改订单状态");
        orderDao.update(order.getUserId(),0);
        log.info(">>>>>>>>>>>>>>下订单成功！");
    }
}
