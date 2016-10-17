package com.wl.service;

import java.util.List;

import com.wl.model.User;

public interface UserService {
	User getUserById(int id);

	int insert(User user);

	List<User> getUsers();
}
