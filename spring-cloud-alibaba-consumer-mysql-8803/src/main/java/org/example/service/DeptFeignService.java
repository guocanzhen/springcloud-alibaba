package org.example.service;

import org.example.entity.CommonResult;
import org.example.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "spring-cloud-alibaba-provider-mysql", path = "/dept")
public interface DeptFeignService {

    @GetMapping(value = "/get/{id}")
    CommonResult<Dept> get(@PathVariable("id") Integer id);

    @GetMapping(value = "/list")
    CommonResult<List<Dept>> list();

}
