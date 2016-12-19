package com.wl.service;

import com.wl.token.service.TokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestTokenService {

    @Autowired
    private TokenService tokenService;

    @Test
    public void testCreateToken() {
//		tokenService.createToken("111111", "tkoen");
    }

    @Test
    public void testValidateToken() {
        boolean ret = tokenService.validateToken("tkoen");
        System.out.println("testValidateToken >> " + ret);
    }

//	@Test
//	public void testDeleteToken() {
//		tokenService.deleteToken("111111");
//	}

}
