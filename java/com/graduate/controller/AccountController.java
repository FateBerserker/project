package com.graduate.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.service.AccountService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 账号  
 * @Author: JiangChunLin  
 * @ClassName: AccountController  
 * @Date: 2019年3月29日 下午4:23:30  
 * @Version: 1.0.0 Graduate
 */
@Controller
@RequestMapping(value="account")
public class AccountController {
	@Autowired
	private AccountService accountService;
	/**
	 * 
	 *  @Discription: 登录
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param password
	 *  @param role
	 *  @return
	 *  @Date: 2019年3月29日下午5:42:59
	 */
	@ResponseBody
	@RequestMapping(value="login")
	public JSONResult login(String account,String password,int role){
		return accountService.login(account, password, role);
	}
	/**
	 * 
	 *  @Discription: 更新密码
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param newPassword
	 *  @param oldPassword
	 *  @return
	 *  @Date: 2019年3月29日下午5:44:50
	 */
	@ResponseBody
	@RequestMapping(value="updatePassword")
	public JSONResult updatePassword(String account,String newPassword,String oldPassword){
		return accountService.updatePassword(account, oldPassword, newPassword);
	}
	/**
	 * 
	 *  @Discription: 查询账号的密码
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param password
	 *  @return
	 *  @Date: 2019年3月29日下午5:46:13
	 */
	@ResponseBody
	@RequestMapping(value="findPassword")
	public JSONResult findPassword(String sno,String password){
		return accountService.findPassword(sno, password);
	}
	
	
	/**
	 * 
	 *  @Discription: 查询用户信息
	 *  @Author: JiangChunLin
	 *  @param account
	 *  @param role
	 *  @return
	 *  @Date: 2019年3月30日下午5:33:23
	 */
	@ResponseBody
	@RequestMapping(value="findUserInfo")
	public JSONResult findUserInfo(String account,int role){
		return accountService.findUserInfo(account,role);
	}
	
	/**
	 * 
	 *  @Discription: 根据入学年份和当前的年和月查询对应为大几的第几学期
	 *  @Author: JiangChunLin
	 *  @param grade
	 *  @param nowYear
	 *  @param month 从0开始
	 *  @return
	 *  @Date: 2019年3月30日下午5:34:23
	 */
	@ResponseBody
	@RequestMapping(value="currentOverAndTerm")
	public JSONResult currentOverAndTerm(int grade,int nowYear,int month){
		Map<String,Object> map=new HashMap<>();
		if(grade==nowYear){
			map.put("overNum", 1);
			map.put("upOrDown", 0);
		}else{
			if(month>1&&month<8){
				map.put("overNum", nowYear-grade);
				map.put("upOrDown", 1);
			}else{
				map.put("overNum", nowYear-grade+1);
				map.put("upOrDown", 0);
			}
		}
		return JSONResult.success(map);
	}
	
	/**
	 * 
	 *  @Discription: 更新用户信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param tel
	 *  @param name
	 *  @return
	 *  @Date: 2019年4月3日下午5:29:47
	 */
	@ResponseBody
	@RequestMapping(value="updateInfo")
	public JSONResult updateInfo(String sno,String tel,String email){
		return accountService.updateUserInfo(sno, tel, email);
	}
	
}
