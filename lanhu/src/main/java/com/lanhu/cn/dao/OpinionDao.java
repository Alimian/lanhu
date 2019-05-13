package com.lanhu.cn.dao;

import java.util.List;
import java.util.Map;

import com.lanhu.cn.model.Opinion;

public interface OpinionDao {

	/**
	 * 
	 * @Title: insert 
	 * @author wangn 
	 * @Description: TODO 描述:新增意见反馈
	 * @param @param opinion
	 * @param @return 
	 * @return Integer
	 * @throws
	 */
	public Integer insert(Opinion opinion);
	/**
	 * 
	 * @Title: select 
	 * @author wangn 
	 * @Description: TODO 描述:查询意见
	 * @param @param opinion
	 * @param @return 
	 * @return Opinion
	 * @throws
	 */
	public List<Opinion> select(Map<String, Object> map);
	/**
	 * 
	 * @Title: updateStatus 
	 * @author wangn 
	 * @Description: TODO 描述:修改阅读状态
	 * @param @param id
	 * @param @return 
	 * @return Integer
	 * @throws
	 */
	public Integer updateStatus(Integer id);
	
}
