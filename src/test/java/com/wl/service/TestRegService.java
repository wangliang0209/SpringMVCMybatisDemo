package com.wl.service;


import com.alibaba.fastjson.JSON;
import com.wl.account.entity.Account;
import com.wl.account.service.AccountService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestRegService {
    private static final Logger LOGGER = Logger.getLogger(TestRegService.class);

    @Autowired
    private AccountService regService;

    @Test
    public void testGetAccountByAccount() {
        Account account = regService.getAccountByAccount("test");
        if (account == null) {
            System.out.println("testGetAccountByAccount >> test not exist.");
        } else {
            System.out.println("testGetAccountByAccount >> " + JSON.toJSONString(account));
        }
    }

    @Test
    public void testGetAccountByAccPwd() {
        Account account = regService.getAccountByAccPwd("test", "123456");
        if (account == null) {
            System.out.println("testGetAccountByAccPwd >> test not exist.");
        } else {
            System.out.println("testGetAccountByAccPwd >> " + JSON.toJSONString(account));
        }
    }

    @Test
    public void testRegAccount() {
        Account account = new Account();
        account.setAccount("test");
        account.setPassword("123456");
        int ret = regService.regAccount(account);
        System.out.println("testRegAccount >> " + ret);
    }
}
