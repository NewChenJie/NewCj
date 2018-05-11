package com.cj.controller;


import com.cj.domain.dto.YyDyw;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

@RestController
@RequestMapping("/time1")
public class TimeDemo {

    @GetMapping("/demo")
    public String demo(){
        YyDyw dyw1 = YyDyw.builder().userId(1).amountMoney(BigDecimal.valueOf(3)).build();
        YyDyw dyw2 = YyDyw.builder().userId(1).amountMoney(BigDecimal.valueOf(2)).build();
        YyDyw dyw3= YyDyw.builder().userId(2).amountMoney(BigDecimal.valueOf(4)).build();
        YyDyw dyw4= YyDyw.builder().userId(2).amountMoney(BigDecimal.valueOf(4)).build();
        List<YyDyw> dywList = new ArrayList<>();
        dywList.add(dyw1);
        dywList.add(dyw2);
        dywList.add(dyw3);
        dywList.add(dyw4);
        Map<Integer, BigDecimal> param = new HashMap<>();

        dywList.stream().map(YyDyw::getUserId).distinct().forEach(System.out::println);
        dywList.stream().map(YyDyw::getUserId).distinct().forEach(userId ->
        {
            Optional<BigDecimal> reduce = dywList.stream().filter(list -> userId.equals(list.getUserId())).map(YyDyw::getAmountMoney).reduce(BigDecimal::add);
            param.put(userId,reduce.orElse(BigDecimal.valueOf(0.00)));
        });
        System.out.println(param);
        return null;
    }


    /**
     * localDateTime转换成Date
     * @param localDateTime
     * @return
     */
    private Date getDate(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * Date转换成localDateTime
     * @param date
     * @return
     */
    private LocalDateTime getLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }



}
