package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    //增加用户
    int addCount(@Param("account") String account,@Param("password") String password);

    int changeImg(@Param("userid") long userid,@Param("user_photo") String user_photo);

    //查询用户
    List<User> queryUser(@Param("account") String account);

    //电话号码查询密码
    List<User> selecPasswordByphone(@Param("phone") long phone);

    //根据账户查询用户信息
    Map selectUserinfoByAccount(@Param("account") String account);

    //账号查询密码
    List<User> selecPasswordByAccount(@Param("account") String name);

    User queryByPhone(long userPhone);

    List<User> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    
    /**
     * 增加积分
     */
    void addScore(@Param("add")int add);
	
}
