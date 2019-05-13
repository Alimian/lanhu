package com.lanhu.cn.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lanhu.cn.dao.OpinionDao;
import com.lanhu.cn.model.Opinion;
import com.lanhu.cn.service.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService{

	@Autowired
	private OpinionDao opinionDao;
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Integer insert(Opinion opinion) {
		int i = opinionDao.insert(opinion);
		return i;
	}

	@Override
	public List<Opinion> select(Map<String,Object> map) {
		List result = opinionDao.select(map);
		return result;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Integer updateStatus(Integer id) {
		int i = opinionDao.updateStatus(id);
		return i;
	}

	
}
