package com.activity.service.activity;

import com.activity.common.enums.misc.ActivityStateEnum;
import com.activity.entity.activity.Activity;
import com.activity.entity.activity.ActivityState;
import com.activity.entity.event.EventInfo;
import com.activity.entity.user.User;
import com.activity.mapper.activity.ActivityMapper;
import com.activity.mapper.activity.ActivityStateMapper;
import com.activity.mapper.event.EventInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
public class ActivityService {
    // 三种方法：
    // @Autowired：按类型自动装配
    // @Qualifier：按名称自动装配
    // @Resource：优先按名称装配，失败尝试按类型装配
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private EventInfoMapper eventInfoMapper;

    // @Transactional：保证事务的数据一致性
    @Transactional
    public Activity createAndGetActivity(Activity activity, User user) {
        // 1.获取创建时间
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 将当前时间转换为 Timestamp 类型
        Timestamp timestamp = Timestamp.valueOf(currentTime);
        activity.setCreationTime(timestamp);
        activity.setLastUpdateTime(timestamp);

        // 2.生成UUID
        UUID uuid = UUID.randomUUID();
        /**
        while( activityMapper.findByUUID(uuid.toString()) != null )
        {
            uuid = UUID.randomUUID();
        }
         **/
        activity.setUUID(uuid.toString());

        // 3.设置默认活动状态
        ActivityState activityState = new ActivityState();
        activityState.setId(ActivityStateEnum.PREPARING.getValue());
        activity.setState(activityState);

        // 4.设置活动管理员用户
        activity.setAdminUser(user);

        if( activityMapper.insert(activity).equals(1) ){
            return activity;
        }
        return null;
    }

    @Transactional
    public Integer delete(Activity activity){
        try {
            activityMapper.deleteById(activity.getId());
        }
        catch (Exception e){
            // TODO：异常处理
            return -1;
        }
        return 0;
    }

    @Transactional
    public Integer update(Activity activity) {
        try {
            activityMapper.update(activity);
        }
        catch (Exception e){
            // TODO：异常处理
            return -1;
        }
        return 0;
    }

    public List<Activity> showAll(){
        List<Activity> activityList = activityMapper.selectAll();
        return activityList;
    }



}
