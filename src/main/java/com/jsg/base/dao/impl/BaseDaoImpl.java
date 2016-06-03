package com.jsg.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.support.SessionFlashMapManager;


import com.jsg.base.dao.IBaseDao;
import com.jsg.base.model.BaseModel;
import com.jsg.base.model.BasePage;
import com.jsg.base.util.DataUtil;

/**
 * 
* @ClassName: BaseDaoImpl 
* @Description: TODO(增删改查，基础操作) 
* @author duanws
* @date 2016-4-22 下午3:13:30 
*
 */
public class BaseDaoImpl implements IBaseDao {

	@Autowired
	protected SessionFactory sessionFactory;
	/**
	 * 
	* @Title: getSession 
	* @Description: TODO(获得当前开启的session) 
	* @param @return
	* @return Session
	* @throws 
	* @author duanws
	* @date 2016-4-25 下午1:53:56
	 */
	private Session getSession(){
		Session session = this.sessionFactory.getCurrentSession();
		if(!DataUtil.objIsNotNull(session)){
			session = this.sessionFactory.openSession();
		}
		return session;
	}
	/**
	 * 
	* @Title: get 
	* @Description: TODO(通过id查询实体类) 
	* @param @param paramClass
	* @param @param id
	* @param @return
	* @return BaseModel
	* @throws 
	* @author duanws
	* @date 2016-4-25 下午2:03:20
	 */
	public BaseModel get(Class paramClass,Serializable id){
		return (BaseModel) this.getSession().get(paramClass,id);
	}
	/**
	 * 
	* @Title: createQuery 
	* @Description: TODO(生成查询对象，设置参数) 
	* @param @param sqlString
	* @param @param paramObject
	* @param @return
	* @return Query
	* @throws 
	* @author duanws
	* @date 2016-4-25 下午2:07:59
	 */
	private Query createQuery(String sqlString,Object[] paramObject){
		Assert.hasText(sqlString);
		Query queryObj = this.getSession().createQuery(sqlString);
		if(paramObject != null){
			//拼装sql语句查询参数
			for(int i = 0;i < paramObject.length; ++i){
				queryObj.setParameter(i, paramObject[i]);
			}
		}
		return queryObj;
	}
	//返回查询列表
	@Override
	public List queryList(String sqlString, Object[] paramObject) {	
		return createQuery(sqlString,paramObject).list();
	}

	@Override
	//返回唯一实体类
	public Object queryUnique(String sqlString, Object[] paramObject) {
		
		return this.createQuery(sqlString, paramObject).uniqueResult();
	}

	@Override
	//更新实体类记录
	public void update(BaseModel paramModel) {
		//设置修改时间
		paramModel.setUpdateTime(new Date());
		this.getSession().update(paramModel);
		this.getSession().flush();
	}

	@Override
	//保存实体类记录
	public void save(BaseModel paramModel) {
		//设置创建时间
		paramModel.setCreateTime(new Date());
		//设置修改时间
		paramModel.setUpdateTime(new Date());
		this.getSession().save(paramModel);
		this.getSession().flush();

	}

	@Override
	//删除实体类记录
	public void delete(BaseModel paraModel) {
		this.getSession().delete(paraModel);

	}

	@Override
	//通过id删除实体类记录
	public void deleteById(Class paramClass, Serializable id) {
		BaseModel model = this.get(paramClass, id);
		this.delete(model);

	}

	@Override
	public void flush() {
		this.getSession().flush();

	}

	@Override
	public void clear() {
		this.getSession().clear();

	}

	@Override
	public void evit(BaseModel paramModel) {
		this.getSession().evict(paramModel);

	}

	@Override
	public BasePage queryPage(String sqlString, int pageNo, int pageSize,
			Object[] paramObject) {
		Assert.hasText(sqlString);
		Assert.isTrue(pageNo >= 1,"pageNo应该从1开始");
		String countQueryString = getCountQueryString(sqlString);
		List countList = queryList(countQueryString,paramObject);
		long totalCount = ((Long)countList.get(0)).longValue();
		
		if(totalCount < 1l){
			return new BasePage();
		}
		
		int startIndex = BasePage.getStartOfPage(pageNo, pageSize);
		Query query = this.createQuery(sqlString, paramObject);
		//设置开始记录数和结束记录数
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		
		return new BasePage(startIndex,totalCount,pageSize,list);
	}
	/**
	 * 
	* @Title: getCountQueryString 
	* @Description: TODO(获得总记录条数) 
	* @param @param sqlString
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-4-25 下午2:46:30
	 */
	private static String getCountQueryString(String sqlString){
		int beginPos = sqlString.toLowerCase().indexOf(" from ");
		if(sqlString.toLowerCase().startsWith("from ")){
			beginPos = 0;
		}
		Assert.isTrue(beginPos != -1,"hql :"+sqlString+"必须有from");
		if((beginPos > 0)&&(sqlString.toLowerCase().substring(0, beginPos).indexOf(" distinct")>-1)){
			return removeOrders(sqlString.substring(0, beginPos).replace("select", "select count(")+")"+sqlString.substring(beginPos));
		}
		return "select count(*)" + removeOrders(sqlString.substring(beginPos));
	}
	/**
	 * 
	* @Title: removeOrders 
	* @Description: TODO(出除非法字符) 
	* @param @param sqlString
	* @param @return
	* @return String
	* @throws 
	* @author duanws
	* @date 2016-4-25 下午2:46:19
	 */
	private static String removeOrders(String sqlString){
		Assert.hasText(sqlString);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|S]*",2);
		Matcher m = p.matcher(sqlString);
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			m.appendReplacement(sb, "");
			
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	@Override
	public Serializable getId(Class paramClass, BaseModel paramMode)
			throws NoSuchMethodException, IllegalAccessException,
			InvocationTargetException {
		
		return (Serializable) PropertyUtils.getProperty(paramMode, getIdName(paramClass));
	}

	@Override
	public String getIdName(Class paramClass) {
		ClassMetadata data = this.sessionFactory.getClassMetadata(paramClass);
		String idName = data.getIdentifierPropertyName();
		return idName;
	}

	@Override
	public BasePage sqlQueryPage(String sqlString, int pageNo,
			int pageSize, Object[] paramObject) {
		SQLQuery query = this.getSession().createSQLQuery(sqlString);
		if(paramObject != null){
			for(int i=0;i<paramObject.length;++i){
				query.setParameter(i, paramObject[i]);
			}
		}
		ScrollableResults scrollableResults = query.scroll(ScrollMode.SCROLL_SENSITIVE);
		scrollableResults.last();
		int totalCount = scrollableResults.getRowNumber();
		
		return getPageResult(query,totalCount + 1,pageNo,pageSize);
	}
	/**
	 * 
	* @Title: getPageResult 
	* @Description: TODO(jdbc分页查询) 
	* @param @param query
	* @param @param totalCount
	* @param @param pageNo
	* @param @param pageSize
	* @param @return
	* @return BasePage
	* @throws 
	* @author duanws
	* @date 2016-4-25 下午4:39:54
	 */
	private BasePage getPageResult(Query query,int totalCount,int pageNo,int pageSize){
		if(totalCount < 1){
			return new BasePage();
		}
		int startIndex = BasePage.getStartOfPage(pageNo, pageSize);
		
		List list = query.setFirstResult(startIndex).setMaxResults(pageSize).list();
		return new BasePage(startIndex,totalCount,pageSize,list);
	}
	@Override
	/**
	 * jdbc查询
	 */
	public List sqlQuery(String sqlString, Object[] paramObject) {
		SQLQuery query = this.getSession().createSQLQuery(sqlString);
		if(paramObject != null){
			for(int i=0;i<paramObject.length;++i){
				query.setParameter(i, paramObject[i]);
			}
		}
		return query.list();
	}

	@Override
	public boolean isUnique(Class paramClass, BaseModel paramModel,
			String[] paramArrayOfString) {
		Criteria criteria = createCriteria(paramClass,new Criterion[0]).setProjection(Projections.rowCount());
		try{
			for(String name : paramArrayOfString){
				criteria.add(Restrictions.eq(name, PropertyUtils.getProperty(paramModel, name)));
			}
			
			String idName = getIdName(paramClass);
			Serializable id = getId(paramClass,paramModel);
			if((id!=null) && (!id.equals(""))){
				criteria.add(Restrictions.not(Restrictions.eq(idName, id)));
			}
		}catch(Exception e){
			ReflectionUtils.handleReflectionException(e);
		}
		return Integer.valueOf(criteria.uniqueResult().toString()).intValue()==0;
	}
	private Criteria createCriteria(Class paramClass,Criterion[] criterions){
		Criteria criteria = this.getSession().createCriteria(paramClass);
		for(Criterion c:criterions){
			criteria.add(c);
		}
		return criteria;
	}
	private Criteria createCriteria(Class paramClass,String orderBy,boolean isAsc,Criterion[] criterions){
		Criteria criteria = createCriteria(paramClass,criterions);
		if(isAsc){
			criteria.addOrder(Order.asc(orderBy));
		}else{
			criteria.addOrder(Order.desc(orderBy));
		}
		return criteria;
	}
	
	private Query setParameter(Query query,Map<String,Object> map){
		if(map != null){
			Set<String> mapSet = map.keySet();
		    for(String key : mapSet){
		    	Object obj = map.get(key);
		    	if(obj instanceof Collection){
		    		query.setParameterList(key, (Collection)obj);
		    	}else if(obj instanceof Object[]){
		    		query.setParameterList(key, (Object[])obj);
		    	}else{
		    		query.setParameter(key, obj);
		    	}
		    }
		}
		return query;
	}
	

	@Override
	public long queryCount(String sqlString, Object[] paramObject) {
		Query queryObject = createQuery(sqlString, paramObject);
		List list = queryObject.list();
		if((list != null) && (list.size()>0)){
			Long count = (Long) list.get(0);
			if(count.intValue()>0){
				return count.intValue();
			}
			return 0;
		}
		return 0;
	}

	@Override
	public BasePage queryPage(String paramString, Map<String, Object> paramMap,
			int pageNo, int pageSize) {
		String countQueryString = getCountQueryString(paramString);
		List countList = getQuery(countQueryString, paramMap).list();
		Long totalCount = ((Long) countList.get(0)).longValue();
		if(totalCount < 1l){
			return new BasePage();
		}
		
		int startIndex = BasePage.getStartOfPage(pageNo, pageSize);
		Query query = getQuery(paramString,paramMap,pageNo,pageSize);
		List list = query.list();
		return new BasePage(startIndex,totalCount,pageSize,list);
	}

	@Override
	public List queryList(String sqlString, Map<String, Object> paramMap) {
		
		return this.getQuery(sqlString, paramMap).list();
	}

	@Override
	public void executeHql(String paramString, Object[] paramObject) {
		Query queryObject = createQuery(paramString,paramObject);
		queryObject.executeUpdate();
	}

	@Override
	public void executeHql(String paramString, Map<String, Object> paramMap) {
		Query query = getQuery(paramString,paramMap);
		query.executeUpdate();
	}
	
	//拼装sql参数
	private Query getQuery(String sqlString,Map<String,Object> paramMap){
		Query query = createQuery(sqlString,new Object[0]);
		query = setParameter(query, paramMap);
		return query;
	}
	//拼装sql参数
	private Query getQuery(String sqlString,Map<String,Object> paramMap,int pageNo,int pageSize){
		Query query = createQuery(sqlString,new Object[0]);
		query = setParameter(query, paramMap);
		query = setPageProperty(query, pageNo,pageSize);
		return query;
	}
	//设置分页参数
	private Query setPageProperty(Query query,int pageNo,int pageSize){
		if((pageNo != 0) && (pageSize != 0)){
			query.setFirstResult((pageNo - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query;
	}

}
