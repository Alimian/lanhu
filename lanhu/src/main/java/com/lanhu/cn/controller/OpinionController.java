package com.lanhu.cn.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lanhu.cn.model.Opinion;
import com.lanhu.cn.service.OpinionService;
import com.lanhu.cn.utils.CheckUtils;
import com.lanhu.cn.utils.ReturnInfo;
import com.lanhu.cn.utils.StatusCode;
@Api(tags="用于意见反馈模块")
@Controller
@RequestMapping("/opinionController")
public class OpinionController {

	@Autowired
	private OpinionService opinionService;
	@ApiOperation(value = "用户意见反馈",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId",value="用户id",required=true,paramType="query"),
		@ApiImplicitParam(name="opinion",value="用户反馈的意见",required=true,paramType="query"),
		@ApiImplicitParam(name="telOrEmail",value="用户联系方式",required=true,paramType="query"),
		@ApiImplicitParam(name="client",value="客户端类型",required=true,paramType="query"),
		@ApiImplicitParam(name="version",value="用户使用的版本",required=true,paramType="query")
	})
	@RequestMapping(value="insertOpinion",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String insertOpinion(@RequestParam(name="userId",required=true) Integer userId,
			@RequestParam(name="opinion",required=true) String opinion,
			@RequestParam(name="telOrEmail",required=true) String telOrEmail,
			@RequestParam(name="client",required=true) Integer client,
			@RequestParam(name="version",required=true) String version
			){
		ReturnInfo rf;
		if(!CheckUtils.checkTel(telOrEmail) && !CheckUtils.checkEmail(telOrEmail)){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.OPINION_TELOREMAIL_NOTSUPPORT_CODE);
			rf.setInfo(StatusCode.OPINION_TELOREMAIL_NOTSUPPORT_VALUE);
			return JSON.toJSONString(rf);
		}
		if(opinion.length() < 5){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.OPINION_LENGTH_TOLOW_CODE);
			rf.setInfo(StatusCode.OPINION_LENGTH_TOLOW_VALUE);
			return JSON.toJSONString(rf);
		}
		Opinion params = new Opinion();
		params.setUserId(userId);
		params.setOpinion(opinion);
		params.setTelOrEmail(telOrEmail);
		params.setClient(client);
		//默认状态为0 未读  1 已读
		params.setStatus(0);
		params.setVersion(version);
		int i = opinionService.insert(params);
		if(i > 0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.OPINION_INSERT_SUCCESS_CODE);
			rf.setInfo(StatusCode.OPINION_INSERT_SUCCESS_VALUE);
			return JSON.toJSONString(rf);
		}
		else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.OPINION_INSERT_FAIL_CODE);
			rf.setInfo(StatusCode.OPINION_INSERT_FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
	}
	@ApiOperation(value = "查询反馈列表",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="opinion",value="用户反馈的意见",required=false,paramType="query"),
		@ApiImplicitParam(name="telOrEmail",value="联系方式",required=false,paramType="query"),
		@ApiImplicitParam(name="status",value="查看状态",required=false,paramType="query"),
		@ApiImplicitParam(name="startTime",value="日期开始时间",required=false,paramType="query"),
		@ApiImplicitParam(name="endTime",value="日期结束时间",required=false,paramType="query"),
		
	})
	@RequestMapping(value="selectOpition",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String selectOpinion(@RequestParam(name = "opinion",required= false) String opinion,
				@RequestParam(name = "telOrEmail",required= false) String telOrEmail,
				@RequestParam(name = "status",required= false) Integer status,
				@RequestParam(name = "startTime",required= false) String startTime,
				@RequestParam(name = "endTime",required= false) String endTime
			){
		ReturnInfo rf;
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("opinion", opinion);
		params.put("telOrEmail", telOrEmail);
		params.put("status", status);
		params.put("startTime", startTime);
		params.put("endTime", endTime);
		List<Opinion> result = opinionService.select(params);
		for(Opinion o : result){
			System.out.println(o.toString());
		}
		if(result.size() > 0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.SUCCESS_VALUE);
			rf.setData(result);
			System.out.println(JSON.toJSONString(rf));
			return JSON.toJSONString(rf);
		}
		else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.OPINION_NOTFOUND_CODE);
			rf.setInfo(StatusCode.OPINION_NOTFOUND_VALUE);
			return JSON.toJSONString(rf);
		}
	}
	@ApiOperation(value = "updateStatus",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="阅读了的id",required=true,paramType="query"),
		
	})
	@RequestMapping(value="updateStatus",method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String updateStatus(@RequestParam(name = "id",required=true) Integer id){
		ReturnInfo rf;
		int i = opinionService.updateStatus(id);
		if(i > 0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.SUCCESS_VALUE);
			return JSON.toJSONString(rf);
		}
		else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.FAIL_CODE);
			rf.setInfo(StatusCode.FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
	}
}
