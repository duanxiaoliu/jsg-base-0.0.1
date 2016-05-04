package com.jsg.base.model;

import java.io.Serializable;
/**
 * 
* @ClassName: UserInfo 
* @Description: TODO(用户基础信息) 
* @author duanws
* @date 2016-5-3 下午3:48:04 
*
 */
public class UserInfo extends BaseModel implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO() 
	*/ 
	private static final long serialVersionUID = 1L;
	//姓名
	private String name;
	//性别
	private BaseDic genderDic;
	//证件类型
	private BaseDic cerTypeDic;
	//证件号码
	private String cerNum;
	//邮件
	private String email;
	//电话号码
	private String phone;
	//地址
	private String address;
	//状态
	private BaseDic statusDic;
	//生日
	private String birthday;
	//用户类型
	private BaseDic userTypeDic;
	//用户登录信息
	private UserLoginInfo userLogin;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseDic getGenderDic() {
		return genderDic;
	}

	public void setGenderDic(BaseDic genderDic) {
		this.genderDic = genderDic;
	}

	public BaseDic getCerTypeDic() {
		return cerTypeDic;
	}

	public void setCerTypeDic(BaseDic cerTypeDic) {
		this.cerTypeDic = cerTypeDic;
	}

	public String getCerNum() {
		return cerNum;
	}

	public void setCerNum(String cerNum) {
		this.cerNum = cerNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BaseDic getStatusDic() {
		return statusDic;
	}

	public void setStatusDic(BaseDic statusDic) {
		this.statusDic = statusDic;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public BaseDic getUserTypeDic() {
		return userTypeDic;
	}

	public void setUserTypeDic(BaseDic userTypeDic) {
		this.userTypeDic = userTypeDic;
	}

	public UserLoginInfo getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLoginInfo userLogin) {
		this.userLogin = userLogin;
	}


}
