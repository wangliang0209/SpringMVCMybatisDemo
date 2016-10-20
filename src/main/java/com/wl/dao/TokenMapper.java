package com.wl.dao;

import com.wl.model.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(String key);

    //新建一个token
    int insert(Token record);

    Token selectByPrimaryKey(String key);
    
    Token selectByToken(String token);

    int updateByPrimaryKey(Token record);
    
    int updateExipreByPrimaryKey(Token record);
}