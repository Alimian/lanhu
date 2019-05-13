package com.lanhu.cn.service.impl;

import java.util.List;

import javax.imageio.spi.RegisterableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanhu.cn.dao.RegisterDao;
import com.lanhu.cn.model.User;
import com.lanhu.cn.service.RegisterService;

/**
 * 
 * @ClassName: RegisterServiceImpl  
 * @Description: TODO描述: 注册service层
 * @author wangn  
 * @date 2019-4-10  
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private RegisterDao registerDao;
	
	@Override
	public User register(User user) {
		//新增返回主键
		registerDao.register(user);
		User result = registerDao.selectById(user.getId());
		return result;
	}
	@Override
	public int updatepwd(String telPhone, String pwd) {
		int i = registerDao.updatepwd(telPhone, pwd);
		return i;
	}
	@Override
	public User login(String telphone) {
		User user = new User();
		user.setTelPhone(telphone);
		List<User> list= registerDao.selectUser(user);
		if(list.size() == 0)
			return null;
		else
		return list.get(0);
	}
	@Override
	public List<User> selectUser(User user) {
		List<User> result = registerDao.selectUser(user);
		return result;
	}

}
