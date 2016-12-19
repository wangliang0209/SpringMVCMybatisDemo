package com.wl.account.service;

import com.wl.account.entity.Account;

public interface AccountService {

    Account getAccountByAccount(String account);

    Account getAccountByAccPwd(String account, String pwd);

    int regAccount(Account account);
}
