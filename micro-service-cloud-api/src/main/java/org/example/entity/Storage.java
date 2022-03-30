package org.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 库存
 */
@Data
public class Storage implements Serializable {

    /**
     * id，主键
     */
    private Long id;

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
