package com.jsg.base.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;

public interface IDicInfoService extends IBaseService {
	/**
	 * 
	* @Title: getDicInfoListById 
	* @Description: TODO(通过分类id查询字典信息) 
	* @param @param pageNo
	* @param @param pageSize
	* @param @param baseDic
	* @param @return
	* @return BasePage
	* @throws 
	* @author duanws
	* @date 2016-6-3 下午2:20:44
	 */
	BasePage getDicInfoListById(int pageNo,int pageSize,BaseDic baseDic);
	/**
	 * 
	* @Title: delDicInfoById 
	* @Description: TODO(通过id删除字典信息) 
	* @param @param id
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-3 下午2:01:35
	 */
	void delDicInfoById(String id);
	 /**
	  * 
	 * @Title: getDicInfoById 
	 * @Description: TODO(通过id查询字典信息) 
	 * @param @param id
	 * @param @return
	 * @return BaseDic
	 * @throws 
	 * @author duanws
	 * @date 2016-6-3 下午2:01:47
	  */
	BaseDic getDicInfoById(String id);
	/**
	 * 
	* @Title: saveDicInfo 
	* @Description: TODO(保存字典信息) 
	* @param @param baseDic
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-3 下午2:02:01
	 */
	void saveDicInfo(BaseDic baseDic);
	/**
	 * 
	* @Title: updateDicInfo 
	* @Description: TODO(修改字典信息) 
	* @param @param baseDic
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-3 下午2:02:14
	 */
	void updateDicInfo(BaseDic baseDic);
}
