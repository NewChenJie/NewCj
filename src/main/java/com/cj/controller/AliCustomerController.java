package com.cj.controller;


import com.cj.domain.oamysql.AliNewCustomer;
import com.cj.service.AliCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AliCustomerController {

    @Autowired
    private AliCustomerService aliCustomerServiceImpl;

    @RequestMapping("ali/{id}/{index}/{size}")
public List<AliNewCustomer> findCustomer(@PathVariable int id, @PathVariable int index, @PathVariable int size){
        return aliCustomerServiceImpl.findById(id,index,size);
    }
}
