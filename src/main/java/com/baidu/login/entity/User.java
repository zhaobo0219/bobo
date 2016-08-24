package com.baidu.login.entity;

public class User {

	private Integer id;
	private String username;
	private String password;
	private Integer errorcount;
	private Long errortime;
	
	
	public Long getErrortime() {
		return errortime;
	}
	public void setErrortime(Long errortime) {
		this.errortime = errortime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(Integer errorcount) {
		this.errorcount = errorcount;
	}
	
	
}
