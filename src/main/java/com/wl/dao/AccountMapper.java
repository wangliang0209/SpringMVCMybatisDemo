package com.wl.dao;

import com.wl.model.Account;

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