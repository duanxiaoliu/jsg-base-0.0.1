package com.jsg.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * 
* @ClassName: BasePage 
* @Description: TODO(分页实体类) 
* @author duanws
* @date 2016-4-21 下午2:51:01 
*
 */
public class BasePage implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 1L;
	//默认每页显示记录条数
	public static int DEFAULT_PAGE_SIZE = 10;
	//每页显示记录条数
	private int pageSize;
	//开始记录位置
	private long start;
	//查询出的记录数据
	private Collection pageData;
	//总记录条数
	private long totalCount;
	//无参构造函数，用于实例化page对象
	public BasePage(){
		this(0L,0L,DEFAULT_PAGE_SIZE,new ArrayList(0));
	}
	
	public BasePage(long start,long totalSize,int pageSize,Collection pageData){
		this.pageSize = this.DEFAULT_PAGE_SIZE;
		this.start = start;
		this.totalCount = totalSize;
		this.pageData = pageData;
	}
	//返回总记录条数
	public long getTotalCount(){
		return this.totalCount;
	}
	//返回总页数
	public long getTotalPageCount(){
		
		if(this.totalCount % this.pageSize == 0L){
			return this.totalCount / this.pageSize;
		}else{
			return this.totalCount / this.pageSize + 1L;
		}
	}
	//返回每页显示条数
	public int getPageSize(){
		return this.pageSize;
	}
	//返回记录数据
	public Collection getResult(){
		return this.pageData;
	}
	//设置记录数据
	public void setResult(Collection pageData){
		this.pageData = pageData;
	}
	//返回当前页数
	public long getCurrentPageNo(){
		return this.start / this.pageSize + 1L;
	}
	//是否还有页
	public boolean hasNextPage(){
		return getCurrentPageNo() < getTotalPageCount();
	}
	//前面是否还是页面
	public boolean hasPrePage(){
		return this.getCurrentPageNo() > 1l;
	}
	//返回下一页
	public long getNextPageNo(){
		if(this.hasNextPage()){
			return this.getCurrentPageNo() + 1l;
		}
		return this.getCurrentPageNo();
	}
	//返回前一页
	public long getPrePageNo(){
		if(this.hasPrePage()){
			return this.getCurrentPageNo() - 1l;
		}
		return this.getCurrentPageNo();
	}
	//返回开始记录行数
	public static int getStartOfPage(int pageNo,int pageSize){
		return (pageNo - 1) * pageSize;
	}
	//返回开始记录行数
	static int getStartOfPage(int pageNo){
		return getStartOfPage(pageNo,DEFAULT_PAGE_SIZE);
	}
	
	public long getStart(){
		return this.start;
	}
	
	public void setStart(long start){
		this.start = start;
	}
	
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
	
	public void setTotalCount(long totalCount){
		this.totalCount = totalCount;
	}
}
