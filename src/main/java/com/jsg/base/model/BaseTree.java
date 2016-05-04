package com.jsg.base.model;

import java.io.Serializable;
/**
 * 
* @ClassName: BaseTree 
* @Description: TODO(处理左侧目录菜单) 
* @author duanws
* @date 2016-4-26 下午4:20:54 
*
 */
public class BaseTree implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	//父节点
	private String pId;
	//名称
	private String name;
	//是否打开
	private String open = "false";
	
	private String param;
	//图标
	private String icon;
	//是否选中
	private String checked = "false";
	//标题
	private String title;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
