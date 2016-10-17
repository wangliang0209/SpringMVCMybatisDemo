package com.wl.service;

import com.wl.model.Account;

public interface RegService {
	
	Account getAccountByAccount(String account);
	
	Account getAccountByAccPwd(String account, String pwd);
	
	int regAccount(Account account);
}
