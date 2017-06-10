package com.jag.users.dao;

import com.jag.users.model.*;

public interface MobileDao {
	
/*	void save(User user);*/
	
	User findByNumber(String number);

}