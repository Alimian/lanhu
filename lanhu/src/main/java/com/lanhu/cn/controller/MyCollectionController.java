package com.lanhu.cn.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lanhu.cn.model.Collection;
import com.lanhu.cn.service.MyCollectionService;
import com.lanhu.cn.utils.ReturnInfo;
import com.lanhu.cn.utils.StatusCode;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags="用户用于收藏产品")
@Controller
@RequestMapping("/myCollectionController")
public class MyCollectionController {

	@Autowired
	MyCollectionService collectionService;
	
	@ApiOperation(value="添加我的收藏",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId",value="用户id",required=true,paramType="query"),
		@ApiImplicitParam(name="productId",value="产品id",required=true,paramType="query"),
	})
	@RequestMapping(value="insert",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String insert(@RequestParam(value="userId",required=true)Integer userId,
			@RequestParam(value="productId",required=true)Integer productId
			){
		ReturnInfo rf;
		Collection collection = new Collection();
		collection.setUserId(userId);
		collection.setProductId(productId);
		
		int i = collectionService.insert(collection);
		if(i>0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.COLLECTION_INSERT_SUCCESS_CODE);
			rf.setInfo(StatusCode.COLLECTION_INSERT_SUCCESS_VALUE);
			return JSON.toJSONString(rf);
		}
		else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.COLLECTION_INSERT_FAIL_CODE);
			rf.setInfo(StatusCode.COLLECTION_INSERT_FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
	}
	@ApiOperation( value = "删除收藏(参数传id或者传用户id和产品id)",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="收藏id",required=false,paramType="query"),
		@ApiImplicitParam(name="userId",value="用户id",required=false,paramType="query"),
		@ApiImplicitParam(name="productId",value="产品id",required=false,paramType="query"),
	})
	@RequestMapping(value="delete" ,method = RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String delete(@RequestParam(name="id",required=false) Integer id,
			@RequestParam(name = "userId",required=false) Integer userId,
			@RequestParam(name = "productId",required=false) Integer productId
			){
			ReturnInfo rf;
			//参数传id 或者 用户id和产品id两者之一
			System.out.println(StringUtils.isEmpty(id));
			System.out.println(StringUtils.isEmpty(userId));
			System.out.println(StringUtils.isEmpty(productId));
			if(StringUtils.isEmpty(id) && (StringUtils.isEmpty(userId) || StringUtils.isEmpty(productId))){
				rf = new ReturnInfo();
				rf.setCode(StatusCode.INCOMPLETE_INFO_CODE);
				rf.setInfo(StatusCode.INCOMPLETE_INFO_VALUE);
				return JSON.toJSONString(rf);
			}
			HashMap params = new HashMap();
			params.put("id", id);
			params.put("userId", userId);
			params.put("productId", productId);
			int i = collectionService.delete(params);
			
			if(i>0){
				rf = new ReturnInfo();
				rf.setCode(StatusCode.COLLECTION_DELETE_SUCCESS_CODE);
				rf.setInfo(StatusCode.COLLECTION_DELETE_SUCCESS_VALUE);
				return JSON.toJSONString(rf);
			}else{
				rf = new ReturnInfo();
				rf.setCode(StatusCode.COLLECTION_DELETE_FAIL_CODE);
				rf.setInfo(StatusCode.COLLECTION_DELETE_FAIL_VALUE);
				return JSON.toJSONString(rf);
			}
			
	}
	@ApiOperation(value="查看用户收藏列表",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="userId",value="用户id",required=true,paramType="query"),
	})
	@RequestMapping(value="select",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public String select(@RequestParam(name = "userId",required=true) Integer userId){
		ReturnInfo rf;
		
		List<Collection> result = collectionService.select(userId);
		if(result.size()>0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.SUCCESS_VALUE);
			rf.setData(result);
			return JSON.toJSONString(rf);
		}
		else if(result.size() == 0){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.NO_COLLECTION_CODE);
			rf.setInfo(StatusCode.NO_COLLECTION_VALUE);
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
