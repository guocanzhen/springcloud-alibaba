package org.example.controller;

import lombok.extern.log4j.Log4j2;
import org.example.entity.CommonResult;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
@Log4j2
public class AccountController {

    @Resource
    private AccountService accountService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        int decrease = accountService.decrease(userId, money);

        CommonResult result;
        if (decrease > 0) {
            result = new CommonResult(200, "from mysql,serverPort:  " + serverPort, decrease);
        }else {
            result = new CommonResult(505, "from mysql,serverPort:  " + serverPort, "，账户扣减失败");
        }
        return result;
    }

}
