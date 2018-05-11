package com.cj.controller;

import com.cj.domain.dto.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/test428")
public class DemoController {

   @GetMapping("/demo")
    public String demo(Date date){
       ArrayList<Person> users = getData();
//       long count = users.stream().distinct().count();
//       List<Person> sortedUsers = users.stream().sorted(Comparator.comparingInt(Person::getAge)).limit(3).collect(Collectors.toList());
//       List<Person> list = users.stream().filter(t -> t.getName().startsWith("季")).collect(Collectors.toList());
//       List<String> list = users.stream().map(t->t.getName()+":".concat(t.getSex()==1?"男":"女")+"\n").collect(Collectors.toList());
//       boolean b = users.stream().anyMatch(t -> t.getAge() > 18);
//       OptionalInt reduce = users.stream().mapToInt(t -> t.getAge()).reduce(Integer::sum);
//       Map<Integer, List<Person>> map = users.stream().collect(Collectors.groupingBy(Person::getAge));


       return null;
    }

    public ArrayList<Person> getData() {
        ArrayList<Person> users = new ArrayList<Person>();
        users.add(new Person(22, "王旭", "123456", 1, true));
        users.add(new Person(22, "王旭", "123456", 1, true));
        users.add(new Person(21, "孙萍", "a123456", 2, false));
        users.add(new Person(23, "步传宇", "b123456", 1, false));
        users.add(new Person(18, "蔡明浩", "c123456", 1, true));
        users.add(new Person(17, "郭林杰", "d123456", 1, false));
        users.add(new Person(25, "韩凯", "e123456", 1, true));
        users.add(new Person(22, "韩天琪", "f123456", 2, false));
        users.add(new Person(21, "郝玮", "g123456", 2, false));
        users.add(new Person(19, "胡亚强", "h123456", 1, false));
        users.add(new Person(14, "季恺", "i123456", 1, false));
        users.add(new Person(17, "荆帅", "j123456", 1, true));
        users.add(new Person(16, "姜有琪", "k123456", 1, false));
        return  users;
    }
}
