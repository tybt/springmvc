package com.dao;

import com.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

	/**
     * 插入订单明细
     *
     * @param userId
     * @param goodsId
     * @return
     */
    int insertOrder(@Param("userId") long userId,@Param("goodsId") long goodsId, @Param("title")String title);

    /**
     * 根据用户手机号查询订单
     *
     * @param userPhone
     * @return
     */
    List<Order> queryByUserPhone(@Param("userPhone") long userPhone);

	
    /**
     * 根据偏移量查询订单列表
     * @param offset
     * @param limit
     * @return
     */
    List<Order> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
