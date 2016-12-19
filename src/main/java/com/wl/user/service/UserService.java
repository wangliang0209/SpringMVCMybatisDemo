package com.wl.user.service;

import com.wl.user.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    int insert(User user);

    List<User> getUsers();
}
