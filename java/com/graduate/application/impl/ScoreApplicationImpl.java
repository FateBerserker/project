package com.graduate.application.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.ScoreApplication;
/**
 * 
 * @Discription: 成绩
 * @Author: JiangChunLin  
 * @ClassName: ScoreApplicationImpl  
 * @Date: 2019年3月30日 下午5:24:10  
 * @Version: 1.0.0 Graduate
 */
@Component
@Transactional
public class ScoreApplicationImpl implements ScoreApplication{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 查询学生成绩
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.ScoreApplication#findStudentScore(java.lang.String, int, int)
	 */
	@Override
	public List<Map<String, Object>> findStudentScore(String sno, int overNum, int upOrDown) {
		String sql="SELECT\r\n" + 
				"	c.courseName,a.totalScore,c.learnCredit,c.learnHour,\r\n" + 
				"	d.`name`,a.plainScore,a.examScore,b.courseTypeName\r\n" + 
				"FROM\r\n" + 
				"	score a LEFT JOIN teachercourse b on a.teacherCourseUuid=b.uuid\r\n" + 
				"	LEFT JOIN course c on b.courseCode=c.courseCode\r\n" + 
				"	LEFT JOIN teacherinfo d on b.tno=d.tno\r\n" + 
				"WHERE\r\n" + 
				"	a.sno='"+sno+"'\r\n" + 
				"	AND a.upOrDown="+upOrDown+"\r\n" + 
				"	AND a.overNum="+overNum;
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}

}
