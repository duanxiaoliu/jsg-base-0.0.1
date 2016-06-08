package com.jsg.base.controller;

import java.util.Date;
import java.util.List;

import javax.jws.WebParam.Mode;
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
import com.jsg.base.service.IDicService;
import com.jsg.base.util.DataUtil;
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
public class DicCategoryController extends BaseController {
	
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
	@RequestMapping({"dicManage/dicManage/queryDicCategory","dicManage/dicManage/ope-query/queryDicCategory"})
	public String queryDicCategoryPage(HttpServletRequest request,HttpServletResponse response,ModelMap model,DicCategory dicCategory){
		String flag = request.getParameter("flag");
		String pageNo = (request.getParameter("pageNo")!=null)?request.getParameter("pageNo"):"1";
		HttpSession session = request.getSession();
		BasePage page = this.dicSerivce.queryDicCategory(dicCategory, Integer.parseInt(pageNo), BasePage.DEFAULT_PAGE_SIZE);
		String pageTag = PageUtil.getPageInfo((int)page.getTotalPageCount(),(int)page.getTotalCount());
		if(DataUtil.strIsNotNull(flag) && flag.equals("1")){
			DicCategory dicCategoryB = (DicCategory) session.getAttribute("dicCategoryB");
			if(DataUtil.objIsNotNull(dicCategoryB)){
				dicCategory = dicCategoryB;
			}
		}
		session.setAttribute("dicCategoryB", dicCategory);
		model.addAttribute("pageTag", pageTag);
		model.addAttribute("page", page);
		model.addAttribute("dicCategory", dicCategory);
		
		return "dicManage/dicManage/queryDicCategory";
	}
	/**
	 * 
	* @Title: editDicCategory 
	* @Description: TODO(跳转到编辑页面) 
	* @param @param request
	* @param @param response
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-26 下午2:19:25
	 */
	@RequestMapping({"dicManage/dicManage/ope-add/addDicCategory","dicManage/dicManage/ope-update/editDicCategory"})
	public String editDicCategory(HttpServletRequest request,HttpServletResponse response,ModelMap model){
		String dicCateGoryId = request.getParameter("id");
		DicCategory dicCategory = new DicCategory();
		if(DataUtil.strIsNotNull(dicCateGoryId)){
			dicCategory = this.dicSerivce.getDicCateGoryById(dicCateGoryId);
		}	
		this.setData(dicCategory, model);
		return "dicManage/dicManage/editDicCategory";
	}
	/**
	 * 
	* @Title: saveDicCategory 
	* @Description: TODO(保存数据字典分类) 
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-30 上午11:14:35
	 */
	@RequestMapping({"dicManage/dicManage/ope-save/saveDicCategory"})
	public String saveDicCategory(HttpServletRequest request,HttpServletResponse response,ModelMap model,DicCategory dicCategory){
		
		String dicCategoryId = dicCategory.getId();
		if(DataUtil.strIsNotNull(dicCategoryId)){
//			DicCategory eDicCategory = this.dicSerivce.getDicCateGoryById(dicCategoryId);
//			eDicCategory.setName(dicCategory.getName());
			//修改
			this.dicSerivce.updateDicCategory(dicCategory);
		}else{
			//新增
			this.dicSerivce.saveDicCategory(dicCategory);
		}
		
		return "redirect:/dicManage/dicManage/ope-query/queryDicCategory.do";
	}
	/**
	 * 
	* @Title: delDicCategory 
	* @Description: TODO(删除数据字典分类) 
	* @param @param id
	* @param @param request
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-30 下午3:09:20
	 */
	@RequestMapping(value={"dicManage/dicManage/ope-del/delDicCategory/{id}"},produces={"text/plain;charset=UTF-8"},method=RequestMethod.DELETE)
	public @ResponseBody String delDicCategory(@PathVariable("id") String id,HttpServletRequest request,ModelMap model){
		try{
			this.dicSerivce.delDicCategoryById(id);
		}catch (Exception e) {
			return "error";
		}
		
		return "success";
	}
	/**
	 * 
	* @Title: viewDicCategory 
	* @Description: TODO(查看数据字典分类) 
	* @param @param request
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-5-30 下午6:42:46
	 */
	@RequestMapping({"dicManage/dicManage/ope-view/viewDicCategory"})
	public String viewDicCategory(HttpServletRequest request,ModelMap model){
		String id = request.getParameter("id");
		DicCategory dicCategory = this.dicSerivce.getDicCateGoryById(id);
		this.setData(dicCategory, model);
		return "dicManage/dicManage/viewDicCategory";
	}
	/**
	 * 
	* @Title: checkDicCategoryNameExist 
	* @Description: TODO(验证分类名称是否唯一) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-8 下午4:52:58
	 */
	@RequestMapping(value={"dicManage/dicManage/ope-check/checkDicCategoryNameExist"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String checkDicCategoryNameExist(HttpServletRequest request,HttpServletResponse response){
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		boolean checkResult = this.dicSerivce.isExistDicCategoryName(id, name);
		if(checkResult){
			return "true";
		}
		return "false";
	}
	/**
	 * 
	* @Title: checkDicCategoryCodeExist 
	* @Description: TODO(验证分类代码是否唯一) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-8 下午4:54:06
	 */
	@RequestMapping(value={"dicManage/dicManage/ope-check/checkDicCategoryCodeExist"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String checkDicCategoryCodeExist(HttpServletRequest request,HttpServletResponse response){
		String code = request.getParameter("code");
		String id = request.getParameter("id");
		boolean checkResult = this.dicSerivce.isExistDicCategoryCode(id, code);
		if(checkResult){
			return "true";
		}
		return "false";
	}
	/**
	 * 
	* @Title: setData 
	* @Description: TODO(封闭页面显示元素) 
	* @param @param dicCategory
	* @param @param model
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-26 下午2:28:34
	 */
	private void setData(DicCategory dicCategory,ModelMap model){
		model.addAttribute("dicCategory", dicCategory);
	}
	
}
