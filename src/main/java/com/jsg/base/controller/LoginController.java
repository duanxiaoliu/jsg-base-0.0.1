package com.jsg.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping({"login"})
	public String login(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		System.out.println("----");
		return "login/login";
	}
	
}
