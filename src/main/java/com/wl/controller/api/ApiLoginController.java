package com.wl.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wl.account.entity.Account;
import com.wl.account.service.AccountService;
import com.wl.base.common.Constants;
import com.wl.base.utils.MD5;
import com.wl.entity.ModelBean;
import com.wl.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

/**
 * 登陆控制器
 *
 * @author wangliang
 */
@Controller
@RequestMapping("/api")
public class ApiLoginController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelBean login(@RequestParam(value = "username", required = true) String username,
                           @RequestParam(value = "password", required = true) String password) {
        // 后端数据库校验
        Account acc = accountService.getAccountByAccPwd(username, password);
        System.out.println(JSON.toJSON(acc));

        if (acc != null) {
            JSONObject data = new JSONObject();
            data.put("uid", String.valueOf(acc.getId()));

            String token = UUID.randomUUID().toString() + new Date().toString();
            token = MD5.GetMD5Code(token);

            System.out.println(token + "    len:" + token.length());
            token = token.toUpperCase();
            data.put("token", token);
            tokenService.createToken(String.valueOf(acc.getId()), token);
            return new ModelBean(data);
        } else {
            return new ModelBean(Constants.STATUS_ERROR, "用户名密码错误");
        }
    }
}
