package com.lanhu.cn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lanhu.cn.dao.ProductDao;
import com.lanhu.cn.model.Product;
import com.lanhu.cn.service.ProductService;
/**
 * 
 * @ClassName: ProductServiceImpl  
 * @Description: TODO描述: 贷款产品相关的service
 * @author wangn  
 * @date 2019-4-18  
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer insertProduct(Product product) {
		int i = productDao.insertProduct(product);
		return i;
	}

	@Override
	public Integer updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteProduct(Integer id) {
		int i = productDao.deleteProduct(id);
		return i;
	}

	@Override
	public List<Product> selectProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product loadProduct(Integer id) {
	Product result = productDao.loadProduct(id);
		return result;
	}

}
