package com.graduate.application.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.AccountApplication;
/**
 * 
 * @Discription: 实现层   
 * @Author: JiangChunLin  
 * @ClassName: AccountApplicationImpl  
 * @Date: 2019年3月29日 下午4:33:13  
 * @Version: 1.0.0 Graduate
 */
@Component
@Transactional
public class AccountApplicationImpl implements AccountApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 登录
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AccountApplication#login(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Map<String, Object>> login(String account, String password, int role) {
		String sql="";
		if(role==1){
			sql="SELECT \r\n" + 
					"	b.sno,b.sex,b.`name`,b.grade,b.academic,b.major,b.tel,b.email,b.lenOfSchool \r\n" + 
					"FROM \r\n" + 
					"	account a \r\n" + 
					"	LEFT JOIN studentinfo b on a.account=b.sno \r\n" + 
					"WHERE \r\n" + 
					"	a.disabled=0 \r\n" + 
					"	AND a.role=1 \r\n" + 
					"	AND a.account='"+account+"' \r\n" + 
					"	AND a.`password`=md5('"+password+"')";
		}else if(role==0){
			sql="SELECT \r\n" + 
					"	t.tno,t.tel,t.sex,t.position,t.`name`,t.email,t.educationLevel\r\n" + 
					"FROM \r\n" + 
					"	account a \r\n" + 
					"	LEFT JOIN teacherinfo t on a.account=t.tno \r\n" + 
					"WHERE \r\n" + 
					"	a.disabled=0 \r\n" + 
					"	AND a.role=0 \r\n" + 
					"	AND a.account='"+account+"' \r\n" + 
					"	AND a.`password`=MD5('"+password+"')";
		}
		try {
			List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
			return result;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 
	 *  @Description: 更新密码
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AccountApplication#updatePassword(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updatePassword(String account, String oldPassword, String newPassword) {
		String sql="UPDATE  account  a SET  a.password=md5('"+newPassword+"') "
				+ "WHERE "
				+ "a.password=md5('"+oldPassword+"') AND a.account='"+account+"'";
		int row=jdbcTemplate.update(sql);
		return row==1?true:false;
	}
	/**
	 * 
	 *  @Description: 查询密码
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AccountApplication#findPassword(java.lang.String)
	 */
	@Override
	public boolean findPassword(String account,String password) {
		String sql="SELECT count(1) row FROM account a "
				+ "WHERE a.account='"+account+"' AND a.`password`=MD5('"+password+"')";
		int row=jdbcTemplate.queryForObject(sql, int.class);
		return row==1?true:false;
	}
	/**
	 * 
	 *  @Description: 更新电话和邮箱地址
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AccountApplication#updateUserInfo()
	 */
	@Override
	public int  updateUserInfo(String sno,String tel,String email) {
		String sql="update studentinfo set tel='"+tel+"',email='"+email+"' where sno='"+sno+"' ";
		int row=jdbcTemplate.update(sql);
		return row;
	}
	/**
	 * 
	 *  @Description: 查询学生或者教师的信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AccountApplication#findUserInfo(java.lang.String, int)
	 */
	@Override
	public List<Map<String, Object>> findUserInfo(String account, int role) {
		String sql="";
		if(role==1){
			sql="SELECT \r\n" + 
					"	b.sno,b.sex,b.`name`,b.grade,b.academic,b.major,b.tel,b.email \r\n" + 
					"FROM \r\n" + 
					"	account a \r\n" + 
					"	LEFT JOIN studentinfo b on a.account=b.sno \r\n" + 
					"WHERE \r\n" + 
					"	a.disabled=0 \r\n" + 
					"	AND a.role=1 \r\n" + 
					"	AND a.account='"+account+"' ";
		}else{
			sql="SELECT \r\n" + 
					"	t.tno,t.tel,t.sex,t.position,t.`name`,t.email,t.educationLevel\r\n" + 
					"FROM \r\n" + 
					"	account a \r\n" + 
					"	LEFT JOIN teacherinfo t on a.account=t.tno \r\n" + 
					"WHERE \r\n" + 
					"	a.disabled=0 \r\n" + 
					"	AND a.role=0 \r\n" + 
					"	AND a.account='"+account+"'";
		}
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	
	
	
	
}
