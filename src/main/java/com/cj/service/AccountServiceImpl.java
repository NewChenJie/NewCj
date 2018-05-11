package com.cj.service;

import com.cj.domain.Account;
import com.cj.domain.AccountExample;
import com.cj.mapper.mysql.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
@Autowired
private AccountMapper accountMapper;
    @Override
    public List<Account> findById(int id) {
        AccountExample example=new AccountExample();
        example.or().andIdLessThan(id);
        return  accountMapper.selectByExample(example);
    }
}
