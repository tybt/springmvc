package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {

	List<User> getUserList(int offset, int limit);
	 
}
