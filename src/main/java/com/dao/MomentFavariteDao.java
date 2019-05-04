package com.dao;


import org.apache.ibatis.annotations.Param;


public interface MomentFavariteDao {
   int getFavorite(@Param("moment_id") long moment_id);
}
