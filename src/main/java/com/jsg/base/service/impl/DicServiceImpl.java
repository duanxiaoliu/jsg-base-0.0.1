package com.jsg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IDicDao;
import com.jsg.base.model.BaseDic;
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

	@Override
	public DicCategory getDicCateGoryById(String id) {
		
		return (DicCategory) this.dicDao.get(DicCategory.class, id);
	}

	@Override
	public void saveDicCategory(DicCategory dicCategory) {
		this.dicDao.save(dicCategory);
		
	}

	@Override
	public void updateDicCategory(DicCategory dicCategory) {
		this.dicDao.update(dicCategory);
		
	}

	@Override
	public void delDicCategoryById(String id) {
		this.dicDao.delDicCategoryById(id);
		
	}

	@Override
	public boolean isExistDicCategoryCode(String id, String code) {
		String hql = " from DicCategory dc where dc.code='"+code+"'";
		List<DicCategory> list = this.dicDao.queryList(hql, new Object[0]);
		if((list != null) && (list.size()>0)){
			if(list.size()==1){
				if(!list.get(0).getId().equals(id)){
					return false;
				}
			}else if(list.size() > 1){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isExistDicCategoryName(String id, String name) {
		String hql = " from DicCategory dc where dc.name='"+name+"'";
		List<DicCategory> list = this.dicDao.queryList(hql, new Object[0]);
		if((list != null) && (list.size()>0)){
			if(list.size()==1){
				if(!list.get(0).getId().equals(id)){
					//存在
					return false;
				}
			}else if(list.size() > 1){
				//存在
				return false;
			}
		}
		return true;
	}
}
