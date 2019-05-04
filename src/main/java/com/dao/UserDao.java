package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.User;

public interface UserDao {

    //增加用户
    int addCount(@Param("userid") long userid,@Param("phone") int phone,@Param("password") String password);

    //查询用户
    List<User> queryUser(@Param("phone") long phone);

    //电话号码查询密码
    List<User> selecPasswordByphone(@Param("phone") long phone);
	/**
     * 根据手机号查询用户对象
     *
     * @param userPhone
     * @return
     */
    User queryByPhone(long userPhone);


    /**
     * 根据偏移量查询用户列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    
    /**
     * 增加积分
     */
    void addScore(@Param("add")int add);
	
}
