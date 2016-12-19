package com.wl.token.service;

public interface TokenService {
    void createToken(String key, String token);

    boolean validateToken(String token);

    void flushExpireAfterOperation(String key);

    String getKeyByToken(String token);

    void deleteToken(String key);
}
