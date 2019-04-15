package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Discription: 账号信息处理类   
 * @Author: JiangChunLin  
 * @ClassName: AccountApplication  
 * @Date: 2019年3月29日 下午4:25:03  
 * @Version: 1.0.0 Graduate
 */
public interface AccountApplication {
	/**
	 *  @Discription: 根据账号和密码以及角色查询用户信息不为空则表示登录成功
	 *  @Author: JiangChunLin
	 *  @param tsno
	 *  @param password
	 *  @param role
	 *  @return
	 *  @Date: 2019年3月29日下午4:26:33
	 */
	List<Map<String,Object>> login(String account,String password,int role);
	
	
	/**
	 * 
	 *  @Discription: 更新密码
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param oldPassword
	 *  @param newPassword
	 *  @return
	 *  @Date: 2019年3月29日下午4:32:45
	 */
	boolean updatePassword(String account,String oldPassword,String newPassword);
	/**
	 * 
	 *  @Discription: 查询密码
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @return
	 *  @Date: 2019年3月29日下午4:32:55
	 */
	boolean findPassword(String account,String password);
	
	/**
	 * 
	 *  @Discription: 更新用户信息后返回更新后的用户信息
	 *  @Author: JiangChunLin
	 *  @return
	 *  @Date: 2019年3月29日下午5:28:50
	 */
	int updateUserInfo(String sno,String tel,String email);
	
	/**
	 * 
	 *  @Discription: 查询教师或者学生的信息
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param role
	 *  @return
	 *  @Date: 2019年3月30日上午11:24:49
	 */
	List<Map<String,Object>> findUserInfo(String account,int role);
	
}
