package com.activity.mapper.event;

import com.activity.entity.event.EventInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface EventInfoMapper {
    // 1.新增
    Integer insert(@Param("eventInfo") EventInfo eventInfo);

    // 2.更改
    Integer updateAll(@Param("eventInfo") EventInfo eventInfo);

    // 3.删除


    // 4.查询
    @Select("SELECT * FROM event_info WHERE event_info_id = #{eventInfoId} LIMIT 1;")
    EventInfo selectById(@Param("eventInfoId") Integer eventInfoId);

}
