package com.jsg.base.model;

import java.io.Serializable;


/**
 * 
* @ClassName: BaseTreeModel 
* @Description: TODO(菜单实体类) 
* @author duanws
* @date 2016-4-26 下午5:17:30 
*
 */
public class BaseTreeModel extends BaseModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//父节点
	private BaseTreeModel parent;
	//名称
	private String name;
	//代码
	private String code;
	//链接
	private String urlStr;
	//样式图标
	private String classCode;
	//顺序
	private int seqNum;
	//状态
	private BaseDic status;
	public BaseTreeModel getParent() {
		return parent;
	}
	public void setParent(BaseTreeModel parent) {
		this.parent = parent;
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
	public String getUrlStr() {
		return urlStr;
	}
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public int getSeqNum() {
		return seqNum;
	}
	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}
	public BaseDic getStatus() {
		return status;
	}
	public void setStatus(BaseDic status) {
		this.status = status;
	}
	

}
