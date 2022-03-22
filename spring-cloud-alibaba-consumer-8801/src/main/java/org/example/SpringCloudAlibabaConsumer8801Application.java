package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
// 开启服务注册与发现功能
@EnableDiscoveryClient
public class SpringCloudAlibabaConsumer8801Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaConsumer8801Application.class, args);
    }
}
