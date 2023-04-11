package com.example.storage.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    void update(@Param("productId")long productId,@Param("count")int count);
}
