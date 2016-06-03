package com.jsg.base.dao.impl;

import org.springframework.stereotype.Repository;

import com.jsg.base.dao.IBaseDao;
import com.jsg.base.dao.IDicDao;
import com.jsg.base.model.BasePage;
import com.jsg.base.model.DicCategory;
import com.jsg.base.util.DataUtil;
/**
 * 
* @ClassName: dicDaoImpl 
* @Description: TODO(处理数据字典) 
* @author duanws
* @date 2016-5-11 下午4:57:49 
*
 */
@Repository("dicDao")
public class dicDaoImpl extends BaseDaoImpl implements IDicDao {
	
	/**
	 * 分页查询数据字典分类
	 */
	@Override
	public BasePage queryDicCategory(DicCategory dicCategory, int pageNo,
			int pageSize) {
		StringBuffer hql = new StringBuffer(" from DicCategory dc where 1=1");
		//分类名称
		if(DataUtil.strIsNotNull(dicCategory.getName())){
			hql.append(" and dc.name like '%"+dicCategory.getName()+"%'");
		}
		//分类编码
		if(DataUtil.strIsNotNull(dicCategory.getCode())){
			hql.append(" and dc.code like '%"+dicCategory.getCode()+"%'");
		}
		hql.append(" order by dc.updateTime desc");
		
		BasePage page = this.queryPage(hql.toString(), pageNo, pageSize, new Object[0]);
		return page;
	}

	@Override
	public void delDicCategoryById(String id) {
		String hql = " delete from DicCategory dc where dc.id='"+id+"'";
		this.executeHql(hql, new Object[0]);
	}

}
