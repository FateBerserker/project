package com.graduate.application.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.LessonStudentApplication;
import com.graduate.entity.QueryCondition;
/**
 * 
 * @Discription: 学生课程    
 * @Author: JiangChunLin  
 * @ClassName: LessonStudentApplicationImpl  
 * @Date: 2019年4月13日 下午5:19:07  
 * @Version: 1.0.0 Graduate
 */
@Transactional
@Component
public class LessonStudentApplicationImpl implements LessonStudentApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 查询上课的学生人数
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.LessonStudentApplication#findLessonStudentTotalNum(java.lang.String, int, int, int, int, int)
	 */
	@Override
	public Map<String, Object> findLessonStudentTotalNum(String tno, int year, int term, int weekth,int weekDay,
			int lessonIndex) {
		String sql="SELECT \r\n" + 
				"	a.studentNum,b.courseName,c.teacherCourseUuid \r\n" + 
				"FROM \r\n" + 
				"teachercourse a LEFT JOIN \r\n" + 
				"course b on a.courseCode=b.courseCode\r\n" + 
				"LEFT JOIN teacherlesson c on a.uuid=c.teacherCourseUuid	  \r\n" + 
				"WHERE \r\n" + 
				"			c.weekDay="+weekDay+"\r\n" + 
				"			AND "+weekth+" BETWEEN a.weekMin AND a.weekMax\r\n" + 
				"			AND a.tno='"+tno+"'\r\n" + 
				"			AND c.lessonIndex="+lessonIndex+"\r\n" + 
				"			AND a.`year`="+year+"\r\n" + 
				"			AND a.term="+term;
		Map<String, Object> result=jdbcTemplate.queryForMap(sql);
		return result;
	}
	
	/**
	 *  @Description: 查询课程下的学生信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.LessonStudentApplication#findLessonAllStudentInfo(java.lang.String, int, int, int, int, int)
	 */
	@Override
	public List<Map<String, Object>> findLessonAllStudentInfo(String tno, int year, int term, int weekth,
			int weekDay ,int lessonIndex) {
		String sql="SELECT \r\n" + 
				"	d.sno,d.name,d.grade,d.major,d.classth,d.sex\r\n" + 
				"FROM\r\n" + 
				"	teachercourse a LEFT JOIN teacherlesson b on a.uuid=b.teacherCourseUuid\r\n" + 
				"	LEFT JOIN studentlesson c on a.uuid=c.teacherCourseUuid\r\n" + 
				"	LEFT JOIN studentinfo d on c.sno=d.sno\r\n" + 
				"WHERE \r\n" + 
				"	a.`year`="+year+"\r\n" + 
				"	AND a.term="+term+"\r\n" + 
				"	AND a.tno='"+tno+"'\r\n" + 
				"	AND b.weekDay="+weekDay+"\r\n" + 
				"	AND b.lessonIndex="+lessonIndex+"\r\n" + 
				"	AND "+weekth+" BETWEEN a.weekMin AND a.weekMax";
		List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	
	/**
	 *  @Description: 查询某个时间段的学生课程信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.LessonStudentApplication#findStudentNowLessonInfo(com.graduate.entity.QueryCondition)
	 */
	@Override
	public Map<String, Object> findStudentNowLessonInfo(QueryCondition queryCondition) {
		String sql="SELECT \r\n" + 
				"	d.courseName,a.uuid,e.`name`,a.openSign\r\n" + 
				"FROM\r\n" + 
				"	teachercourse a LEFT JOIN teacherlesson b on a.uuid=b.teacherCourseUuid\r\n" + 
				"	LEFT JOIN studentlesson c on c.teacherCourseUuid=a.uuid\r\n" + 
				"	LEFT JOIN course d on a.courseCode=d.courseCode\r\n" + 
				"	LEFT JOIN studentinfo e on e.sno=c.sno\r\n" + 
				"WHERE\r\n" + 
				"	a.`year`="+queryCondition.getYear()+"\r\n" + 
				"	AND a.term="+queryCondition.getTerm()+"\r\n" + 
				"	AND "+queryCondition.getWeekth()+" BETWEEN a.weekMin AND a.weekMax\r\n" + 
				"	AND c.sno='"+queryCondition.getSno()+"'\r\n" + 
				"	AND b.weekDay="+queryCondition.getWeekDay()+"\r\n" + 
				"	AND b.lessonIndex="+queryCondition.getLessonIndex();
		Map<String,Object> result=jdbcTemplate.queryForMap(sql);
		return result;
	}

}
