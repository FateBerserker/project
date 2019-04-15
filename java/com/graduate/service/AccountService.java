package com.graduate.service;

import java.util.List;
import java.util.Map;

import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription:账号信息   
 * @Author: JiangChunLin  
 * @ClassName: AccountService  
 * @Date: 2019年3月29日 下午4:22:01  
 * @Version: 1.0.0 Graduate
 */
public interface AccountService {
	/**
	 *  @Discription: 密码更新
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param oldPassword
	 *  @param newPassword
	 *  @return
	 *  @Date: 2019年4月13日下午5:39:40
	 */
	JSONResult updatePassword(String account,String oldPassword,String newPassword);
	/**
	 * 
	 *  @Discription: 查询密码是否匹配
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param password
	 *  @return
	 *  @Date: 2019年4月13日下午5:39:52
	 */
	JSONResult findPassword(String account,String password);
	/**
	 * 
	 *  @Discription: 登录
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param password
	 *  @param role
	 *  @return
	 *  @Date: 2019年4月13日下午5:40:07
	 */
	JSONResult login(String account,String password,int role);
	/**
	 * 
	 *  @Discription: 更新用户信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param tel
	 *  @param email
	 *  @return
	 *  @Date: 2019年4月13日下午5:40:15
	 */
	JSONResult updateUserInfo(String sno,String tel,String email);
	/**
	 * 
	 *  @Discription: 查询用户信息
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param role
	 *  @return
	 *  @Date: 2019年4月13日下午5:40:28
	 */
	JSONResult findUserInfo(String account, int role);
}
