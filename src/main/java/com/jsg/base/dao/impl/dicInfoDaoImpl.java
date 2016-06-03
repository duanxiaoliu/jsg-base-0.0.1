package com.jsg.base.dao.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsg.base.dao.IDicInfoDao;
import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.util.DataUtil;

@Repository("dicInfoDao")
public class dicInfoDaoImpl extends BaseDaoImpl implements IDicInfoDao {

	@Override
	public BasePage getDicInfoListById(int pageNo,int pageSize,BaseDic baseDic) {
		StringBuffer hql = new StringBuffer(" from BaseDic bd where 1=1");
		if(DataUtil.strIsNotNull(baseDic.getName())){
			hql.append(" and bd.name='"+baseDic.getName()+"'");
		}
		if(DataUtil.strIsNotNull(baseDic.getCode())){
			hql.append(" and bd.code='"+baseDic.getCode()+"'");
		}
		if(DataUtil.strIsNotNull(baseDic.getStatus())){
			hql.append(" and bd.status='"+baseDic.getStatus()+"'");
		}
		return this.queryPage(hql.toString(), pageNo, pageSize,  new Object[0]);
	}

	

}
