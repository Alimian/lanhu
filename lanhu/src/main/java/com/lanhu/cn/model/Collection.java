package com.lanhu.cn.model;

public class Collection {

	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 产品id
	 */
	private Integer productId;
	/**
	 * 关联产品
	 */
	private Product product;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Collection [userId=" + userId + ", productId=" + productId
				+  ", product=" + product + "]";
	}
	
	
	
	
}
