package com.wl.token.service.impl;

import com.wl.token.dao.TokenMapper;
import com.wl.token.entity.Token;
import com.wl.token.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("tokenService")
public class TokenServiceImpl implements TokenService {
    private static final int EXPIRE_TIME = 60 * 60 * 24; //24小时

    @Autowired
    private TokenMapper tokenMapper;

    public void createToken(String key, String token) {
        Token record = tokenMapper.selectByPrimaryKey(key);
        if (record != null) {
            record.setKey(key);
            record.setToken(token);
            Integer expireAt = (int) (System.currentTimeMillis() / 1000 + EXPIRE_TIME);
            record.setExpireAt(expireAt);
            tokenMapper.updateByPrimaryKey(record);
        } else {
            record = new Token();
            record.setKey(key);
            record.setToken(token);
            Integer expireAt = (int) (System.currentTimeMillis() / 1000 + EXPIRE_TIME);
            record.setExpireAt(expireAt);
            tokenMapper.insert(record);
        }
    }

    public boolean validateToken(String token) {
        Token t = tokenMapper.selectByToken(token);
        if (t != null) {
            if (t.getExpireAt() - System.currentTimeMillis() / 1000 <= EXPIRE_TIME) {
                if (t.getToken().equals(token)) {
                    flushExpireAfterOperation(t.getKey());
                    return true;
                }
            } else {
                tokenMapper.deleteByPrimaryKey(t.getKey());
            }
        }

        return false;
    }

    public String getKeyByToken(String token) {
        Token t = tokenMapper.selectByToken(token);
        if (t != null) {
            return t.getKey();
        }
        return null;
    }

    public void flushExpireAfterOperation(String key) {
        Token record = new Token();
        record.setKey(key);
        record.setExpireAt((int) (System.currentTimeMillis() / 1000 + EXPIRE_TIME));
        tokenMapper.updateExipreByPrimaryKey(record);
    }

    public void deleteToken(String key) {
        tokenMapper.deleteByPrimaryKey(key);
    }

}
