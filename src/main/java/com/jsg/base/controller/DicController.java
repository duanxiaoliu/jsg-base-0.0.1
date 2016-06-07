package com.jsg.base.controller;

import java.util.HashMap;
import java.util.Map;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.service.IDicInfoService;
import com.jsg.base.util.DataUtil;
import com.jsg.base.util.PageUtil;


@Controller
public class DicController extends BaseController {
	@Autowired
	private IDicInfoService dicInfoService;
	/**
	 * 
	* @Title: queryDicInfo 
	* @Description: TODO(通过字典分类查询字典) 
	* @param @param request
	* @param @param response
	* @param @param model
	* @param @param baseDic
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-1 下午4:45:19
	 */
	@RequestMapping({"dicManage/dicInfoManage/ope-query/queryDicInfo"})
	public String queryDicInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,BaseDic baseDic){
		String dicCategoryId = request.getParameter("dicCategoryId");
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		if(DataUtil.strIsNotNull(dicCategoryId)){
			DicCategory dicCategory = new DicCategory();
			dicCategory.setId(dicCategoryId);
			baseDic.setDicCategory(dicCategory);
		}
		
		String pageNo = (request.getParameter("pageNo")!=null)?request.getParameter("pageNo"):"1";
		BasePage page = this.dicInfoService.getDicInfoListById(Integer.parseInt(pageNo), BasePage.DEFAULT_PAGE_SIZE, baseDic);
		String pageTag = PageUtil.getPageInfo((int)page.getTotalPageCount(),(int)page.getTotalCount());
		if(DataUtil.strIsNotNull(flag) && flag.equals("1")){
			BaseDic baseDicB = (BaseDic) session.getAttribute("baseDicB");
			if(DataUtil.objIsNotNull(baseDicB)){
				baseDic = baseDicB;
			}
		}
		session.setAttribute("baseDicB", baseDic);
		model.addAttribute("pageTag", pageTag);
		model.addAttribute("page", page);
		this.setData(baseDic, model);
		
		return "dicManage/dicInfoManage/queryDicInfo";
	}
	/**
	 * 
	* @Title: editDicInfo 
	* @Description: TODO(新增，修改跳转) 
	* @param @param request
	* @param @param response
	* @param @param model
	* @param @param baseDic
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-3 下午4:05:12
	 */
	@RequestMapping({"dicManage/dicInfoManage/ope-add/addDicInfo","dicManage/dicInfoManage/ope-update/editDicInfo"})
	public String editDicInfo(HttpServletRequest request,HttpServletResponse response,ModelMap model,BaseDic baseDic){
		String dicId = request.getParameter("id");
		if(DataUtil.strIsNotNull(dicId)){
			//修改
			BaseDic eBaseDic = this.dicInfoService.getDicInfoById(dicId);
			this.setData(eBaseDic, model);
		}else{
			this.setData(baseDic, model);
		}
		
		return "dicManage/dicInfoManage/editDicInfo";
	}
	/**
	 * 
	* @Title: saveDicInfo 
	* @Description: TODO(保存数据字典信息) 
	* @param @param request
	* @param @param baseDic
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-6 下午2:04:25
	 */
	@RequestMapping({"dicManage/dicInfoManage/ope-save/saveDicInfo"})
	public String saveDicInfo(HttpServletRequest request,BaseDic baseDic,ModelMap model){
		String dicId = baseDic.getId();
		if(DataUtil.strIsNotNull(dicId)){
			this.dicInfoService.updateDicInfo(baseDic);
		}else{
			this.dicInfoService.saveDicInfo(baseDic);
		}
		return "redirect:/dicManage/dicInfoManage/ope-query/queryDicInfo.do";
	}
	/**
	 * 
	* @Title: startDic 
	* @Description: TODO(启用数据字典) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-7 上午11:20:38
	 */
	@RequestMapping(value={"dicManage/dicInfoManage/ope-update/startDic"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String startDic(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		BaseDic baseDic = this.dicInfoService.getDicInfoById(id);
		if(DataUtil.objIsNotNull(baseDic)){
			baseDic.setStatus("1");
			this.dicInfoService.updateDicInfo(baseDic);
			baseDic.setComments("success");
		}
		baseDic.setDicCategory(null);
		String jsonStr = JSONObject.fromObject(baseDic).toString();
		return jsonStr;
	} 
	/**
	 * 
	* @Title: stopDic 
	* @Description: TODO(禁用数据字典) 
	* @param @param request
	* @param @param response
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-7 上午11:20:56
	 */
	@RequestMapping(value={"dicManage/dicInfoManage/ope-update/stopDic"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String stopDic(HttpServletRequest request,HttpServletResponse response){
		String id = request.getParameter("id");
		BaseDic baseDic = this.dicInfoService.getDicInfoById(id);
		if(DataUtil.objIsNotNull(baseDic)){
			baseDic.setStatus("0");
			this.dicInfoService.updateDicInfo(baseDic);
			baseDic.setComments("success");
		}
		baseDic.setId(baseDic.getId());
		baseDic.setName(baseDic.getName());
		baseDic.setDicCategory(null);
		String jsonStr = JSONObject.fromObject(baseDic).toString();
		return jsonStr;
	} 
	/**
	 * 
	* @Title: delDicInfo 
	* @Description: TODO(删除数据字典) 
	* @param @param request
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-6-7 下午4:27:20
	 */
	@RequestMapping(value={"dicManage/dicInfoManage/ope-del/delDicInfo"},produces={"text/plain;charset=UTF-8"})
	public @ResponseBody String delDicInfo(HttpServletRequest request){
		String id = request.getParameter("id");
		try{
			this.dicInfoService.delDicInfoById(id);
		}catch(Exception e){
			return "error";
		}
		return "success";
	}
	
	/**
	 * 
	* @Title: setData 
	* @Description: TODO(封闭页面显示元素) 
	* @param @param baseDic
	* @param @param model
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-3 下午2:09:38
	 */
	private void setData(BaseDic baseDic,ModelMap model){
		
		
	}
}
