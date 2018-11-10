package com.cj.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.util.Date;

@RestController
@RequestMapping("/time1")
public class TimeDemo {

    @PostMapping("/localtime")
    public String localTime(){
        LocalDate date = LocalDate.now();
        System.out.println(date);
        return date.toString();
    }

    private void diff() {
        LocalDate localDate = LocalDate.of(1980,10,14);
        LocalDate date = LocalDate.of(1993,9,15);
        Period between = Period.between(localDate, date);
        //年,月,日
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
        //总天数
        System.out.println(date.toEpochDay()-localDate.toEpochDay());
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
    private LocalDate getLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 日期差
     * @param start
     * @param end
     * @return
     */
    private int dayDiff(Date start,Date end){
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime startTime = LocalDateTime.ofInstant(start.toInstant(), zone);
        LocalDateTime endTime=LocalDateTime.ofInstant(end.toInstant(),zone);
        return (int)Duration.between(startTime,endTime).toDays();
    }



}
