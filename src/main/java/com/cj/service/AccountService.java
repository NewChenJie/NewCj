package com.cj.service;

import com.cj.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findById(int id);
}
