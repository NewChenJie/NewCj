package com.cj.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
public class DtoTwo {
    private String name;
    private String sex;
    public void test(){
        DtoTwo two = new DtoTwo();
        two.setName("a").setSex("b");

    }
}
