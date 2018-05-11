package com.cj.mapper.oamysql;


import com.cj.domain.oamysql.AliNewCustomer;
import com.cj.domain.oamysql.AliNewCustomerExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AliNewCustomerMapper {
    int countByExample(AliNewCustomerExample example);

    int deleteByExample(AliNewCustomerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AliNewCustomer record);

    int insertSelective(AliNewCustomer record);

    List<AliNewCustomer> selectByExample(AliNewCustomerExample example);

    AliNewCustomer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AliNewCustomer record, @Param("example") AliNewCustomerExample example);

    int updateByExample(@Param("record") AliNewCustomer record, @Param("example") AliNewCustomerExample example);

    int updateByPrimaryKeySelective(AliNewCustomer record);

    int updateByPrimaryKey(AliNewCustomer record);
}