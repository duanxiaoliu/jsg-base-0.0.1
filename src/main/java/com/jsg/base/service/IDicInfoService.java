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
	/**
	 * 
	* @Title: isExistDicCode 
	* @Description: TODO(验证数据字典是否唯一) 
	* @param @param id
	* @param @param code
	* @param @param dicCategoryId
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-6-6 下午3:12:10
	 */
	boolean isExistDicCode(String id,String code,String dicCategoryId);
	/**
	 * 
	* @Title: isExistDicName 
	* @Description: TODO(验证数据字典名称是否唯一) 
	* @param @param id
	* @param @param name
	* @param @param dicCategoryId
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-6-6 下午3:12:14
	 */
	boolean isExistDicName(String id,String name,String dicCategoryId);
	/**
	 * 
	* @Title: upDicInfo 
	* @Description: TODO(上移数据字典) 
	* @param @param id
	* @param @param dicCategoryId
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-8 上午11:28:51
	 */
	void upDicInfo(String id,String dicCategoryId);
	/**
	 * 
	* @Title: downDicInfo 
	* @Description: TODO(下移数据字典) 
	* @param @param id
	* @param @param dicCategoryId
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-6-8 上午11:29:00
	 */
	void downDicInfo(String id,String dicCategoryId);
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
}
