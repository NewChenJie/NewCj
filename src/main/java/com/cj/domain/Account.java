package com.cj.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private Integer id;

    private String name;

    private String phone;

    private LocalDate gmtCreate;

    private LocalDateTime gmtModified;

    private Byte deleted;


}