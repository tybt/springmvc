package com.dao;
import com.entity.Moment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MomentDao {

    List<Moment> getId();

    int inserContent(@Param("id") long id,@Param("userid") long userid,@Param("content") String content,@Param("create_time") String create_time,@Param("imgs") String imgs);

    //获取狐友动态
    List<Moment> getMoment();

    //获取评论
    List getMoemntReply(@Param("moment_id") long moment_id);

    //获取动态的点赞数量
    int getFavorite(@Param("moment_id") long moment_id);

    //设置赞
    int setFavor(@Param("id") long id,@Param("moment_id") long moment_id,@Param("favorite_user_id") long favorite_user_id);

    //删除赞
    int deleteFavor(@Param("moment_id") long moment_id,@Param("favorite_user_id") long favorite_user_id);

}
