package com.wl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wl.dao.UserMapper;
import com.wl.model.User;
import com.wl.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int insert(User user) {
		int ret = userMapper.insert(user);
		System.out.println("reslt:" + ret);
		return ret;
	}

	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userMapper.selectAll();
	}

}
