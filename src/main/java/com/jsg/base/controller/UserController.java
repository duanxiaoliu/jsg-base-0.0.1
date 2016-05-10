package com.jsg.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsg.base.model.UserInfo;

@Controller
public class UserController extends BaseController {
	
	@RequestMapping({"userManage/userManage/queryUserInfo"})
	public String queryUserInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,UserInfo userInfo){
		
		return "userManage/userManage/queryUserInfo";
	}
	
}
