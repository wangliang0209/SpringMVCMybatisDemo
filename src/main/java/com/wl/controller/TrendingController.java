package com.wl.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wl.model.Trending;
import com.wl.service.GithubTrendingService;

@Controller
@RequestMapping("/github/trending")
public class TrendingController {

	@Autowired
	private GithubTrendingService githubTrendingService;
	
	@RequestMapping("/list")
	ModelAndView getList() {
		List<Trending> list = githubTrendingService.getList();
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("list", list);

		return new ModelAndView("github/trending", map);
	}
}
