package com.wl.account.service.impl;

import com.wl.account.dao.AccountMapper;
import com.wl.account.entity.Account;
import com.wl.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account getAccountByAccount(String account) {
        return accountMapper.selectByAccount(account);
    }

    public Account getAccountByAccPwd(String account, String pwd) {
        Account acc = new Account();
        acc.setAccount(account);
        acc.setPassword(pwd);
        return accountMapper.selectByAccPwd(acc);
    }

    /**
     * @return -2 account exist.  > 0 succ.
     */
    public int regAccount(Account account) {
        int ret = -1;
        Account acc = accountMapper.selectByAccount(account.getAccount());
        if (acc != null) {
            account.setId(acc.getId());
            ret = -2;
        } else {
            accountMapper.insert(account);
            return accountMapper.selectByAccount(account.getAccount()).getId();
        }
        return ret;
    }

}
