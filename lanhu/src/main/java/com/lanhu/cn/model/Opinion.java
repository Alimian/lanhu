package com.lanhu.cn.model;

public class Opinion {
	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 用户id
	 */
	private Integer userId;
	/**
	 * 意见
	 */
	private String opinion;
	/**
	 * 联系方式  手机号或者邮箱
	 */
	private String telOrEmail;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 客户端
	 */
	private int client;
	/**
	 * 软件版本
	 */
	private String version;
	/**
	 * 创建时间
	 */
	private String createTime;
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	public String getTelOrEmail() {
		return telOrEmail;
	}
	public void setTelOrEmail(String telOrEmail) {
		this.telOrEmail = telOrEmail;
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Opinion [id=" + id + ", userId=" + userId + ", opinion="
				+ opinion + ", telOrEmail=" + telOrEmail + ", status=" + status
				+ ", client=" + client + ", version=" + version
				+ ", createTime=" + createTime + "]";
	}

	
	
	
}
