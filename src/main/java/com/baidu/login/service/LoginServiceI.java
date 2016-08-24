package com.baidu.login.service;

import com.baidu.login.entity.User;

public interface LoginServiceI {

	User getUserByName(User user);

	void updateUser(User u);

}
