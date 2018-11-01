package com.cj.service;

import com.cj.domain.Account;
import com.cj.domain.AccountExample;
import com.cj.mapper.mysql.AccountMapper;
import com.cj.mapper.oasqlserver.AtestMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AtestMapper atestMapper;
    @Override
    public List<Account> findById(int id) {
        AccountExample example=new AccountExample();
        example.or().andIdLessThan(id);
        return  accountMapper.selectByExample(example);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,transactionManager = "oasqlServer")
    public int test() {
        List<String> list = Lists.newArrayList("1", "2", "3");
        for (String s : list) {
            atestMapper.insert(s);
            if ("2".equals(s)){
                throw new RuntimeException();
            }
        }
        return 0;
    }
}
