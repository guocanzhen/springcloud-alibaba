package org.example.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 账户
 */
@Data
public class Account implements Serializable {

    /**
     * id，主键
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用金额
     */
    private BigDecimal used;

    /**
     * 余额
     */
    private BigDecimal residue;

}
