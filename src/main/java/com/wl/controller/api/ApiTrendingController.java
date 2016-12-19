package com.wl.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wl.entity.ModelBean;
import com.wl.trending.entity.Trending;
import com.wl.trending.service.GithubTrendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/github/trending")
public class ApiTrendingController {
    @Autowired
    private GithubTrendingService githubTrendingService;

    @RequestMapping("/list")
    @ResponseBody
    public ModelBean getList() {
        List<Trending> list = githubTrendingService.getList();
        for (Trending trending : list) {
            trending.setHref("https://github.com" + trending.getHref());
        }
        JSONObject data = new JSONObject();
        data.put("list", JSONArray.parse(JSON.toJSONString(list)));

        return new ModelBean(data);
    }
}
