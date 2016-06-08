package com.jsg.base.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;

public interface IDicInfoDao extends IBaseDao {
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
	* @date 2016-6-3 下午2:21:26
	 */
	BasePage getDicInfoListById(int pageNo,int pageSize,BaseDic baseDic);

	/**
	 * 
	* @Title: getDicInfoListByCategoryId 
	* @Description: TODO() 
	* @param @param DicCategoryId
	* @param @return
	* @return List<BaseDic>
	* @throws 
	* @author duanws
	* @date 2016-6-8 上午11:33:51
	 */
	List<BaseDic> getDicInfoListByCategoryId(String DicCategoryId);

}
