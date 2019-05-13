package com.lanhu.cn.service;

import java.util.List;

import com.lanhu.cn.model.Product;

public interface ProductService {
	
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
	 * 
	 * @Title: deleteProduct 
	 * @author wangn 
	 * @Description: TODO 描述:删除产品信息
	 * @param @param product 
	 * @return void
	 * @throws
	 */
	public int deleteProduct(Integer id);
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
