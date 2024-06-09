package com.activity.entity.schedule;

import com.activity.entity.resource.Resource;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class ResourceReservationRecord {
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;

    private Resource resource;
    private Schedule schedule;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "ResourceReservationRecord{" +
                "reservationRecordId=" + id +
                ", start_time=" + startTime +
                ", end_time=" + endTime +
                ", resource=" + resource +
                ", schedule=" + schedule +
                '}';
    }

}
