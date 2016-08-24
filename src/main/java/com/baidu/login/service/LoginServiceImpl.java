package com.baidu.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baidu.login.dao.LoginDaoI;
import com.baidu.login.entity.User;

@Service
public class LoginServiceImpl implements LoginServiceI {

	@Autowired
	private LoginDaoI dao;

	public User getUserByName(User user) {
		return dao.getUserByName(user);
	}

	public void updateUser(User u) {
		dao.updateUser(u);
	}
}
