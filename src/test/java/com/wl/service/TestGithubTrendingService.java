package com.wl.service;

import com.wl.trending.entity.Trending;
import com.wl.trending.service.GithubTrendingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestGithubTrendingService {

    @Autowired
    private GithubTrendingService githubTrendingService;

    @Test
    public void testGetList() {
        List<Trending> list = githubTrendingService.getList();
        System.out.println("aa");
        for (Trending t : list) {
            System.out.println("trending >> title:" + t.getTitle() + ", desc:" + t.getDesc());
        }

    }


}
