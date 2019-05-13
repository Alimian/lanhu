package com.lanhu.cn.dao;

import java.util.List;
import java.util.Map;

import com.lanhu.cn.model.Collection;

public interface MyCollectionDao{


	/**
	 * 
	 * @Title: insert 
	 * @author wangn 
	 * @Description: TODO 描述:insert
	 * @param @param collection
	 * @param @return 
	 * @return Integer
	 * @throws
	 */
	Integer insert(Collection collection);
	/**
	 * 
	 * @Title: delete 
	 * @author wangn 
	 * @Description: TODO 描述:delete
	 * @param @param id
	 * @param @return 
	 * @return Integer
	 * @throws
	 */
	Integer delete(Map<String, Object> map);
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
	List<Collection> select(Integer id);
}
