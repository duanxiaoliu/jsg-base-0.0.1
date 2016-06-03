package com.jsg.base.service;

import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;

public interface IDicService extends IBaseService {
	/**
	 * 
	* @Title: queryDicCategory 
	* @Description: TODO(分页查询数据字典分类) 
	* @param @param dicCategory
	* @param @param pageNo
	* @param @param pageSize
	* @param @return
	* @return BasePage
	* @throws 
	* @author duanws
	* @date 2016-5-30 上午11:17:24
	 */
	BasePage queryDicCategory(DicCategory dicCategory,int pageNo,int pageSize);
	/**
	 * 
	* @Title: getDicCateGoryById 
	* @Description: TODO(通过id查询数据字典分类) 
	* @param @param id
	* @param @return
	* @return DicCategory
	* @throws 
	* @author duanws
	* @date 2016-5-30 上午11:17:36
	 */
	DicCategory getDicCateGoryById(String id);
	/**
	 * 
	* @Title: saveDicCategory 
	* @Description: TODO(保存数据字曲分类) 
	* @param @param dicCategory
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-30 上午11:17:51
	 */
	void saveDicCategory(DicCategory dicCategory);
	/**
	 * 
	* @Title: updateDicCategory 
	* @Description: TODO(修改数据字典分类) 
	* @param @param dicCategory
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-30 上午11:18:01
	 */
	void updateDicCategory(DicCategory dicCategory);
	/**
	 * 
	* @Title: delDicCategoryById 
	* @Description: TODO(通过id删除字典分类) 
	* @param @param id
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-30 下午2:08:14
	 */
	void delDicCategoryById(String id);
}
