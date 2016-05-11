package com.jsg.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IDicDao;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.service.IDicService;
/**
 * 
* @ClassName: DicServiceImpl 
* @Description: TODO(处理数据字典) 
* @author duanws
* @date 2016-5-11 下午4:56:26 
*
 */
@Service("dicService")
public class DicServiceImpl implements IDicService {
	
	@Autowired
	private IDicDao dicDao;

	@Override
	public BasePage queryDicCategory(DicCategory dicCategory, int pageNo,
			int pageSize) {
		return this.dicDao.queryDicCategory(dicCategory, pageNo, pageSize);
	}
}
