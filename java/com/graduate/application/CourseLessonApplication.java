package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * @Discription: 课程信息接口  
 * @Author: JiangChunLin  
 * @ClassName: CourseLessonApplication  
 * @Date: 2019年3月30日 下午1:50:07  
 * @Version: 1.0.0 Graduate
 */
public interface CourseLessonApplication {
	/**
	 *  @Discription: 查询某学期的开始上课时间
	 *  @Author: JiangChunLin
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午7:01:28
	 */
	String findStartLessonDate(int year,int term);
	
	/**
	 *  @Discription: 查询学生的课程信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @return
	 *  @Date: 2019年4月13日下午7:01:44
	 */
	List<Map<String,Object>> findStudentCourseLessonInfo(String sno,int year,int term,int weekth);
	
	/**
	 *  @Discription: 查询学生某学期所学习的课程
	 *  @Author: JiangChunLin
	 *  @param no
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午7:01:56
	 */
	List<Map<String,Object>> findStudentAllCourse(String no,int year,int term);
	/**
	 *  @Discription: 查询教师某学期的课程表信息
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @return
	 *  @Date: 2019年4月13日下午7:02:19
	 */
	List<Map<String,Object>> findTeacherCourseLessonInfo(String tno,int year,int term,int weekth);
	
	/**
	 *  @Discription: 查询教师所教授的课程
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午9:02:58
	 */
	List<Map<String,Object>> findTeacherAllCourse(String tno,int year,int term);
	
}
