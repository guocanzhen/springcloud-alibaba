package org.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/dept/nacos/")
public class DeptController {

    @Value("${server.port}")
    private String serverPort;

    /**
     *
     * @return
     */
    @GetMapping(value = "/getPayment/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "<h2>服务访问成功！</h2>服务名：spring-cloud-alibaba-provider<br /> 端口号： " + serverPort + "<br /> 传入的参数：" + id;
    }

}
