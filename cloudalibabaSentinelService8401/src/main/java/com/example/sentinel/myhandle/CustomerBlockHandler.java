package com.example.sentinel.myhandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.commons.domain.CommonResult;

public class CustomerBlockHandler {
    public static CommonResult handler1(BlockException exception){
        return new CommonResult(444,"用户自定义解决办法" + "\t 服务不可用。 -----1");
    }

    public static CommonResult handler2(BlockException exception){
        return new CommonResult(444,"用户自定义解决办法" + "\t 服务不可用。 -----2");
    }
}
