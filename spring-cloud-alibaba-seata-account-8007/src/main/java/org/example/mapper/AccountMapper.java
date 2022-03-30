package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.Account;

import java.math.BigDecimal;

@Mapper
public interface AccountMapper {

    Account selectByUserId(Long userId);

    /**
     * 扣减余额
     * @param userId 用户id
     * @param money 扣减金额
     * @return
     */
    int decrease(Long userId, BigDecimal money);
}
