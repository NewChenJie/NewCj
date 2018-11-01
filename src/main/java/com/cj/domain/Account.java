package com.cj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Integer id;

    private String name;

    private String phone;

    private Date gmtCreate;

    private LocalDateTime gmtModified;

    private Byte deleted;


}