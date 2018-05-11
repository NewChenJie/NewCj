package com.cj.service;

import com.cj.domain.oamysql.AliNewCustomer;

import java.util.List;

public interface AliCustomerService {
    List<AliNewCustomer> findById(int id, int index, int size);
}
