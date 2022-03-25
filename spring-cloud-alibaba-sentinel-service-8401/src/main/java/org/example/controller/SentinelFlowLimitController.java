package org.example.controller;

import com.alibaba.csp.sentinel.*;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@Log4j2
public class SentinelFlowLimitController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("testA")
    public String testA() {
//        return "服务访问成功------testA";
        return testAbySphU();
    }

    @GetMapping("testB")
    public String testB() {
//        return "服务访问成功------testB";
        return testBbySphO();
    }

    /**
     * 通过注解定义资源@SentinelResource
     * @return
     */
    @GetMapping("testC")
    @SentinelResource("testCbyAnnotation")
    public String testC() {
        log.info("服务访问成功------testC：" + serverPort);
        return "服务访问成功------testC：" + serverPort;
    }

    /**
     * 通过 Sentinel 控制台定义流控规则
     * @return
     */
    @GetMapping("testD")
    //通过注解定义资源,blockHandler 属性指定一个限流函数
    @SentinelResource(value = "testD-resource", blockHandler = "blockHandlerTestD")
    public String testD() {
        // 调用初始化流控规则的方法
//        initFlowRules();
        log.info("服务访问成功------testD：" + serverPort);
        return "服务访问成功------testD：" + serverPort;
    }


    /**
     * 通过 SphU 手动定义资源
     * @return
     */
    public String testAbySphU() {
        Entry entry = null;
        try {
            entry = SphU.entry("testAbySphU");
            // 业务逻辑 - 开始
            log.info("服务访问成功------testA：" + serverPort);
            return "服务访问成功------testA："+serverPort;
            // 业务逻辑 - 结束
        } catch (BlockException e) {
            log.info("testA 服务被限流");
            return "testA 服务被限流";
        }finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    /**
     * 通过 SphO 手动定义资源
     * @return
     */
    public String testBbySphO() {
        if (SphO.entry("testBbySphO")) {
            // 务必保证finally会被执行
            try {
                log.info("服务访问成功------testB：" + serverPort);
                return "服务访问成功------testB：" + serverPort;
            }finally {
                SphO.exit();
            }
        }else {
            // 资源访问阻止，被限流或被降级
            //流控逻辑处理 - 开始
            log.info("testB 服务被限流");
            return "testB 服务被限流";
            //流控逻辑处理 - 结束
        }
    }

    /**
     * testD 限流之后的逻辑
     *
     * 使用 @SentinelResource 注解的 blockHandler 属性时，需要注意以下事项：
     *
     * blockHandler 函数访问范围需要是 public；
     * 返回类型需要与原方法相匹配；
     * 参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException；
     * blockHandler 函数默认需要和原方法在同一个类中，若希望使用其他类的函数，则可以指定 blockHandler 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
     * 请务必添加 blockHandler 属性来指定自定义的限流处理方法，若不指定，则会跳转到错误页（用户体验不好）。
     * @param e
     * @return
     */
    public String blockHandlerTestD(BlockException e) {
        log.info(Thread.currentThread().getName() + "，TestD服务访问失败! 您已被限流，请稍后重试");
        return "TestD服务访问失败! 您已被限流，请稍后重试";
    }

    /**
     * 通过代码定义流量控制规则FlowRule
     */
//    private static void initFlowRules() {
//        List<FlowRule> rules = new ArrayList<>();
//        // 定义一个限流规则对象
//        FlowRule rule = new FlowRule();
//        // 资源名称
//        rule.setRefResource("testD-resource");
//        // 限流阈值的类型
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        // 设置 QPS 的阈值为 2
//        rule.setCount(2);
//        rules.add(rule);
//
//        //定义限流规则
//        FlowRuleManager.loadRules(rules);
//    }

}
