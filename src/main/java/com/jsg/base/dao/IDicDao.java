package com.jsg.base.dao;

import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
/**
 * 
* @ClassName: IDicDao 
* @Description: TODO(处理数据字典) 
* @author duanws
* @date 2016-5-11 下午5:13:34 
*
 */
public interface IDicDao extends IBaseDao {
	/**
	 * 
	* @Title: queryDicCategory 
	* @Description: TODO() 
	* @param @param dicCategory
	* @param @param pageNo
	* @param @param pageSize
	* @param @return
	* @return BasePage
	* @throws 
	* @author duanws
	* @date 2016-5-11 下午5:13:28
	 */
	BasePage queryDicCategory(DicCategory dicCategory,int pageNo,int pageSize);
	
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
