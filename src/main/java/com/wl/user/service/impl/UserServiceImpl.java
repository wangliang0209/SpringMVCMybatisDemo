package com.wl.user.service.impl;

import com.wl.user.dao.UserMapper;
import com.wl.user.entity.User;
import com.wl.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
