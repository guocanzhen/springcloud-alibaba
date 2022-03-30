package org.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单
 */
@Data
public class Order implements Serializable {

    /**
     * id，主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 商品数量
     */
    private Integer count;

    /**
     * 商品金额
     */
    private BigDecimal money;

    /**
     * 订单状态
     */
    private Integer status;

}
