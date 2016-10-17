package com.wl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wl.model.Account;
import com.wl.service.RegService;
import com.wl.web.util.ResponseUtils;

@Controller
@RequestMapping("/reg")
public class RegController {

	@Autowired
	private RegService regService;
	
	@RequestMapping(method=RequestMethod.POST)
	private @ResponseBody String reg(@RequestParam(value="account") String account,
						@RequestParam(value="password") String password) {
		if(account == null || "".equals(account)){
			return ResponseUtils.generFailedJsonStr(-1, "account is null");
		} else if(password == null || "".equals(password)) {
			return ResponseUtils.generFailedJsonStr(-1, "pwd is null");
		} else {
			Account acc = new Account();
			acc.setAccount(account);
			acc.setPassword(password);
			int ret = regService.regAccount(acc);
			if(ret > 0) {
				JSONObject data = new JSONObject();
				data.put("uid", ret);
				return ResponseUtils.generSuccJsonStr(data);
			} else {
				return ResponseUtils.generFailedJsonStr(ret, "reg failed.");
			}
		}
	}
}
