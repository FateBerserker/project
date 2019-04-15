package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.graduate.application.AccountApplication;
import com.graduate.service.AccountService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 账号 
 * @Author: JiangChunLin  
 * @ClassName: AccountServiceImpl  
 * @Date: 2019年3月29日 下午4:22:53  
 * @Version: 1.0.0 Graduate
 */
@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountApplication accountApplication;
	/**
	 * 
	 *  @Description: 更新密码
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AccountService#updatePassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONResult updatePassword(String account, String oldPassword, String newPassword) {
		if(StringUtils.hasLength(account)
				&&StringUtils.hasLength(newPassword)
				&&StringUtils.hasLength(oldPassword)){
			boolean flag=accountApplication.updatePassword(account, oldPassword, newPassword);
			if(flag){
				return JSONResult.success();
			}else{
				return JSONResult.failure("更新失败");
			}
		}else{
			return JSONResult.failure("字段存在不合法的值");
		}
	}
	/**
	 * 
	 *  @Description: 密码匹配
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AccountService#findPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public JSONResult findPassword(String account, String password) {
		boolean flag=accountApplication.findPassword(account, password);
		if(flag){
			return JSONResult.success();
		}else{
			return JSONResult.failure("");
		}
		
	}

	/**
	 * 
	 *  @Description: 登录
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AccountService#login(java.lang.String, java.lang.String, int)
	 */
	@Override
	public JSONResult login(String account, String password, int role) {
		List<Map<String,Object>> result=accountApplication.login(account, password, role);
		if(result!=null&&result.size()==1){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("查询失败");
		}
		
	}
	
	/**
	 * 
	 *  @Description: 更新用户信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AccountService#updateUserInfo()
	 */
	@Override
	public JSONResult updateUserInfo(String sno,String tel,String email) {
		try {
			accountApplication.updateUserInfo(sno, tel, email);
			return JSONResult.success();
		} catch (Exception e) {
			return JSONResult.failure("更新用户信息异常");
		}
	}
	/**
	 * 
	 *  @Description: 查询用户信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AccountService#findUserInfo(java.lang.String, int)
	 */
	@Override
	public JSONResult findUserInfo(String account, int role) {
		if(StringUtils.hasLength(account)&&(role==1||role==0)){
			List<Map<String,Object>> result=accountApplication.findUserInfo(account, role);
			if(result!=null&&result.size()==1){
				return JSONResult.success(result);
			}else{
				return JSONResult.failure("查询异常");
			}
		}
		return JSONResult.failure("参数不正确");
	}
	
}
