package com.wl.service;


import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wl.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestUserService {
	private static final Logger LOGGER = Logger.getLogger(TestUserService.class); 
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testInsert() {
		User user = new User();
		user.setName("wangliang");
		user.setAge(30);
		int ret = userService.insert(user);
		System.out.println("testInsert >> " + ret);
	}
	
	@Test
	public void testQueryByUid() {
	    User user = userService.getUserById(1);
	    System.out.println("testQueryByUid >> " + JSON.toJSON(user));
	}
	
	@Test
	public void testQueryAll() {
		//NOTE:这里查询的结果不包含本次操作插入的记录
		List<User> users = userService.getUsers();
		System.out.println("testQueryAll >> " + JSON.toJSONString(users));
	}
}
