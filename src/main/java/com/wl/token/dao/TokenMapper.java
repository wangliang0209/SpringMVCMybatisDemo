package com.wl.token.dao;

import com.wl.token.entity.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(String key);

    //新建一个token
    int insert(Token record);

    Token selectByPrimaryKey(String key);

    Token selectByToken(String token);

    int updateByPrimaryKey(Token record);

    int updateExipreByPrimaryKey(Token record);
}