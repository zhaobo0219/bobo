package com.baidu.login.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baidu.login.entity.User;
import com.baidu.login.service.LoginServiceI;

@Controller
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginServiceI service;
	
	@RequestMapping("checkLogin")
	public String checkLogin(HttpServletRequest request,User user){
		//定义返回字符串信息
		String meg="";
		//根据名称查询User对象
		User u = service.getUserByName(user);
		if(u==null){
			meg="用户名不存在";
		}else{
			if(u.getErrorcount()<3){
				if(u.getPassword().equals(user.getPassword())){
					u.setErrorcount(0);
					u.setErrortime(new Date().getTime());
					service.updateUser(u);
					return "success";
				}else{
					u.setErrorcount(u.getErrorcount()+1);
					u.setErrortime(new Date().getTime());
					service.updateUser(u);
					if(u.getErrorcount()==3){
						meg="您的账户已经被锁定,请您在20分钟后登录";
					}else{
						meg="密码错误，您还剩"+(3-u.getErrorcount())+"次机会";
					}
				}
			}else{
				//获取用户登录时间
				Long err = u.getErrortime();
				//获取系统当前时间
				long errnow = new Date().getTime();
				//获取俩者时间差
				int errt=(int) ((errnow-err)/1000/60);
				System.out.println(errt);
				if(errt>20){
					if(u.getPassword().equals(user.getPassword())){
						u.setErrorcount(0);
						service.updateUser(u);
						return "success";
					}else{
						u.setErrorcount(1);
						service.updateUser(u);
						meg="密码错误，你还有俩次机会，请慎重";
					}
				}else{
					meg="账户被锁定，请您在"+(20-errt)+"分钟后再试";
				}
			}
		}
		request.setAttribute("meg", meg);
		return "error";
	}
}
