package com.example.account.contorller;

import com.example.account.domain.Account;
import com.example.account.service.AccountService;
import com.example.commons.domain.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;
    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId")long userId, @RequestParam("count") BigDecimal money){
        accountService.decrease(userId, money);
        return new CommonResult(200,"扣款成功！");
    }
}
