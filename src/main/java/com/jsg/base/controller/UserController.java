package com.jsg.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.model.UserInfo;
import com.jsg.base.model.UserLoginInfo;
import com.jsg.base.service.IDicInfoService;
import com.jsg.base.service.IUserService;
import com.jsg.base.util.DataUtil;
import com.jsg.base.util.MD5;
import com.jsg.base.util.PageUtil;

@Controller
public class UserController extends BaseController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IDicInfoService dicInfoService;
	@Autowired
	private MD5 md;
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
	@RequestMapping({"userManage/userManage/queryUserInfo","userManage/userManage/ope-query/queryUserInfo"})
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
		this.setData(user, model);
		return "userManage/userManage/queryUserInfo";
	}
	/**
	 * 
	* @Title: editUser 
	* @Description: TODO(新增、修改跳转页面) 
	* @param @param request
	* @param @param model
	* @param @param user
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-21 上午11:27:13
	 */
	@RequestMapping({"userManage/userManage/ope-add/addUserInfo","userManage/userManage/ope-update/updateUserInfo"})
	public String editUser(HttpServletRequest request,ModelMap model,UserInfo user){
		String id = request.getParameter("id");
		if(DataUtil.strIsNotNull(id)){
			user = this.userService.getUserInfoById(id);
		}else{
			user = new UserInfo();
		}
		this.setData(user, model);
		
		return "userManage/userManage/editUserInfo";
	}
	/**
	 * 
	* @Title: saveUser 
	* @Description: TODO(保存) 
	* @param @param request
	* @param @param mode
	* @param @param user
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-21 上午11:44:19
	 */
	@RequestMapping({"userManage/userManage/ope-add/saveUserInfo","userManage/userManage/ope-update/saveUserInfo"})
	public String saveUser(HttpServletRequest request,ModelMap mode,UserInfo user){
		String id = user.getId();
		String loginName = user.getUserLogin().getLoginName();
		String password = user.getUserLogin().getPassword();
		
		if(DataUtil.strIsNotNull(id)){
			UserLoginInfo loginInfo = new UserLoginInfo();
			//登录名 
			loginInfo.setLoginName(loginName);
			//密码
			loginInfo.setPassword(md.GetMD5Code(password));
			this.userService.saveUserLoginInfo(loginInfo);
			user.setUserLogin(loginInfo);
			this.userService.updateUserInfo(user);
		}else{
			UserLoginInfo loginInfo = new UserLoginInfo();
			//登录名 
			loginInfo.setLoginName(loginName);
			//密码
			loginInfo.setPassword(md.GetMD5Code(password));
			this.userService.saveUserLoginInfo(loginInfo);
			user.setUserLogin(loginInfo);
			this.userService.saveUserInfo(user);
		}
		return "redirect:/userManage/userManage/ope-query/queryUserInfo.do";
	}
	/**
	 * 
	* @Title: delUser 
	* @Description: TODO(删除用户) 
	* @param @param request
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-21 下午2:44:05
	 */
	@RequestMapping(value={"userManage/userManage/ope-del/delUserInfo/{id}"},produces={"text/plain;charset=UTF-8"},method=RequestMethod.DELETE)
	public @ResponseBody String delUser(@PathVariable("id") String id,HttpServletRequest request,ModelMap model){
		try{
			this.userService.deleteUserInfoById(id);
		}catch(Exception e){
			return "error";
		}
		
		return "success";
	}
	/**
	 * 
	* @Title: viewUser 
	* @Description: TODO(查看用户信息) 
	* @param @param request
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-21 下午2:50:09
	 */
	@RequestMapping({"userManage/userManage/ope-view/viewUserInfo"})
	public String viewUser(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id");
		UserInfo user = this.userService.getUserInfoById(id);
		this.setData(user, model);
		
		return "userManage/userManage/viewUserInfo";
	}
	/**
	 * 
	* @Title: checkUserExist 
	* @Description: TODO(通过证件号码进行用户唯一性验证) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-21 下午2:59:47
	 */
	@RequestMapping(value={"userManage/userManage/ope-check/checkUserExist"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String checkUserExist(HttpServletRequest request,HttpServletResponse response){
		String cerNum = request.getParameter("cerNum");
		String id = request.getParameter("id");
		boolean checkResult = this.userService.isExistUser(id, cerNum);
		if(checkResult){
			return "true";
		}
		return "false";
	}
	/**
	 * 
	* @Title: checkUserLoginNameExist 
	* @Description: TODO(验证登录名称是否唯一) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-22 下午3:10:34
	 */
	@RequestMapping(value={"userManage/userManage/ope-check/checkUserLoginNameExist"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String checkUserLoginNameExist(HttpServletRequest request,HttpServletResponse response){
		String loginName = request.getParameter("loginName");
		String id = request.getParameter("id");
		boolean checkResult = this.userService.isLoginInfoExist(id, loginName);
		if(checkResult){
			return "true";
		}
		return "false";
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
		//证件类型
		List<BaseDic> cardtypeDicList = this.dicInfoService.getDicListByCode("CARDTYPE");
		
		model.addAttribute("cardtypeDicList", cardtypeDicList);
		model.addAttribute("genderDicList", genderDicList);
		model.addAttribute("statusDicList", statusDicList);
		model.addAttribute("user", user);
		
	}
	
}
