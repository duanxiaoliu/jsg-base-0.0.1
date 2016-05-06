package com.jsg.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsg.base.model.UserInfo;
import com.jsg.base.model.UserLoginInfo;
import com.jsg.base.service.IUserService;
import com.jsg.base.util.DataUtil;

/**
 * 
* @ClassName: LoginController 
* @Description: TODO(用户登录) 
* @author duanws
* @date 2016-5-3 下午4:23:59 
*
 */
@Controller
public class LoginController extends BaseController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping({"login"})
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap model,UserInfo userInfo){
		return "login/login";
	}
	/**
	 * 
	* @Title: checkLoginInfo 
	* @Description: TODO(验证登录信息) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:51:37
	 */
	@RequestMapping({"toLogin"})	
	public @ResponseBody String checkLoginInfo(HttpServletRequest request,HttpServletResponse response){
		String msg = "error";
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("password");
		if(DataUtil.strIsNotNull(loginName) && DataUtil.strIsNotNull(password)){
			UserInfo userInfo = new UserInfo();
			UserLoginInfo userLoginInfo = new UserLoginInfo();
			userLoginInfo.setLoginName(loginName);
			userLoginInfo.setPassword(password);
			userInfo.setUserLogin(userLoginInfo);
			
			UserInfo loginUser = this.userService.getUserInfo(userInfo);
			if(DataUtil.objIsNotNull(loginUser)){
				msg = "success";
			}
		}
		return msg;
		
	}
	/**
	 * 
	* @Title: toMain 
	* @Description: TODO(登录成功，跳转主页面) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午3:01:32
	 */
	@RequestMapping({"toMain"})
	public String toMain(HttpServletRequest request,HttpServletResponse response){
		return "main/index";
	}
	
}
