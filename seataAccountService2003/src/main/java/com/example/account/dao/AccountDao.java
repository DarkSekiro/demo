package com.example.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface AccountDao {
    void decrease(@Param("userId")long userId, @Param("money")BigDecimal money);
}
