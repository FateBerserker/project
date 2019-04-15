package com.graduate.service;

import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 课程    
 * @Author: JiangChunLin  
 * @ClassName: CourseLessonService  
 * @Date: 2019年3月30日 下午1:57:20  
 * @Version: 1.0.0 Graduate
 */
public interface CourseLessonService {
	/**
	 *  @Discription: 查询上课时间
	 *  @Author: JiangChunLin
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:40:47
	 */
	JSONResult findStartLessonDate(int year,int term);
	/**
	 * 
	 *  @Discription: 查询学生所有课程表信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @return
	 *  @Date: 2019年4月13日下午5:41:01
	 */
	JSONResult findStudentCourseLessonInfo(String sno,int year,int term,int weekth);
	/**
	 * 
	 *  @Discription: 查询学生课程
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:41:16
	 */
	JSONResult findStudentAllCourse(String sno,int year,int term);
	/**
	 * 
	 *  @Discription: 查询教师课表信息
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @return
	 *  @Date: 2019年4月13日下午5:41:36
	 */
	JSONResult findTeacherCourseLessonInfo(String tno,int year,int term,int weekth);
	/**
	 * 
	 *  @Discription: 查询教师课程
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:41:49
	 */
	JSONResult findTeacherAllCourse(String tno,int year,int term);
}
