package com.jsg.base.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import com.jsg.base.model.BaseModel;
import com.jsg.base.model.BasePage;

/**
 * 
* @ClassName: IBaseDao 
* @Description: TODO(处理基础增，删，改，查操作) 
* @author duanws
* @date 2016-4-22 下午2:13:56 
*
 */
public abstract interface IBaseDao {
	/**
	 * 
	* @Title: queryList 
	* @Description: TODO(查询，返回list) 
	* @param @param sqlString
	* @param @param paramObject
	* @param @return
	* @return List
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:21:17
	 */
	public abstract List queryList(String sqlString, Object[] paramObject);
	/**
	 * 
	* @Title: queryUnique 
	* @Description: TODO(查询，返回单一对象) 
	* @param @param sqlString
	* @param @param paramObject
	* @param @return
	* @return Object
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:22:29
	 */
	public abstract Object queryUnique(String sqlString,Object[] paramObject);
	/**
	 * 
	* @Title: update 
	* @Description: TODO(更新操作) 
	* @param @param paramModel
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:26:45
	 */
	public abstract void update(BaseModel paramModel);
	/**
	 * 
	* @Title: save 
	* @Description: TODO(保存操作) 
	* @param @param paramModel
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:27:45
	 */
	public abstract void save(BaseModel paramModel);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO(通过实体类删除) 
	* @param @param paraModel
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:29:06
	 */
	public abstract void delete(BaseModel paraModel);
	/**
	 * 
	* @Title: deleteById 
	* @Description: TODO(通过id删除) 
	* @param @param paramClass
	* @param @param id
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:29:56
	 */
	public abstract void deleteById(Class paramClass,Serializable id);
	/**
	 * 
	* @Title: flush 
	* @Description: TODO() 
	* @param 
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:30:52
	 */
    public abstract void flush();
    /**
     * 
    * @Title: clear 
    * @Description: TODO(清除session缓存) 
    * @param 
    * @return void
    * @throws 
    * @author duanws
    * @date 2016-4-22 下午2:30:57
     */
    public abstract void clear();
	/**
	 * 
	* @Title: evit 
	* @Description: TODO(清除缓存) 
	* @param 
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-4-22 下午2:31:53
	 */
    public abstract void evit(BaseModel paramModel);
    /**
     * 
    * @Title: queryPage 
    * @Description: TODO(分页查询) 
    * @param @param sqlString
    * @param @param paramInt1
    * @param @param paramInt2
    * @param @param paramObject
    * @param @return
    * @return BasePage
    * @throws 
    * @author duanws
    * @date 2016-4-22 下午2:33:39
     */
    public abstract BasePage queryPage(String sqlString,int paramInt1,int paramInt2,Object[] paramObject);
    /**
     * 
    * @Title: getId 
    * @Description: TODO(获取id) 
    * @param @param paramClass
    * @param @param paramMode
    * @param @return
    * @param @throws NoSuchMethodException
    * @param @throws IllegalAccessException
    * @param @throws InvocationTargetException
    * @return Serializable
    * @throws 
    * @author duanws
    * @date 2016-4-22 下午2:52:25
     */
    public abstract Serializable getId(Class paramClass,BaseModel paramMode)throws NoSuchMethodException,IllegalAccessException,InvocationTargetException;
    
    public abstract String getIdName(Class paramClass);
    /**
     * 
    * @Title: sqlQueryPage 
    * @Description: TODO(jdbc查询) 
    * @param @param sqlString
    * @param @param paramInt1
    * @param @param paramInt2
    * @param @param paramObject
    * @param @return
    * @return BasePage
    * @throws 
    * @author duanws
    * @date 2016-4-22 下午3:05:57
     */
    public abstract BasePage sqlQueryPage(String sqlString,int paramInt1,int paramInt2,Object[] paramObject);
    
    public abstract List sqlQuery(String sqlString,Object[] paramObject);
    
    public abstract boolean isUnique(Class paramClass,BaseModel paramModel,String [] paramArrayOfString);
    
    public abstract BaseModel get(Class paramClass,BaseModel paramModel,String [] paramString);
    
    public abstract long queryCount(String paramStirng,Object[] paramObject);
    
    public abstract BasePage queryPage(String paramString,Map<String,Object> paramMap,int paramInt1,int paramInt2);
    
    public abstract List queryList(String sqlString,Map<String,Object> paramMap);
    
    public abstract void executeHql(String paramString,Object[] paramObject);
    
    public abstract void executeHql(String paramString,Map<String,Object> paramMap);
}
