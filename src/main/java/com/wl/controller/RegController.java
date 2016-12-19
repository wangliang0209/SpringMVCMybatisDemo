package com.wl.controller;

import com.alibaba.fastjson.JSONObject;
import com.wl.account.entity.Account;
import com.wl.account.service.AccountService;
import com.wl.entity.ModelBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reg")
public class RegController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST)

    @ResponseBody
    public ModelBean reg(@RequestParam(value = "username") String account,
                         @RequestParam(value = "password") String password) {
        if (account == null || "".equals(account)) {
            return new ModelBean(-1, "account is null");
        } else if (password == null || "".equals(password)) {
            return new ModelBean(-1, "pwd is null");
        } else {
            Account acc = new Account();
            acc.setAccount(account);
            acc.setPassword(password);
            int ret = accountService.regAccount(acc);
            if (ret > 0) {
                JSONObject data = new JSONObject();
                data.put("uid", ret);
                return new ModelBean(data);
            } else {
                return new ModelBean(ret, "account failed.");
            }
        }
    }
}
