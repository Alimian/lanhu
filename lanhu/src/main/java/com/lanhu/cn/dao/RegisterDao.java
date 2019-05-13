package com.lanhu.cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanhu.cn.model.User;

/**
 * 
 * @ClassName: RegisterDao  
 * @Description: TODO描述: 注册功能数据层
 * @author wangn  
 * @date 2019-4-10  
 *
 */
public interface RegisterDao {

	public Integer register(User user);
	
	public User selectById(Integer id);
	
	public int updatepwd(String telPhone,String pwd);
	
	public List<User> selectUser(User user);
	
}
