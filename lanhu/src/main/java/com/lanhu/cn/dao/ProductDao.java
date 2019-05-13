package com.lanhu.cn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lanhu.cn.model.Product;

public interface ProductDao {

	/**
	 * 
	 * @Title: insertProduct 
	 * @author wangn 
	 * @Description: TODO 描述:新增产品
	 * @param @param product
	 * @param @return 
	 * @return Integer
	 * @throws
	 */
	public Integer insertProduct(Product product);
	/**
	 * 
	 * @Title: updateProduct 
	 * @author wangn 
	 * @Description: TODO 描述:修改产品信息
	 * @param @param product
	 * @param @return 
	 * @return Integer
	 * @throws
	 */
	public Integer updateProduct(Product product);
	/**
	 * @return 
	 * 
	 * @Title: deleteProduct 
	 * @author wangn 
	 * @Description: TODO 描述:删除产品信息
	 * @param @param product 
	 * @return void
	 * @throws
	 */
	public int deleteProduct(@Param(value="id") Integer id);
	/**
	 * 
	 * @Title: selectProduct 
	 * @author wangn 
	 * @Description: TODO 描述:根据条件查询产品信息
	 * @param @param product
	 * @param @return 
	 * @return List<Product>
	 * @throws
	 */
	public List<Product> selectProduct(Product product);
	/**
	 * 
	 * @Title: loadProduct 
	 * @author wangn 
	 * @Description: TODO 描述:根据id加载单个产品信息
	 * @param @param id
	 * @param @return 
	 * @return Product
	 * @throws
	 */
	public Product loadProduct(Integer id);
}
