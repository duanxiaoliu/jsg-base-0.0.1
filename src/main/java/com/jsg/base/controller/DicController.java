package com.jsg.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.service.IDicService;
import com.jsg.base.util.PageUtil;

/**
 * 
* @ClassName: DicController 
* @Description: TODO(数据字典管理) 
* @author duanws
* @date 2016-5-11 下午2:47:32 
*
 */
@Controller
public class DicController extends BaseController {
	
	@Autowired
	private IDicService dicSerivce;
	
	/**
	 * 
	* @Title: queryDicCategoryPage 
	* @Description: TODO(查询数据字典信息) 
	* @param @param request
	* @param @param response
	* @param @param model
	* @param @param baseDic
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-11 下午2:49:43
	 */
	@RequestMapping({"dicManage/dicManage/queryDicCategory"})
	public String queryDicCategoryPage(HttpServletRequest request,HttpServletResponse response,ModelMap model,DicCategory dicCategory){
		String pageNo = (request.getParameter("pageNo")!=null)?request.getParameter("pageNo"):"1";
		
		BasePage page = this.dicSerivce.queryDicCategory(dicCategory, Integer.parseInt(pageNo), BasePage.DEFAULT_PAGE_SIZE);
		String pageTag = PageUtil.getPageInfo((int)page.getTotalPageCount(),(int)page.getTotalCount());
		
		model.addAttribute("pageTag", pageTag);
		model.addAttribute("page", page);
		model.addAttribute("dicCategory", dicCategory);
		
		return "dicManage/dicManage/queryDicInfo";
	}
}
