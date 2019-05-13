package com.lanhu.cn.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lanhu.cn.model.Product;
import com.lanhu.cn.service.ProductService;
import com.lanhu.cn.utils.ReturnInfo;
import com.lanhu.cn.utils.StatusCode;
@Api(tags="新增贷款产品")
@Controller
@RequestMapping(value="/productController")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="用于新增产品",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="productName",value="产品名称", required=true, paramType="query"),
		@ApiImplicitParam(name="productImg",value="产品图标", required=true, paramType="query"),
		@ApiImplicitParam(name="productUrl",value="跳转地址", required=true, paramType="query"),
		@ApiImplicitParam(name="moneyRate",value="利率", required=true, paramType="query"),
		@ApiImplicitParam(name="quotaMin",value="最小额度", required=true, paramType="query"),
		@ApiImplicitParam(name="quotaMax",value="最大额度", required=true, paramType="query"),
		@ApiImplicitParam(name="loanPeriodStar",value="贷款期限开始", required=true, paramType="query"),
		@ApiImplicitParam(name="loanPeriodEnd",value="贷款期限结束", required=true, paramType="query"),
		@ApiImplicitParam(name="loanDate",value="放款时间", required=true, paramType="query"),
		@ApiImplicitParam(name="weight",value="权重", required=true,dataType="Integer", paramType="query"),
		@ApiImplicitParam(name="applyFlow",value="申请流程", required=true, paramType="query"),
		@ApiImplicitParam(name="applyCndition",value="申请条件", required=true, paramType="query"),
		@ApiImplicitParam(name="applyMaterial",value="申请材料", required=true, paramType="query"),
		@ApiImplicitParam(name="remarks",value="备注", required=true, paramType="query"),
		
	})
	@RequestMapping(value="insertProduct",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String insertProduct(@RequestParam(name="productName",required=true)String productName,
			@RequestParam(name="productImg",required=true)String productImg,
			@RequestParam(name="productUrl",required=true)String productUrl,
			@RequestParam(name="moneyRate",required=true)Integer moneyRate,
			@RequestParam(name="quotaMin",required=true)Integer quotaMin,
			@RequestParam(name="quotaMax",required=true)Integer quotaMax,
			@RequestParam(name="loanPeriodStar",required=true)String loanPeriodStar,
			@RequestParam(name="loanPeriodEnd",required=true)String loanPeriodEnd,
			@RequestParam(name="loanDate",required=true)String loanDate,
			@RequestParam(name="weight",required=true)String weight,
			@RequestParam(name="applyFlow",required=true)String applyFlow,
			@RequestParam(name="applyCndition",required=true)String applyCndition,
			@RequestParam(name="applyMaterial",required=true)String applyMaterial,
			@RequestParam(name="remarks",required=true)String remarks
			){
		
			Product product = new Product();
			product.setProductName(productName);
			product.setProductImg(productImg);
			product.setProductUrl(productUrl);
			product.setMoneyRate(moneyRate);
			product.setQuotaMin(quotaMin);
			product.setQuotaMax(quotaMax);
			product.setLoanPeriodStar(loanPeriodStar);
			product.setLoanPeriodEnd(loanPeriodEnd);
			product.setLoanDate(loanDate);
			product.setWeight(weight);
			product.setApplyFlow(applyFlow);
			product.setApplyCndition(applyCndition);
			product.setApplyMaterial(applyMaterial);
			product.setRemarks(remarks);
			System.err.println(product.toString());
			int i = productService.insertProduct(product);
			ReturnInfo rf = new ReturnInfo();
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.SUCCESS_VALUE);
			System.out.println(JSON.toJSONString(rf));
			return JSON.toJSONString(rf);
	}
	@ApiOperation(value="根据id删除产品",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name="id",value="产品的id",required=true,paramType="query")
	})
	@RequestMapping(value="deleteProduct",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String deleteProduct(@RequestParam Integer id){
		int i = productService.deleteProduct(id);
		ReturnInfo rf;
		System.out.println(i);
		if(i>0){
			rf=new ReturnInfo();
			rf.setCode(StatusCode.PRODUCT_DELETE_SUCCESS_CODE);
			rf.setInfo(StatusCode.PRODUCT_DELETE_SUCCESS_VALUE);
			return JSON.toJSONString(rf);
		}else{
		rf=new ReturnInfo();
		rf.setCode(StatusCode.PRODUCT_DELETE_FAIL_CODE);
		rf.setInfo(StatusCode.PRODUCT_DELETE_FAIL_VALUE);
		return JSON.toJSONString(rf);
		}
	}
	@ApiOperation( value = "根据id加载产品信息",httpMethod="POST")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "id",value="产品的id",required=true,paramType="query")
	})
	@RequestMapping(value="loadProduct",method=RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public String loadProduct(@RequestParam(value="id",required=true) Integer id){
		ReturnInfo rf;
		Product product = productService.loadProduct(id);
		if(StringUtils.isEmpty(product)){
			rf = new ReturnInfo();
			rf.setCode(StatusCode.PRODUCT_LOAD_FAIL_CODE);
			rf.setInfo(StatusCode.PRODUCT_LOAD_FAIL_VALUE);
			return JSON.toJSONString(rf);
		}
		else{
			rf = new ReturnInfo();
			rf.setCode(StatusCode.SUCCESS_CODE);
			rf.setInfo(StatusCode.SUCCESS_VALUE);
			rf.setData(product);
			return JSON.toJSONString(rf);	
			
		}
		
	}
}
