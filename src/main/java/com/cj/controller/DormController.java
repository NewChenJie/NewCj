package com.cj.controller;

import com.cj.mapper.oapg.DormMapper;
import com.cj.service.DormService;
import com.cj.utils.RD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dorm")
public class DormController {

    @Autowired
    DormMapper dormMapper;

    @Autowired
    DormService dormServiceImpl;
    @GetMapping("/test")
    public RD testTime(){

      return   RD.success(dormServiceImpl.insertBatch());

    }
}
