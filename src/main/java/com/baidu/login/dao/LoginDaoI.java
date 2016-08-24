package com.baidu.login.dao;

import com.baidu.login.entity.User;

public interface LoginDaoI {

	User getUserByName(User user);

	void updateUser(User u);

}
