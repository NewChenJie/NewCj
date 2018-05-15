package com.cj.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.temporal.IsoFields;
import java.util.Date;

@RestController
@RequestMapping("/time1")
public class TimeDemo {

    @GetMapping("/localtime")
    public String localTime(@DateTimeFormat(pattern = "yyyy-MM-dd") Date time){
        LocalDate date = LocalDate.of(1980, 10, 10);
        long aLong = date.getLong(IsoFields.WEEK_BASED_YEAR);
        DayOfWeek day = date.getDayOfWeek();
        DayOfWeek saturday = DayOfWeek.SATURDAY;
        int value = saturday.getValue();
        System.out.println(value);
        String name = saturday.name();
        System.out.println(name);
        DayOfWeek d = DayOfWeek.of(6);
        int value1 = Month.APRIL.getValue();
        System.out.println(value1);
        YearMonth now = YearMonth.now();
        System.out.println(now);

        return null;
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
        Instant instant = date.toInstant();
        return instant.atZone(ZoneId.systemDefault()).toLocalDate();
    }



}
