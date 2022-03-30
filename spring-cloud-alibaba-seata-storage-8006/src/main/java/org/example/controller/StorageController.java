package org.example.controller;

import lombok.extern.log4j.Log4j2;
import org.example.entity.CommonResult;
import org.example.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storage")
@Log4j2
public class StorageController {

    @Resource
    private StorageService storageService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        int decrease = storageService.decrease(productId, count);

        CommonResult result;
        if (decrease > 0) {
            result = new CommonResult(200, "from mysql,serverPort:  " + serverPort, decrease);
        }else {
            result = new CommonResult(505, "from mysql,serverPort:  " + serverPort + "，库存扣减失败");
        }
        return result;
    }

}
