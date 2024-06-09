package com.activity.entity.activity;

import com.activity.entity.event.EventInfo;
import com.activity.entity.user.User;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class Activity {
    // 1.内部字段
    private Integer id;
    private String title;
    private Timestamp creationTime;
    private Timestamp lastUpdateTime;
    private Boolean visible;
    private String UUID;

    // 2.外键
    private EventInfo info;
    private ActivityType type;
    private ActivityState state;
    private User adminUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public ActivityState getState() {
        return state;
    }

    public void setState(ActivityState state) {
        this.state = state;
    }

    public User getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

}
