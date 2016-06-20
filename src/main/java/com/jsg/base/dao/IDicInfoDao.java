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
	
	/**
	 * 
	* @Title: getDicListByCode 
	* @Description: TODO(通过字典分类代码查询字典信息) 
	* @param @param code
	* @param @return
	* @return List<BaseDic>
	* @throws 
	* @author duanws
	* @date 2016-6-20 下午3:08:14
	 */
	public List<BaseDic> getDicListByCode(String code);
	/**
	 * 
	* @Title: getDicInfo 
	* @Description: TODO(通过分类编码和字典编码查询字典信息) 
	* @param @param code分类编码
	* @param @param dicCode字典编码
	* @param @return
	* @return BaseDic
	* @throws 
	* @author duanws
	* @date 2016-6-20 下午3:11:17
	 */
	public BaseDic getDicInfo(String code,String dicCode);
	/**
	 * 
	* @Title: delDicInfo 
	* @Description: TODO(删除数据字典) 
	* @param @param id
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-20 下午4:58:29
	 */
	void delDicInfo(String id);

}
