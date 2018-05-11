package com.cj.controller;

import com.cj.annotation.PageAttr;
import com.cj.domain.Account;
import com.cj.service.AccountService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/ali")
public class AccountController {
    @Autowired
    private AccountService accountServiceImpl;
    
    @RequestMapping("/demo/{id}")
    public List<Account> demo(@PathVariable("id")int id ,@PageAttr(order = "id desc") Page page){
        return accountServiceImpl.findById(id);
    }
}
