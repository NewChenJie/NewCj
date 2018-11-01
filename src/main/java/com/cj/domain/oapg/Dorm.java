package com.cj.domain.oapg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dorm {
    private Integer id;

    private Integer dormclass;

    private String dormname;

    private Integer userid;

    private Integer class2id;

    private String phone;

    private Integer num;

    private String detail;

    private LocalDateTime addtime;

    private Integer states;


}