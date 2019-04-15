package com.graduate.application.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.DoubtApplication;
import com.graduate.utils.StringUtils;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: DoubtApplicationImpl  
 * @Date: 2019年3月31日 下午3:50:53  
 * @Version: 1.0.0 Graduate
 */
@Component
@Transactional
public class DoubtApplicationImpl implements DoubtApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 插入一条记录
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.DoubtApplication#insertDoubt(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int insertDoubt(String sno, String teacherCourseUuid, String content, String imagesUrl, String courseName) {
		String uuid=StringUtils.uuid(32);
		String date=StringUtils.dateToYMDHMS(new Date());
		String sql="INSERT INTO doubt "
				+ "VALUES('"+uuid+"','"+sno+"','"+teacherCourseUuid+"','"+date+"','"+content+"','"+imagesUrl+"',0,'"+courseName+"')";
		int row=jdbcTemplate.update(sql);
		return row;
	}
	/**
	 * 
	 *  @Description: 查询课程问题
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.DoubtApplication#findAllDoubt(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> findAllDoubt(String teacherCourseUuids) {
		System.out.println(teacherCourseUuids);
		String sql="SELECT \r\n" + 
				"	a.uuid,DATE_FORMAT(a.releaseTime,'%Y/%m/%d %H:%i:%s') releaseTime,a.imagesUrl,a.content,b.sno,b.sex,b.`name`,a.courseName,a.markNumber\r\n" + 
				"FROM\r\n" + 
				"	doubt a \r\n" + 
				"	LEFT JOIN studentinfo b on a.sno=b.sno\r\n" + 
				"WHERE\r\n" + 
				"	a.teacherCourseUuid in "+teacherCourseUuids+
				"   ORDER BY a.releaseTime DESC";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	/**
	 * 
	 *  @Description: 更新回复总数
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.DoubtApplication#updateMarkNumber(java.lang.String)
	 */
	@Override
	public int updateMarkNumber(String doubtUuid) {
		String sql="UPDATE doubt SET markNumber=markNumber+1 WHERE uuid='"+doubtUuid+"'";
		int row=jdbcTemplate.update(sql);
		return row;
	}

}
