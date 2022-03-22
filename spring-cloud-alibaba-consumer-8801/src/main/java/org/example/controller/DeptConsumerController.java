package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer/dept/nacos/")
public class DeptConsumerController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 服务提供者的服务名
     */
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("paymentInfo/{id}")
    public String paymentInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(serverURL + "/dept/nacos/getPayment/" + id, String.class);
    }
}
