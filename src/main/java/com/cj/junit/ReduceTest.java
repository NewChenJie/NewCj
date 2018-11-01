package com.cj.junit;

import com.cj.domain.dto.Car;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Slf4j
public class ReduceTest {
    @Test
    public void reduceTest(){
        /**
         * identity的值是a的初始值，a是每次计算的结果，b是每一个元素的遍历
         */
        List<Integer> list = Lists.newArrayList(1,2,3,4);
//        Optional<Integer> sum = list.stream().reduce((a, b) -> a + b);
//        System.out.println(sum.get());
//        Integer sum1 = list.stream().reduce(0, (a, b) -> a + b);
//        System.out.println(sum1);
        Integer sum3 = list.stream().reduce(0, (a, b) -> {
         if(b%2==0) {
             return a * b;
         } else{ return a+b;}
        });
        System.out.println(sum3);
    }
    @Test
    public void maxTest(){
        List<Integer> list = Lists.newArrayList(1,2,3,4);
        Integer max = list.stream().reduce(Integer::max).orElse(0);
        Integer min = list.stream().reduce(Integer::min).orElse(0);
        Integer integer = list.stream().reduce(0, (a, b) -> a + b);
        if (list == null) {
            System.out.println(1);
        }
        System.out.println(integer);
        System.out.println(max);
        System.out.println(min);
    }

    @Test
    public void parallelTest(){
        List<Integer> list = Lists.newArrayList(1,2,3);
        Integer res = list.parallelStream().reduce(1, (a, b) ->
                {
                    log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@a:{},b:{}",a,b);
                    return  a*b*2;
                },
                (a, b) ->{
                   log.info("---a:{},b:{}---",a,b);
                    return a*b*2;}
                        );
        System.out.println(res);
    }

    @Test
    public void testApi(){
        Car one = Car.builder().money(100).type("火车dr").build();
        Car two = Car.builder().money(100).type("汽车e").build();
        Car three = Car.builder().money(200).type("卡车").build();
        ArrayList<Car> list = Lists.newArrayList(one, two, three);

        int a =2;
        for (Car car : list) {

            System.out.println(1);
        }
        //list转mpa
//        Map<Integer, Car> map = list.stream().collect(Collectors.toMap(Car::getMoney, x -> x));
        //按某个属性分组
        Map<Integer, List<Car>> map1 = list.stream().collect(Collectors.groupingBy(Car::getMoney));
        //按某个属性分组，并计算个数 也可以其他操作
        Map<Integer, Long> map2 = list.stream().collect(Collectors.groupingBy(Car::getMoney, Collectors.counting()));
        //按某个属性判断分区
        Map<Boolean, List<Car>> map3 = list.stream().collect(Collectors.partitioningBy(x -> x.getMoney() > 100));
        //排序
        List<Car> list1 = list.stream().sorted(Comparator.comparingInt(Car::getMoney)).collect(toList());
        //分组获取最大最小值
        Map<Integer, Optional<Car>> map4 = list.stream().collect(Collectors.groupingBy(Car::getMoney, Collectors.maxBy(Comparator.comparing(x -> x.getType().length()))));
        System.out.println(map4);
    }


}
