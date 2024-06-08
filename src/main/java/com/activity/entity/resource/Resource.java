package com.activity.entity.resource;

import lombok.Data;


@Data
public class Resource {
    private Integer id;
    private String name;

    private ResourceType type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceType getType() {
        return type;
    }

    public void setType(ResourceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + id +
                ", resourceName='" + name + '\'' +
                ", resourceType=" + type +
                '}';
    }
}
