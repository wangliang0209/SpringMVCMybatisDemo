package com.wl.controller;

import com.wl.base.utils.SessionUtils;
import com.wl.trending.entity.Trending;
import com.wl.trending.service.GithubTrendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/github/trending")
public class TrendingController {

    @Autowired
    private GithubTrendingService githubTrendingService;

    @RequestMapping("/list")
    public ModelAndView getList(HttpServletRequest request) {
        if (!SessionUtils.isLogined(request)) {
            return new ModelAndView("redirect:/");
        } else {
            List<Trending> list = githubTrendingService.getList();

            HashMap<String, Object> map = new HashMap<>();
            map.put("list", list);

            return new ModelAndView("github/trending", map);
        }
    }
}
