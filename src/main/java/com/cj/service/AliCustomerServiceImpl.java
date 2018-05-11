package com.cj.service;

import com.cj.domain.oamysql.AliNewCustomer;
import com.cj.domain.oamysql.AliNewCustomerExample;
import com.cj.mapper.oamysql.AliNewCustomerMapper;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AliCustomerServiceImpl implements  AliCustomerService {
    @Autowired
    private AliNewCustomerMapper aliNewCustomerMapper;
    @Override
    public List<AliNewCustomer> findById(int id, int index, int size) {
        log.info("现在页："+index+"每页数："+size);
        PageHelper.startPage(index, size);
        AliNewCustomerExample example=new AliNewCustomerExample();
        example.or().andIdNotEqualTo(id);
        return  aliNewCustomerMapper.selectByExample(example);

    }
}
