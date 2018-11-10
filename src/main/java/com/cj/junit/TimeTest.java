package com.cj.junit;

import com.cj.domain.dto.Book;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TimeTest {
    @Test
    public void testTime(){
        Date start = new Date(2018,7,17,0,30,30);
        Date end = new Date();
        System.out.println( (int) ((end.getTime() - start.getTime()) / (1000*3600*24)));
    }
    @Test
    public  void testTim3(){
        Book book = Book.builder().id("1").name("dsf").build();
        Book book1 = Book.builder().id("2").name("ref").build();
        ArrayList<Book> list = Lists.newArrayList(book, book1);
        List<Book> books = list.stream().peek(x -> {
            x.setId("1");
            x.setName("2");
        }).collect(Collectors.toList());

        List<Book> list1 = list.stream().peek(x -> x.setId("3")).collect(Collectors.toList());
        System.out.println(list1);
    }

    @Test
    public void testTime4(){
        BigDecimal total=BigDecimal.valueOf(100);
        LocalDate reportDate = LocalDate.parse("2018-08"+"-01");
        LocalDate endDate = LocalDate.parse("2018-09-29");
        //2个时间的年月相等 取合同时间的天数 否则为该月的最大天数
        int days;
        if(endDate.getYear()==reportDate.getYear()&&endDate.getMonth()==reportDate.getMonth()){
            days=endDate.getDayOfMonth();
        }else {
            days=reportDate.getMonth().maxLength();
        }
        System.out.println(days);
        System.out.println(total.divide(BigDecimal.valueOf(days),2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(7)));


    }


    @Test
    public void testTime5(){
        ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
        List<Integer> s = list.stream().filter(x -> x == 1).collect(Collectors.toList());
        System.out.println(s);
    }


}



