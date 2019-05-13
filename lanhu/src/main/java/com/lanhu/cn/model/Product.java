package com.lanhu.cn.model;

import java.io.Serializable;

public class Product implements Serializable{

	/**
	 * id
	 */
	private Integer id;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 产品图标
	 */
	private String productImg;
	/**
	 * 跳转地址
	 */
	private String productUrl;
	/**
	 * 利率
	 */
	private double moneyRate;
	/**
	 * 最小额度
	 */
	private Integer quotaMin;
	/**
	 * 最大额度
	 */
	private Integer quotaMax;
	/**
	 * 贷款期限开始
	 */
	private String loanPeriodStar;
	/**
	 * 贷款期限结束
	 */
	private String loanPeriodEnd;
	/**
	 * 放款时间
	 */
	private String loanDate;
	/**
	 * 权重
	 */
	private String weight;
	/**
	 * 申请流程
	 */
	private String applyFlow;
	/**
	 * 申请条件
	 */
	private String applyCndition;
	/**
	 * 申请材料
	 */
	private String applyMaterial;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建日期
	 */
	private String createDate;
	/**
	 * 修改日期
	 */
	private String updateDate;
	/**
	 * 创建人
	 */
	private String createUser;
	/**
	 * 修改人
	 */
	private String updateUser;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductImg() {
		return productImg;
	}
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	public String getProductUrl() {
		return productUrl;
	}
	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}
	public double getMoneyRate() {
		return moneyRate;
	}
	public void setMoneyRate(double moneyRate) {
		this.moneyRate = moneyRate;
	}
	public Integer getQuotaMin() {
		return quotaMin;
	}
	public void setQuotaMin(Integer quotaMin) {
		this.quotaMin = quotaMin;
	}
	public Integer getQuotaMax() {
		return quotaMax;
	}
	public void setQuotaMax(Integer quotaMax) {
		this.quotaMax = quotaMax;
	}
	public String getLoanPeriodStar() {
		return loanPeriodStar;
	}
	public void setLoanPeriodStar(String loanPeriodStar) {
		this.loanPeriodStar = loanPeriodStar;
	}
	public String getLoanPeriodEnd() {
		return loanPeriodEnd;
	}
	public void setLoanPeriodEnd(String loanPeriodEnd) {
		this.loanPeriodEnd = loanPeriodEnd;
	}
	public String getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(String loanDate) {
		this.loanDate = loanDate;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getApplyFlow() {
		return applyFlow;
	}
	public void setApplyFlow(String applyFlow) {
		this.applyFlow = applyFlow;
	}
	public String getApplyCndition() {
		return applyCndition;
	}
	public void setApplyCndition(String applyCndition) {
		this.applyCndition = applyCndition;
	}
	public String getApplyMaterial() {
		return applyMaterial;
	}
	public void setApplyMaterial(String applyMaterial) {
		this.applyMaterial = applyMaterial;
	}

	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", productImg=" + productImg + ", productUrl=" + productUrl
				+ ", moneyRate=" + moneyRate + ", quotaMin=" + quotaMin
				+ ", quotaMax=" + quotaMax + ", loanPeriodStar="
				+ loanPeriodStar + ", loanPeriodEnd=" + loanPeriodEnd
				+ ", loanDate=" + loanDate + ", weight=" + weight
				+ ", applyFlow=" + applyFlow + ", applyCndition="
				+ applyCndition + ", applyMaterial=" + applyMaterial
				+ ", remarks=" + remarks + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", createUser=" + createUser
				+ ", updateUser=" + updateUser + "]";
	}
	
	
	
}
