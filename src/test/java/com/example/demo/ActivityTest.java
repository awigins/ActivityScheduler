package com.example.demo;

import com.activity.entity.activity.Activity;
import com.activity.entity.activity.ActivityState;
import com.activity.entity.user.User;
import com.activity.mapper.activity.ActivityMapper;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;


@MapperScan("com.activity.mapper.activity")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ActivityTest {
    @Resource
    private ActivityMapper activityMapper;
    //private ActivityService activityService;

    private Activity createTestActivity(){
        Activity activity = new Activity();
        // 0.设置必要信息
        activity.setTitle("test");

        // 1.获取创建时间
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 将当前时间转换为 Timestamp 类型
        Timestamp timestamp = Timestamp.valueOf(currentTime);
        activity.setCreationTime(timestamp);
        activity.setLastUpdateTime(timestamp);

        // 2.生成UUID
        UUID uuid = UUID.randomUUID();
        activity.setUUID(uuid.toString());

        // 3.设置默认状态
        ActivityState activityState = new ActivityState();
        activityState.setId(1);
        activity.setState(activityState);

        // 4.设置活动管理员用户
        User user = new User();
        user.setId(1);
        activity.setAdminUser(user);

        return activity;
    }

    @Test
    public void main() {
        System.out.println("Test Result:");
        System.out.println(activityMapper.selectAll());
    }
}
