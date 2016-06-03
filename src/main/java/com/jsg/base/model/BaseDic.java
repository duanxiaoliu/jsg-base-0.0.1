package com.jsg.base.model;

import java.io.Serializable;
/**
 * 
* @ClassName: BaseDic 
* @Description: TODO(数据字典) 
* @author duanws
* @date 2016-5-11 下午2:10:35 
*
 */
public class BaseDic extends BaseModel implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 1L;
	//名称
	private String name;
	//代码
	private String code;
	//状态
	private String status;
	//排序
	private int seqNum;
	//分类
	private DicCategory dicCategory;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public DicCategory getDicCategory() {
		return dicCategory;
	}
	public void setDicCategory(DicCategory dicCategory) {
		this.dicCategory = dicCategory;
	}
	
}
