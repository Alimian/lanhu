package com.lanhu.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lanhu.cn.dao.MyCollectionDao;
import com.lanhu.cn.model.Collection;
import com.lanhu.cn.service.MyCollectionService;

@Service
public class MyCollectionServiceImpl implements MyCollectionService{

	@Autowired
	private MyCollectionDao collectionDao;

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int insert(Collection collection) {
		// TODO Auto-generated method stub
		try{
		int i = collectionDao.insert(collection);
		return i;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int i =	collectionDao.delete(map);
		System.out.println(i);
		return i;
	}

	@Override
	public List<Collection> select(Integer id) {
		List result = collectionDao.select(id);
		return result;
	}

	
}
