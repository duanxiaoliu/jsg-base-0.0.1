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
		if(DataUtil.objIsNotNull(baseDic.getDicCategory()) && DataUtil.strIsNotNull(baseDic.getDicCategory().getId())){
			hql.append(" and bd.dicCategory.id='"+baseDic.getDicCategory().getId()+"'");
		}
		hql.append(" order by bd.seqNum");
		return this.queryPage(hql.toString(), pageNo, pageSize,  new Object[0]);
	}

	@Override
	public List<BaseDic> getDicInfoListByCategoryId(String dicCategoryId) {
		String hql = " from BaseDic bd where bd.dicCategory.id='"+dicCategoryId+"' order by bd.seqNum ";
		return this.queryList(hql, new Object[0]);
	}

	@Override
	public List<BaseDic> getDicListByCode(String code) {
		String hql = " from BaseDic bd where bd.dicCategory.code='"+code+"' order by bd.seqNum";
		
		return this.queryList(hql, new Object[0]);
	}

	@Override
	public BaseDic getDicInfo(String code, String dicCode) {
		String hql = " from BaseDic bd where bd.dicCategory.code='"+code+"' and bd.code='"+dicCode+"'";
		return null;
	}

	@Override
	public void delDicInfo(String id) {
		String hql = " delete from BaseDic dc where dc.id='"+id+"'";
		this.executeHql(hql, new Object[0]);
		
	}

	

}
