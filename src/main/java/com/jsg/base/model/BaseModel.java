package com.jsg.base.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName: BaseModel 
* @Description: TODO(基础实体类) 
* @author duanws
* @date 2016-4-21 下午2:27:09 
*
 */
public class BaseModel implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 1L;

	private String id;
	//备注
	private String comments;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}
