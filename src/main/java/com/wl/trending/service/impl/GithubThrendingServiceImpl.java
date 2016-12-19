package com.wl.trending.service.impl;

import com.wl.trending.dao.TrendingMapper;
import com.wl.trending.entity.Trending;
import com.wl.trending.service.GithubTrendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("githubTrendingService")
public class GithubThrendingServiceImpl implements GithubTrendingService {

    @Autowired
    private TrendingMapper trendingMapper;

    @Override
    public List<Trending> getList() {
        return trendingMapper.selectList();
    }

}
