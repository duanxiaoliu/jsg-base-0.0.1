package com.jsg.base.service;

import com.jsg.base.model.BasePage;
import com.jsg.base.model.UserInfo;
import com.jsg.base.model.UserLoginInfo;
/**
 * 
* @ClassName: IUserService 
* @Description: TODO(用户信息处理，包含登录操作) 
* @author duanws
* @date 2016-5-6 下午2:33:04 
*
 */
public interface IUserService extends IBaseService{
	/**
	 * 
	* @Title: queryUserInfo 
	* @Description: TODO(分页查询用户信息) 
	* @param @param pageNo
	* @param @param pageSize
	* @param @param user
	* @param @return
	* @return BasePage
	* @throws 
	* @author duanws
	* @date 2016-6-20 下午3:21:48
	 */
	BasePage queryUserInfo(int pageNo,int pageSize,UserInfo user);
	/**
	 * 
	* @Title: getUserInfo 
	* @Description: TODO(通过用户信息查询用户) 
	* @param @param userInfo
	* @param @return
	* @return UserInfo
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:28:45
	 */
	UserInfo getUserInfo(UserInfo userInfo);
	/**
	 * 
	* @Title: saveUserInfo 
	* @Description: TODO(保存用户信息) 
	* @param @param userInfo
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:30:46
	 */
	void saveUserInfo(UserInfo userInfo);
	/**
	 * 
	* @Title: updateUserInfo 
	* @Description: TODO(更新用户信息) 
	* @param @param userInfo
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:31:04
	 */
	void updateUserInfo(UserInfo userInfo);
	/**
	 * 
	* @Title: deleteUserInfo 
	* @Description: TODO(删除用户信息) 
	* @param @param userInfo
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:31:19
	 */
	void deleteUserInfo(UserInfo userInfo);
	/**
	 * 
	* @Title: deleteUserInfoById 
	* @Description: TODO(通过id删除用户信息) 
	* @param @param id
	* @return void
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:31:31
	 */
	void deleteUserInfoById(String id);
	/**
	 * 
	* @Title: getUserInfoById 
	* @Description: TODO(通过id查询用户信息) 
	* @param @param id
	* @param @return
	* @return UserInfo
	* @throws 
	* @author duanws
	* @date 2016-5-6 下午2:31:46
	 */
	UserInfo getUserInfoById(String id);
	/**
	 * 
	* @Title: saveUserLoginInfo 
	* @Description: TODO(保存用户登录信息) 
	* @param @param loginInfo 
	* @return void
	* @author duanws
	* @throws
	 */
	void saveUserLoginInfo(UserLoginInfo loginInfo);
	/**
	 * 
	* @Title: isExistUser 
	* @Description: TODO(通过证件号码检验用户是否唯一) 
	* @param @param id
	* @param @param cerNum
	* @param @return
	* @return boolean
	* @throws 
	* @author duanws
	* @date 2016-6-21 下午2:57:39
	 */
	boolean isExistUser(String id,String cerNum);
}
