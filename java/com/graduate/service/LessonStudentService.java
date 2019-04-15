package com.graduate.service;

import com.graduate.entity.QueryCondition;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 学生课程    
 * @Author: JiangChunLin  
 * @ClassName: LessonStudentService  
 * @Date: 2019年4月8日 上午11:36:08  
 * @Version: 1.0.0 Graduate
 */
public interface LessonStudentService {
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
	JSONResult findLessonStudentTotalNum(String tno,int year,int term,int weekth,int weekDay,
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
	JSONResult findLessonAllStudentInfo(String tno,int year,int term,int weekth,
			int weekDay,int lessonIndex);
	/**
	 * 
	 *  @Discription: 某个时间段的课程信息
	 *  @Author: JiangChunLin
	 *  @param queryCondition
	 *  @return
	 *  @Date: 2019年4月13日下午5:43:49
	 */
	JSONResult findStudentNowLessonInfo(QueryCondition queryCondition);
}
