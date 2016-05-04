package com.jsg.base.model;

import java.io.Serializable;

/**
 * 
* @ClassName: UserLoginInfo 
* @Description: TODO(用户登录信息) 
* @author duanws
* @date 2016-5-3 下午4:19:16 
*
 */
public class UserLoginInfo extends BaseModel implements Serializable{
	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 1L;
	//登录名
	private String loginName;
	//密码
	private String password;
	//登录状态
	private BaseDic loginStatusDic;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BaseDic getLoginStatusDic() {
		return loginStatusDic;
	}
	public void setLoginStatusDic(BaseDic loginStatusDic) {
		this.loginStatusDic = loginStatusDic;
	}

}
