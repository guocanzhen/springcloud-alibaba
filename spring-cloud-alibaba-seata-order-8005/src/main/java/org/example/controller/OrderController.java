package org.example.controller;

import org.example.entity.CommonResult;
import org.example.entity.Order;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 下单
     * @param productId 商品id
     * @param count 下单数量
     * @param money 下单金额
     * @return
     */
    @GetMapping("create/{productId}/{count}/{money}")
    public CommonResult create(@PathVariable("productId") Long productId,
                               @PathVariable("count") Integer count,
                               @PathVariable("money") BigDecimal money) {

        Order order = new Order();
        order.setProductId(productId);
        order.setCount(count);
        order.setMoney(money);
        return orderService.create(order);

    }

}
