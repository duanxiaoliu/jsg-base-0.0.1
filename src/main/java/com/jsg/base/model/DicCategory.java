package com.jsg.base.model;

import java.io.Serializable;

public class DicCategory extends BaseModel implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 1L;
	private String id;
	//分类名称
	private String name;
	//分类代码
	private String code;
	//分类状态
	private String status;
	//分类类型
	private String cateGroryType;
	
	public String getCateGroryType() {
		return cateGroryType;
	}
	public void setCateGroryType(String cateGroryType) {
		this.cateGroryType = cateGroryType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
}
