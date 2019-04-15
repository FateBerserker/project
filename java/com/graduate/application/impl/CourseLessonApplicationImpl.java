package com.graduate.application.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.CourseLessonApplication;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: CourseLessonApplicationImpl  
 * @Date: 2019年3月30日 下午1:51:46  
 * @Version: 1.0.0 Graduate
 */
@Component
@Transactional
public class CourseLessonApplicationImpl implements CourseLessonApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 查询开学时间
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.CourseLessonApplication#findStartLessonDate(int, int)
	 */
	@Override
	public String findStartLessonDate(int year, int term) {
		String sql="SELECT DATE_FORMAT(MIN(a.startDate),'%Y-%m-%d') startDate FROM teachercourse  a "
				+ "WHERE  a.`year`="+year+" AND a.term="+term;
		String startDate=jdbcTemplate.queryForObject(sql, String.class);
		return startDate;
	}
	/**
	 * 
	 *  @Description: 查询学生课表信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.CourseLessonApplication#findStudentCourseLessonInfo(java.lang.String, int, int, int)
	 */
	@Override
	public List<Map<String, Object>> findStudentCourseLessonInfo(String sno, int year, int term, int weekth) {
		String sql="SELECT \r\n" + 
				"d.courseName,b.location,b.weekDay,b.lessonIndex,b.size\r\n" + 
				"FROM teachercourse a LEFT JOIN teacherlesson b on a.uuid=b.teacherCourseUuid\r\n" + 
				"LEFT JOIN studentlesson c on c.teacherCourseUuid=a.uuid\r\n" + 
				"LEFT JOIN course d on a.courseCode=d.courseCode\r\n" + 
				"WHERE c.sno='"+sno+"'\r\n" + 
				"AND a.`year`="+year+" AND a.term="+term+"\r\n" + 
				"AND "+weekth+" BETWEEN a.weekMin AND a.weekMax\r\n" + 
				"ORDER BY b.weekDay,b.lessonIndex";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	@Override
	public List<Map<String, Object>> findStudentAllCourse(String sno, int year, int term) {
		String sql="SELECT a.uuid,c.courseName,c.courseCode\r\n" + 
				"FROM teachercourse a LEFT JOIN studentlesson b on a.uuid=b.teacherCourseUuid\r\n" + 
				"LEFT JOIN course c on a.courseCode=c.courseCode\r\n" + 
				"WHERE a.`year`="+year+" AND a.term="+term+"\r\n" + 
				"AND b.sno='"+sno+"'";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	/**
	 * 
	 *  @Description: 查询教师的课表信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.CourseLessonApplication#findTeacherCourseLessonInfo(java.lang.String, int, int, int)
	 */
	@Override
	public List<Map<String, Object>> findTeacherCourseLessonInfo(String tno, int year, int term, int weekth) {
		String sql="SELECT \r\n" + 
				"d.courseName,b.location,b.weekDay,b.lessonIndex,b.size,a.className \r\n" + 
				"FROM teachercourse a LEFT JOIN teacherlesson b on a.uuid=b.teacherCourseUuid\r\n" + 
				"LEFT JOIN course d on a.courseCode=d.courseCode\r\n" + 
				"WHERE a.tno='"+tno+"'\r\n" + 
				"AND a.`year`="+year+" AND a.term="+term+"\r\n" + 
				"AND "+weekth+" BETWEEN a.weekMin AND a.weekMax\r\n" + 
				"ORDER BY b.weekDay,b.lessonIndex";
		List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	/**
	 * 
	 *  @Description: 查询教师所教授的所有课信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.CourseLessonApplication#findTeacherAllCourse(java.lang.String, int, int)
	 */
	@Override
	public List<Map<String, Object>> findTeacherAllCourse(String tno, int year, int term) {
		String sql="SELECT	\r\n" + 
				"	a.uuid ,b.courseName\r\n" + 
				"FROM teachercourse a LEFT JOIN course b on a.courseCode=b.courseCode	\r\n" + 
				"WHERE a.tno='"+tno+"' AND a.`year`="+year+" AND a.term="+term;
		List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}

}
