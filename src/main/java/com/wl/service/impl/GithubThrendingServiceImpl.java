package com.wl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wl.dao.TrendingMapper;
import com.wl.model.Trending;
import com.wl.service.GithubTrendingService;

@Service("githubTrendingService")
public class GithubThrendingServiceImpl implements GithubTrendingService {
	
	@Autowired
	private TrendingMapper trendingMapper;

	@Override
	public List<Trending> getList() {
		return trendingMapper.selectList();
	}

}
