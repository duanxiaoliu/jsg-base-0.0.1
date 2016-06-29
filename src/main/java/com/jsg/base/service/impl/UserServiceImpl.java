package com.jsg.base.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IUserDao;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.model.UserInfo;
import com.jsg.base.model.UserLoginInfo;
import com.jsg.base.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public UserInfo getUserInfo(UserInfo userInfo) {
		return userDao.getUserInfo(userInfo);
	}

	@Override
	public void saveUserInfo(UserInfo userInfo) {
		this.userDao.save(userInfo);

	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		this.userDao.clear();
		this.userDao.update(userInfo);

	}

	@Override
	public void deleteUserInfo(UserInfo userInfo) {
		

	}

	@Override
	public void deleteUserInfoById(String id) {
		this.userDao.deleteUserInfoById(id);

	}

	@Override
	public UserInfo getUserInfoById(String id) {
		return (UserInfo) this.userDao.get(UserInfo.class, id);
	}
	
	@Override
	public void saveUserLoginInfo(UserLoginInfo loginInfo) {
		this.userDao.save(loginInfo);
		
	}

	@Override
	public BasePage queryUserInfo(int pageNo, int pageSize, UserInfo user) {
		return this.userDao.queryUserInfo(pageNo, pageSize, user);
	}

	@Override
	public boolean isExistUser(String id, String cerNum) {
		String hql = " from UserInfo ui where ui.cerNum='"+cerNum+"'";
		List<UserInfo> list = this.userDao.queryList(hql, new Object[0]);
		if((list != null) && (list.size()>0)){
			if(list.size()==1){
				if(!list.get(0).getId().equals(id)){
					return false;
				}
			}else if(list.size() > 1){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isLoginInfoExist(String id, String loginName) {
		String hql = " from UserInfo ui where ui.userLogin.loginName='"+loginName+"'";
		List<UserInfo> list = this.userDao.queryList(hql, new Object[0]);
		if((list != null) && (list.size()>0)){
			if(list.size()==1){
				if(!list.get(0).getId().equals(id)){
					return false;
				}
			}else if(list.size() > 1){
				return false;
			}
		}
		return true;
	}

	@Override
	public void updateUserLoginInfo(UserLoginInfo loginInfo) {
		this.userDao.update(loginInfo);
		
	}

}
