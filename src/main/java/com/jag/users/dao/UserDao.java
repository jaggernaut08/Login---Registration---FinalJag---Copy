package com.jag.users.dao;

import com.jag.users.model.User;

public interface UserDao {

	void save(User user);
	
	User findByUserName(String username);

}