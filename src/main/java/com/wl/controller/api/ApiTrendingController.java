package com.wl.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wl.model.Trending;
import com.wl.service.GithubTrendingService;
import com.wl.web.util.ResponseUtils;

@Controller
@RequestMapping("/api/github/trending")
public class ApiTrendingController {
	@Autowired
	private GithubTrendingService githubTrendingService;
	
	@RequestMapping("/list")
	@ResponseBody String getList() {
		List<Trending> list = githubTrendingService.getList();
		for (Trending trending : list) {
			trending.setHref("https://github.com"+ trending.getHref());
		}
		JSONObject data = new JSONObject();
		data.put("list", JSONArray.parse(JSON.toJSONString(list)));
		
		return ResponseUtils.generSuccJsonStr(data);
	}
}
