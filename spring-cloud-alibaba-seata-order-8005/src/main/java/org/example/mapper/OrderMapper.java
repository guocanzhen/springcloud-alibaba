package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Order;

@Mapper
public interface OrderMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Order order);

    int create(Order order);

    int insertSelective(Order order);

    //2 修改订单状态，从0改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order order);

    int updateByPrimaryKey(Order order);

}
