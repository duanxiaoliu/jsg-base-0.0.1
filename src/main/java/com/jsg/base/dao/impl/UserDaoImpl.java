package com.jsg.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsg.base.dao.IUserDao;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.UserInfo;
import com.jsg.base.util.DataUtil;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		StringBuffer hql = new StringBuffer(" from UserInfo ui where 1=1");
	
		if(DataUtil.objIsNotNull(userInfo)){
			//登录名
			if(DataUtil.strIsNotNull(userInfo.getUserLogin().getLoginName())){
				hql.append(" and ui.userLogin.loginName='"+userInfo.getUserLogin().getLoginName()+"'");
			}
			//密码
			if(DataUtil.strIsNotNull(userInfo.getUserLogin().getPassword())){
				hql.append(" and ui.userLogin.password='"+userInfo.getUserLogin().getPassword()+"'");
			}
		}

		return (UserInfo) this.queryUnique(hql.toString(), new Object[0]);
	}

	@Override
	public void saveUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUserInfoById(String id) {
		String hql = " delete from UserInfo ui where ui.id='"+id+"'";
		this.executeHql(hql, new Object[0]);
		
	}

	@Override
	public UserInfo getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasePage queryUserInfo(int pageNo, int pageSize, UserInfo user) {
		StringBuffer hql = new StringBuffer(" from UserInfo ui where 1=1");
		//名称
		if(DataUtil.strIsNotNull(user.getName())){
			hql.append(" and ui.name like '%"+user.getName()+"%'");
		}
		//登录名
		if(DataUtil.objIsNotNull(user.getUserLogin()) && DataUtil.strIsNotNull(user.getUserLogin().getLoginName())){
			hql.append(" and ui.userLogin.loginName like '%"+user.getUserLogin().getLoginName()+"%'");
		}
		//性别
		if(DataUtil.objIsNotNull(user.getGenderDic()) && DataUtil.objIsNotNull(user.getGenderDic().getId())){
			hql.append(" and ui.genderDic.id='"+user.getGenderDic().getId()+"'");
		}
		return this.queryPage(hql.toString(), pageNo, pageSize, new Object[0]);
	}



}
