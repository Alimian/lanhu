package com.lanhu.cn.controller;

import java.util.Date;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lanhu.cn.model.User;
import com.lanhu.cn.service.RegisterService;
import com.lanhu.cn.utils.CheckUtils;
import com.lanhu.cn.utils.DateFormat;
import com.lanhu.cn.utils.ReturnInfo;
import com.lanhu.cn.utils.StatusCode;

/**
 * 
 * @ClassName: RegisterController  
 * @Description: TODO描述: 注册相关的controller
 * @author wangn  
 * @date 2019-4-10  
 *
 */
@Controller
@RequestMapping("/registerController")
@Api(tags="用户注册")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	/**
	 * 
	 * @Title: register 
	 * @author wangn 
	 * @Description: TODO 描述:注册
	 * @param @param telPhone
	 * @param @param password
	 * @param @param request
	 * @param @return 
	 * @return String
	 * @throws
	 */
	@ApiOperation(value="用于用户注册",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="telPhone", value="手机号码", required=true, paramType="query" ),
		@ApiImplicitParam(name="password", value="密码", required=true, paramType="query")
	})
	@RequestMapping(value="/register",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String register(@RequestParam(name="telPhone",required=true)String telPhone,
			@RequestParam(name="password",required=true)String password){
		//校验手机号和密码
		ReturnInfo rf = new ReturnInfo();
		String checkInfo = commonCheck(rf, telPhone, password);
		
		if(!"SUCCESS".equals(checkInfo)){
			return checkInfo;
		}
		//用户已存在
		User user1 = new User();
		user1.setTelPhone(telPhone);
		List<User> list = registerService.selectUser(user1);
		if(list.size()>0){
			rf.setCode(StatusCode.TELPHONE_REGISTERNOW_CODE);
			rf.setInfo(StatusCode.TELPHONE_REGISTERNOW_VALUE);
			rf.setData(list.get(0));
			return JSON.toJSONString(rf);
		}
		User user = new User();
		user.setTelPhone(telPhone);
		user.setCreateDate(DateFormat.format(new Date()));
		user.setPassword(password);
		user= registerService.register(user);
		if(!StringUtils.isEmpty(user)){
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.REGISTER_SUCCESS_VALUE);
			rf.setData(user);
			return JSON.toJSONString(rf);
		}else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.REGISTER_FAIL_CODE);
			rf.setInfo(StatusCode.REGISTER_FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
	}
	/**
	 * 
	 * @Title: updatepwd 
	 * @author wangn 
	 * @Description: TODO 描述:修改密码
	 * @param @param telPhone
	 * @param @param password
	 * @param @return 
	 * @return String
	 * @throws
	 */
	@ApiOperation(value="用于用户修改密码",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="telPhone", value="手机号码", required=true, paramType="query" ),
		@ApiImplicitParam(name="password", value="密码", required=true, paramType="query")
	})
	@RequestMapping(value="/updatepwd",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String updatepwd(@RequestParam(name="telPhone",required=true) String telPhone,
			@RequestParam(name="password",required=true) String password){
		
		//校验手机号和密码
		ReturnInfo rf = new ReturnInfo();
		String checkInfo = commonCheck(rf, telPhone, password);
		if(!"SUCCESS".equals(checkInfo)){
			return checkInfo;
		}
		//用户不存在
		User user1 = new User();
		user1.setTelPhone(telPhone);
		List<User> list = registerService.selectUser(user1);
		if(list.size() == 0){
			rf.setCode(StatusCode.TELPHONE_NOTREGISTER_CODE);
			rf.setInfo(StatusCode.TELPHONE_NOTREGISTER_VALUE);
			return JSON.toJSONString(rf);
		}
		int i = registerService.updatepwd(telPhone, password);
		if(i > 0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.UPDATE_SUCCESS_CODE);
			rf.setInfo(StatusCode.UPDATE_SUCCESS_VALUE);
			return JSON.toJSONString(rf);
		}else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.UPDATE_FAIL_CODE);
			rf.setInfo(StatusCode.UPDATE_FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
	}
	@ApiOperation(value="用于用户登录",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="telPhone", value="手机号码", required=true, paramType="query" ),
		@ApiImplicitParam(name="password", value="密码", required=true, paramType="query")
	})
	@RequestMapping(value="/login",method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String login(@RequestParam(name="telPhone",required=true) String telPhone,
			@RequestParam(name="password",required=true) String password){
		//校验手机号和密码是否合法
		ReturnInfo rf = new ReturnInfo();
		String checkInfo = commonCheck(rf, telPhone, password);
		if(!"SUCCESS".equals(checkInfo)){
			return checkInfo;
		}
		User user  = registerService.login(telPhone);
		//手机号未注册
		if(StringUtils.isEmpty(user)){
			rf.setCode(StatusCode.TELPHONE_NOTREGISTER_CODE);
			rf.setInfo(StatusCode.TELPHONE_NOTREGISTER_VALUE);
			return JSON.toJSONString(rf);
		}
		//密码不正确
		if(!password.equals(user.getPassword())){
			rf.setCode(StatusCode.PASSWORD_ERR_CODE);
			rf.setInfo(StatusCode.PASSWORD_ERR_VALUE);
			return JSON.toJSONString(rf);
		}
		if(user !=null){
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.SUCCESS_VALUE);
			rf.setData(user);
			return JSON.toJSONString(rf);
		}
		else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.FAIL_CODE);
			rf.setInfo(StatusCode.FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
	}
	public  String commonCheck(ReturnInfo rf,String telPhone ,String password ){
		//校验请求信息是否完整
		if(StringUtils.isEmpty(telPhone) || StringUtils.isEmpty(password)){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.INCOMPLETE_INFO_CODE);
			rf.setInfo(StatusCode.INCOMPLETE_INFO_VALUE);
			return JSON.toJSONString(rf);
		}
		if(!CheckUtils.checkTel(telPhone)){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.TELPHONE_NOTSUPPORT_CODE);
			rf.setInfo(StatusCode.TELPHONE_NOTSUPPORT_VALUE);
			return JSON.toJSONString(rf);
		}
		if(!CheckUtils.isPassword(password)){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.PASSWORD_NOTSUPPORT_CODE);
			rf.setInfo(StatusCode.PASSWORD_NOTSUPPORT_VALUE);
			return JSON.toJSONString(rf);
		}else{
			return "SUCCESS";
		}
		
		
	}
}
