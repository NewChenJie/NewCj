package com.cj.controller;

import com.cj.domain.dto.YyDyw;
import com.cj.utils.RD;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.groups.Default;

@RestController
@RequestMapping("/vaild")
public class VaildController {

    @GetMapping("/test")
    public RD vaild(@Validated(value = {Default.class}) YyDyw yyDyw){
        return RD.success(yyDyw.getName());
    }

    @GetMapping("/demo")
    public RD demo(String time){
     String a="";
     String b="b";
        return RD.success();
    }
}
