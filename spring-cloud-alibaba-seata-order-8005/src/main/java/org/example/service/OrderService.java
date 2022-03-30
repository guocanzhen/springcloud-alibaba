package org.example.service;

import org.example.entity.CommonResult;
import org.example.entity.Order;

public interface OrderService {

    /**
     * 创建订单数据
     * @param order
     */
    CommonResult<Order> create(Order order);

}
