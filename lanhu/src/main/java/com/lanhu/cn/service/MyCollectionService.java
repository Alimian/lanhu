package com.lanhu.cn.service;

import java.util.List;
import java.util.Map;

import com.lanhu.cn.model.Collection;

public interface MyCollectionService {

	/**
	 * 
	 * @Title: insert 
	 * @author wangn 
	 * @Description: TODO 描述:添加到我的收藏
	 * @param @param collection
	 * @param @return 
	 * @return int
	 * @throws
	 */
	public int insert(Collection collection);
	/**
	 * 
	 * @Title: delete 
	 * @author wangn 
	 * @Description: TODO 描述:从我的收藏列表删除
	 * @param @param id
	 * @param @return 
	 * @return int
	 * @throws
	 */
	public int delete(Map<String, Object> map);
	/**
	 * 
	 * @Title: select 
	 * @author wangn 
	 * @Description: TODO 描述:查询用户收藏的产品信息
	 * @param @param id
	 * @param @return 
	 * @return List<Collection>
	 * @throws
	 */
	public List<Collection> select(Integer id);
}
