package com.jsg.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.model.UserInfo;
import com.jsg.base.service.IDicInfoService;
import com.jsg.base.service.IUserService;
import com.jsg.base.util.DataUtil;
import com.jsg.base.util.PageUtil;

@Controller
public class UserController extends BaseController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IDicInfoService dicInfoService;
	/**
	 * 
	* @Title: queryUserInfo 
	* @Description: TODO(分页查询用户信息) 
	* @param @param request
	* @param @param response
	* @param @param model
	* @param @param userInfo
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-20 下午4:29:44
	 */
	@RequestMapping({"userManage/userManage/queryUserInfo"})
	public String queryUserInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,UserInfo user){
		
		String flag = request.getParameter("flag");
		String pageNo = (request.getParameter("pageNo")!=null)?request.getParameter("pageNo"):"1";
		HttpSession session = request.getSession();
		BasePage page = this.userService.queryUserInfo(Integer.parseInt(pageNo), BasePage.DEFAULT_PAGE_SIZE, user);
		String pageTag = PageUtil.getPageInfo((int)page.getTotalPageCount(),(int)page.getTotalCount());
		if(DataUtil.strIsNotNull(flag) && flag.equals("1")){
			UserInfo userB = (UserInfo) session.getAttribute("userB");
			if(DataUtil.objIsNotNull(userB)){
				user = userB;
			}
		}
		session.setAttribute("userB", user);
		model.addAttribute("pageTag", pageTag);
		model.addAttribute("page", page);
		
		
		return "userManage/userManage/queryUserInfo";
	}
	/**
	 * 
	* @Title: setData 
	* @Description: TODO(封闭页面显示元素) 
	* @param @param user
	* @param @param model
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-20 下午3:19:56
	 */
	private void setData(UserInfo user,ModelMap model){
		
		//性别
		List<BaseDic> genderDicList = this.dicInfoService.getDicListByCode("GENDER");
		//状态
		List<BaseDic> statusDicList = this.dicInfoService.getDicListByCode("STATUS");
		
		model.addAttribute("genderDicList", genderDicList);
		model.addAttribute("statusDicList", statusDicList);
		model.addAttribute("user", user);
		
	}
	
}
