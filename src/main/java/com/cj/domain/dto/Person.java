package com.cj.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int age;
    private String name;
    private String password;
    private Integer sex;
    private boolean hasMarried;
}
