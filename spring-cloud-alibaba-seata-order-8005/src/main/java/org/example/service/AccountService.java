package org.example.service;

import org.example.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "spring-cloud-alibaba-seata-account-8007", path = "/account")
public interface AccountService {

    /**
     * 减余额
     * @param userId 用户id
     * @param money 扣减金额
     * @return
     */
    @PostMapping(value = "/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);

}
