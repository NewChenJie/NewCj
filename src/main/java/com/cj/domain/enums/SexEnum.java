package com.cj.domain.enums;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum SexEnum {
 DEFAULT(0,"默认"),
 MAN(1,"男"),
 WOMEN(2,"女");

    private Integer id;
    private String desc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    SexEnum(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }
 public static Map<Integer,SexEnum> enumMap=new HashMap<>(16);
    static {
        for (SexEnum sexEnum : enumMap.values()) {
            enumMap.put(sexEnum.id,sexEnum);
        }
    }
    public static SexEnum valueOf(Integer type){
        return Optional.ofNullable(enumMap.get(type)).orElseThrow(()->new IllegalArgumentException("未知类型!"));
    }
}
