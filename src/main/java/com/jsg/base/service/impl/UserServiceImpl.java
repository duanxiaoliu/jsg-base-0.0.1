package com.jsg.base.service.impl;

import org.springframework.transaction.annotation.Transactional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IUserDao;
import com.jsg.base.model.BasePage;
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
	
	@Override
	public void saveUserLoginInfo(UserLoginInfo loginInfo) {
		this.userDao.save(loginInfo);
		
	}

	@Override
	public BasePage queryUserInfo(int pageNo, int pageSize, UserInfo user) {
		return this.queryUserInfo(pageNo, pageSize, user);
	}

}
