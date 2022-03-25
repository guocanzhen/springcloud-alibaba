package org.example.controller;

import lombok.extern.log4j.Log4j2;
import org.example.entity.CommonResult;
import org.example.entity.Dept;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/dept")
@Log4j2
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("get/{id}")
    public CommonResult<Dept> get(@PathVariable("id") Integer id) {
        log.info("端口：" + serverPort + "\t + dept/get/");
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info("休眠1秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Dept dept = deptService.get(id);
        CommonResult<Dept> result = new CommonResult<>(200, "from mysql,serverPort:" + serverPort, dept);
        return result;
    }

    @GetMapping("list")
    public CommonResult<List<Dept>> list() {
        log.info("端口：" + serverPort + "\t + dept/list/");
        List<Dept> depts = deptService.selectAll();
        CommonResult<List<Dept>> result = new CommonResult<>(200, "from mysql,serverPort:" + serverPort, depts);
        return result;
    }

}
