package com.jsg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jsg.base.dao.IDicDao;
import com.jsg.base.dao.IDicInfoDao;
import com.jsg.base.model.BaseDic;
import com.jsg.base.model.BasePage;
import com.jsg.base.service.IDicInfoService;

@Service("dicInfoService")
public class DicInfoServiceImpl implements IDicInfoService {

	@Autowired
	private IDicInfoDao dicInfoDao;
	
	@Override
	public BasePage getDicInfoListById(int pageNo,int pageSize,BaseDic baseDic) {
		return this.dicInfoDao.getDicInfoListById(pageNo,pageSize,baseDic);
	}

	@Override
	public void delDicInfoById(String id) {
		this.dicInfoDao.delDicInfo(id);
		
	}

	@Override
	public BaseDic getDicInfoById(String id) {
		
		return (BaseDic) this.dicInfoDao.get(BaseDic.class, id);
	}

	@Override
	public void saveDicInfo(BaseDic baseDic) {
		baseDic.setSeqNum(this.getMaxSeqNum(baseDic.getDicCategory().getId()));
		this.dicInfoDao.save(baseDic);
		
	}

	@Override
	public void updateDicInfo(BaseDic baseDic) {
		this.dicInfoDao.update(baseDic);
		
	}
	/**
	 * 
	* @Title: getMaxSeqNum 
	* @Description: TODO(根据字典分类，返回分类下排序号最大的数，字典排序使用) 
	* @param @param dicCategoryId
	* @param @return
	* @return int
	* @throws 
	* @author duanws
	* @date 2016-6-6 下午2:51:27
	 */
	synchronized int getMaxSeqNum(String dicCategoryId){
		String hql = " from BaseDic bd where bd.dicCategory.id='"+dicCategoryId+"' order by bd.seqNum desc";
		List list = this.dicInfoDao.queryList(hql.toString(), new Object[0]);
		if((list != null) && (list.size()>0) && (list.get(0) != null)){
			return ((BaseDic) list.get(0)).getSeqNum() + 1;
		}
		return 1;
	}

	@Override
	public boolean isExistDicCode(String id, String code, String dicCategoryId) {
		String hql = " from BaseDic bd where bd.code='"+code+"' and bd.dicCategory.id='"+dicCategoryId+"'";
		List<BaseDic> list = this.dicInfoDao.queryList(hql, new Object[0]);
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
	public boolean isExistDicName(String id, String name, String dicCategoryId) {
		String hql = " from BaseDic bd where bd.name='"+name+"' and bd.dicCategory.id='"+dicCategoryId+"'";
		List<BaseDic> list = this.dicInfoDao.queryList(hql, new Object[0]);
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
	public void upDicInfo(String id, String dicCategoryId) {
		List<BaseDic> list = this.dicInfoDao.getDicInfoListByCategoryId(dicCategoryId);
		if(list != null && list.size()>1){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getId().equals(id) || list.get(i).getId()==id){
					//列表中上一个对象存在时才进行操作
					if(i-1>=0 && list.get(i-1)!=null){
						BaseDic baseDic = list.get(i);
						int tempNum = baseDic.getSeqNum();
						BaseDic baseDicB = list.get(i-1);
						baseDic.setSeqNum(baseDicB.getSeqNum());
						baseDicB.setSeqNum(tempNum);
						this.dicInfoDao.update(baseDic);
						this.dicInfoDao.update(baseDicB);
					}
				}
			}
		}
		
	}

	@Override
	public void downDicInfo(String id, String dicCategoryId) {
		List<BaseDic> list = this.dicInfoDao.getDicInfoListByCategoryId(dicCategoryId);
		if(list != null && list.size()>1){
			for(int i=0;i<list.size();i++){
				if(list.get(i).getId().equals(id) || list.get(i).getId()==id){
					//列表中上一个对象存在时才进行操作
					if(i+1<=list.size() && list.get(i+1)!=null){
						BaseDic baseDic = list.get(i);
						int tempNum = baseDic.getSeqNum();
						BaseDic baseDicB = list.get(i+1);
						baseDic.setSeqNum(baseDicB.getSeqNum());
						baseDicB.setSeqNum(tempNum);
						this.dicInfoDao.update(baseDic);
						this.dicInfoDao.update(baseDicB);
					}
				}
			}
		}
		
	}

	@Override
	public List<BaseDic> getDicListByCode(String code) {
		
		return this.dicInfoDao.getDicListByCode(code);
	}

	@Override
	public BaseDic getDicInfo(String code, String dicCode) {
		return this.dicInfoDao.getDicInfo(code, dicCode);
	}

}
