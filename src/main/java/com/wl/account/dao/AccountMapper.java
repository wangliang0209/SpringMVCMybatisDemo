package com.wl.account.dao;

import com.wl.account.entity.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    Account selectByAccount(String account);

    Account selectByAccPwd(Account account);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}