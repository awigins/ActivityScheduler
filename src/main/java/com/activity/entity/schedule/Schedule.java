package com.activity.entity.schedule;

import com.activity.entity.activity.Activity;
import com.activity.entity.event.EventInfo;
import lombok.Data;


@Data
public class Schedule {
    private Integer id;
    private String title;

    private EventInfo info;
    private Activity activity;


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

    public EventInfo getInfo() {
        return info;
    }

    public void setInfo(EventInfo info) {
        this.info = info;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + id +
                ", scheduleTitle='" + title + '\'' +
                ", info=" + info +
                ", activity=" + activity +
                '}';
    }

}
