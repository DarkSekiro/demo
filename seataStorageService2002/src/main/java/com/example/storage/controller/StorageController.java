package com.example.storage.controller;

import com.example.commons.domain.CommonResult;
import com.example.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId")long productId, @RequestParam("count")int count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功");
    }
}
