package com.example.order.dao;

import com.example.order.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    void add(Order order);
    void update(@Param("userId")long userId,@Param("status")int status);
}
