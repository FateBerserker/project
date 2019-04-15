package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduate.entity.QueryCondition;
import com.graduate.entity.StudentAttence;
import com.graduate.service.LessonStudentService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: LessonStudentController  
 * @Date: 2019年4月8日 上午11:40:28  
 * @Version: 1.0.0 Graduate
 */
@RestController
@RequestMapping(value="attence")
public class LessonStudentController {
	@Autowired
	private LessonStudentService lessonStudentService;
	/**
	 *  @Discription: 查询课程的学生人数和课程名字
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @param weekDay
	 *  @param lessonIndex
	 *  @return
	 *  @Date: 2019年4月8日上午11:42:33
	 */
	@RequestMapping(value="findLessonStudentTotalNum")
	public JSONResult findLessonStudentTotalNum(String tno, int year, int term, int weekth,
			int weekDay ,int lessonIndex){
		return lessonStudentService.findLessonStudentTotalNum(tno, year, term, weekth, weekDay, lessonIndex);
	}
	/**
	 *  @Discription: 查询某堂课的所有学生信息
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @param weekDay
	 *  @param lessonIndex
	 *  @return
	 *  @Date: 2019年4月8日上午11:42:50
	 */
	@RequestMapping(value="findLessonAllStudentInfo")
	public JSONResult findLessonAllStudentInfo(String tno, Integer term, Integer weekth,Integer year, 
			Integer weekDay ,Integer lessonIndex){
		System.out.println(tno+"  "+year+"  "+term+"  "+weekth+"   "+weekDay+"  "+lessonIndex);
		return lessonStudentService.findLessonAllStudentInfo(tno, year, term, weekth, weekDay, lessonIndex);
	}
	
	/**
	 * 
	 *  @Discription: 查询学生的某个时间段的课程信息
	 *  @Author: JiangChunLin
	 *  @param queryCondition
	 *  @return
	 *  @Date: 2019年4月13日下午5:28:29
	 */
	@RequestMapping(value="findStudentNowLessonInfo")
	public JSONResult findStudentNowLessonInfo(QueryCondition queryCondition){
		System.out.println(queryCondition);
		return lessonStudentService.findStudentNowLessonInfo(queryCondition);
	}
	
}
