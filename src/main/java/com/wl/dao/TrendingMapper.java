package com.wl.dao;

import java.util.List;

import com.wl.model.Trending;

public interface TrendingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Trending record);

    int insertSelective(Trending record);

    Trending selectByPrimaryKey(Integer id);
    
    List<Trending> selectList();

    int updateByPrimaryKeySelective(Trending record);

    int updateByPrimaryKeyWithBLOBs(Trending record);
}