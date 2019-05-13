package com.lanhu.cn.service;

import java.util.List;

import com.lanhu.cn.model.User;

/**
 * 
 * @ClassName: RegisterService  
 * @Description: TODO描述: 
 * @author wangn  
 * @date 2019-4-10  
 *
 */
public interface RegisterService {

	/**
	 * 
	 * @Title: register 
	 * @author wangn 
	 * @Description: TODO 描述:注册
	 * @param @param user
	 * @param @return 
	 * @return int
	 * @throws
	 */
	public User register(User user);
	/**
	 * 
	 * @Title: updatepwd 
	 * @author wangn 
	 * @Description: TODO 描述:修改密码
	 * @param @param pwd
	 * @param @return 
	 * @return int
	 * @throws
	 */
	public int updatepwd(String telPhone,String pwd);
	/**
	 * 
	 * @Title: login 
	 * @author wangn 
	 * @Description: TODO 描述:
	 * @param @param telphone
	 * @param @param pwd
	 * @param @return 
	 * @return User
	 * @throws
	 */
	public User login(String telphone);
	
	/**
	 * 
	 * @Title: selectUser 
	 * @author wangn 
	 * @Description: TODO 描述:查询用户是否存在
	 * @param @param user
	 * @param @return 
	 * @return User
	 * @throws
	 */
	public List<User> selectUser(User user);
}
