package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.service.CourseLessonService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 课程信息   
 * @Author: JiangChunLin  
 * @ClassName: CourseLessonController  
 * @Date: 2019年3月30日 下午2:00:30  
 * @Version: 1.0.0 Graduate
 */
@Controller
@RequestMapping(value="courseLesson")
public class CourseLessonController {
	
	@Autowired
	private CourseLessonService courseLessonService;
	/**
	 * 
	 *  @Discription: 查询开始上课时间
	 *  @Author: JiangChunLin
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年3月30日下午2:01:53
	 */
	@RequestMapping(value="findStartDate")
	@ResponseBody
	public JSONResult findStartDate(int year,int term){
		return courseLessonService.findStartLessonDate(year, term);
	}
	
	
	/**
	 * 
	 *  @Discription: 查询学生的上课课程信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @return
	 *  @Date: 2019年3月30日下午2:33:25
	 */
	@ResponseBody
	@RequestMapping(value="findStudentCourseLessonInfo")
	public JSONResult findStudentCourseLessonInfo(String sno,int year,int term,int weekth){
		return courseLessonService.findStudentCourseLessonInfo(sno, year, term, weekth);
	}
	
	/**
	 * 
	 *  @Discription: 查询学生选择的课程
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year 开课的年份值
	 *  @param term 上半年还是下半年
	 *  @return
	 *  @Date: 2019年3月30日下午10:48:22
	 */
	@ResponseBody
	@RequestMapping(value="findStudentAllCourse")
	public JSONResult findStudentAllCourse(String sno,int year,int term){
		return courseLessonService.findStudentAllCourse(sno, year, term);
	}
	
	/**
	 * 
	 *  @Discription:查询教师的课程表信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @param weekth
	 *  @return
	 *  @Date: 2019年4月4日下午3:05:31
	 */
	@ResponseBody
	@RequestMapping(value="findTeacherCourseLessonInfo")
	public JSONResult findTeacherCourseLessonInfo(String tno,int year,int term,int weekth){
		return courseLessonService.findTeacherCourseLessonInfo(tno, year, term, weekth);
	}
	
	/**
	 * 
	 *  @Discription: 查询教师的教授课程
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year 开课的年份值
	 *  @param term 上半年还是下半年
	 *  @return
	 *  @Date: 2019年3月30日下午10:48:22
	 */
	@ResponseBody
	@RequestMapping(value="findTeacherAllCourse")
	public JSONResult findTeacherAllCourse(String tno,int year,int term){
		return courseLessonService.findTeacherAllCourse(tno, year, term);
	}
	
}
