package org.example.service;

import org.example.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "spring-cloud-alibaba-seata-storage-8006", path = "/storage")
public interface StorageService {

    /**
     * 扣减库存
     * @param productId 商品id
     * @param count 扣减数量
     * @return
     */
    @PostMapping(value = "/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
