package com.graduate.application;

import java.util.List;
import java.util.Map;

import com.graduate.entity.QueryCondition;

/**
 * 
 * @Discription: 打卡相关的所有功能信息   
 * @Author: JiangChunLin  
 * @ClassName: LessonStudentApplication  
 * @Date: 2019年4月8日 上午11:25:25  
 * @Version: 1.0.0 Graduate
 */
public interface LessonStudentApplication {
	/**
	 *  @Discription: 查询某堂课的学生总人数和课程名称
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @param lessonIndex
	 *  @return
	 *  @Date: 2019年4月8日上午11:28:00
	 */
	public Map<String,Object> findLessonStudentTotalNum(String tno,int year,int term,int weekth,int weekDay,
			int lessonIndex);
	/**
	 *  @Discription: 查询某堂课的所有学生的信息，主要用于方便生成考勤信息
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @param lessonIndex
	 *  @return
	 *  @Date: 2019年4月8日上午11:28:25
	 */
	public List<Map<String,Object>> findLessonAllStudentInfo(String tno,int year,int term,int weekth,
			int weekDay,int lessonIndex);
	/**
	 * 
	 *  @Discription: 查询学生当前时间段的课程信息
	 *  @Author: JiangChunLin
	 *  @param queryCondition
	 *  @return
	 *  @Date: 2019年4月13日下午5:07:42
	 */
	public Map<String, Object> findStudentNowLessonInfo(QueryCondition queryCondition);
}
