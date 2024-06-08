package com.activity.common.enums.misc;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ActivityStateEnum implements IEnum<Integer> {
    PREPARING(1, "筹备中"),
    RECRUITING(2, "招募中"),
    ONGOING(3, "进行中"),
    COMPLETED(4, "已完成"),
    CANCELED(5, "被取消");

    private final Integer value;
    private final String name;

    @Override
    public Integer getValue() {
        return this.value;
    }

}
