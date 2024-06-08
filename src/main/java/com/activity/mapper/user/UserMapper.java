package com.activity.mapper.user;

import com.activity.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {
    Integer insert(@Param("user") User user);

    @Select("SELECT * FROM user WHERE user_id = #{userId} LIMIT 1;")
    User selectById(@Param("userId") Integer userId);
    @Select("SELECT * FROM user WHERE user_account_id = #{accountId} LIMIT 1;")
    User selectByAccountId(@Param("accountId") Integer accountId);
}
