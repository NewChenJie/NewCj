package com.cj.controller;

import com.cj.exception.Redirect;
import com.cj.utils.KeyValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test428")
public class DemoController {

   @GetMapping("/demo")
   @ResponseBody
    public String demo(){

       return "redirect:/test428/hell";
    }

    @GetMapping("/hello")
    public KeyValue hello(){
        System.out.println(2);
        throw  new Redirect();
    }
}
