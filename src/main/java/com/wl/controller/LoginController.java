package com.wl.controller;

import com.alibaba.fastjson.JSON;
import com.wl.account.entity.Account;
import com.wl.account.service.AccountService;
import com.wl.base.utils.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制器
 *
 * @author wangliang
 */
@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(@RequestParam(value = "username", required = true) String username,
                              @RequestParam(value = "password", required = true) String password,
                              HttpServletRequest request) {
        // 后端数据库校验
        Account acc = accountService.getAccountByAccPwd(username, password);
        System.out.println(JSON.toJSON(acc));

        if (acc != null) {
            SessionUtils.setUserId(request, acc.getAccount());
            return new ModelAndView("redirect:/github/trending/list");
        } else {
            return new ModelAndView("error");
        }
    }


}
