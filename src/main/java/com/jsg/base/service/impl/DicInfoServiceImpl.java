package com.jsg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IDicDao;
import com.jsg.base.dao.IDicInfoDao;
import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.service.IDicInfoService;

@Service("dicInfoService")
public class DicInfoServiceImpl implements IDicInfoService {

	@Autowired
	private IDicInfoDao dicInfoDao;
	
	@Override
	public BasePage getDicInfoListById(int pageNo,int pageSize,BaseDic baseDic) {
		return this.dicInfoDao.getDicInfoListById(pageNo,pageSize,baseDic);
	}

	@Override
	public void delDicInfoById(String id) {
		this.dicInfoDao.deleteById(BaseDic.class, id);
		
	}

	@Override
	public BaseDic getDicInfoById(String id) {
		
		return (BaseDic) this.dicInfoDao.get(BaseDic.class, id);
	}

	@Override
	public void saveDicInfo(BaseDic baseDic) {
		this.dicInfoDao.save(baseDic);
		
	}

	@Override
	public void updateDicInfo(BaseDic baseDic) {
		this.dicInfoDao.update(baseDic);
		
	}

}
