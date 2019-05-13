package com.lanhu.cn.model;

import java.util.Date;

public class User {
	
	//id
	private int id;
	//手机号码
	private String telPhone;
	//注册日期
	private String createDate;
	//图片路径
	private String img;
	//邮箱
	private String email;
	//密码
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelPhone() {
		return telPhone;
	}
	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}

	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", telPhone=" + telPhone + ", createDate="
				+ createDate + ", img=" + img + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	
	

}
