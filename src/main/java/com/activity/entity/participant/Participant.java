package com.activity.entity.participant;

import com.activity.entity.activity.Activity;
import lombok.Data;


@Data
public class Participant {
    private Integer id;
    private Integer name;

    private ParticipantType type;
    private Activity activity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public ParticipantType getType() {
        return type;
    }

    public void setType(ParticipantType type) {
        this.type = type;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "participantId=" + id +
                ", participantName=" + name +
                ", participantType=" + type +
                ", activity=" + activity +
                '}';
    }

}
