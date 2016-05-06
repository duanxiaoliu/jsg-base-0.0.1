package com.jsg.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IUserDao;
import com.jsg.base.model.UserInfo;
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
