package com.wl.trending.dao;

import com.wl.trending.entity.Trending;

import java.util.List;

public interface TrendingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trending record);

    int insertSelective(Trending record);

    Trending selectByPrimaryKey(Integer id);

    List<Trending> selectList();

    int updateByPrimaryKeySelective(Trending record);

    int updateByPrimaryKeyWithBLOBs(Trending record);
}