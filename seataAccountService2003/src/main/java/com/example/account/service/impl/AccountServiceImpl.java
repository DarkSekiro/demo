package com.example.account.service.impl;

import com.example.account.dao.AccountDao;
import com.example.account.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override

    public void decrease(long userId, BigDecimal money) {
        int a = 10/0;
        accountDao.decrease(userId, money);
    }
}
