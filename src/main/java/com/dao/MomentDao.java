package com.dao;
import com.entity.Moment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MomentDao {

    List<Moment> getId();

    int inserContent(@Param("id") long id,@Param("userid") long userid,@Param("content") String content,@Param("create_time") String create_time);


}
