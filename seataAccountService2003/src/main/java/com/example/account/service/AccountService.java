package com.example.account.service;

import java.math.BigDecimal;

public interface AccountService {
    void decrease(long userId, BigDecimal money);
}
