package com.jsg.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsg.base.dao.IUserDao;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserInfo getUserInfoById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
