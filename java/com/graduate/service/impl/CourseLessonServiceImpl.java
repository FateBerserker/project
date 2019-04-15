package com.graduate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.CourseLessonApplication;
import com.graduate.service.CourseLessonService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 课程
 * @Author: JiangChunLin  
 * @ClassName: CourseLessonServiceImpl  
 * @Date: 2019年3月30日 下午1:57:58  
 * @Version: 1.0.0 Graduate
 */
@Service
public class CourseLessonServiceImpl implements CourseLessonService {
	@Autowired
	private CourseLessonApplication courseLessonApplication;
	/**
	 * 
	 *  @Description: 查询开始上课时间
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.CourseLessonService#findStartLessonDate(int, int)
	 */
	@Override
	public JSONResult findStartLessonDate(int year, int term) {
		String date=courseLessonApplication.findStartLessonDate(year, term);
		if(date!=null){
			return JSONResult.success(date);
		}else{
			return JSONResult.failure("异常");
		}
		
	}
	/**
	 * 
	 *  @Description: 学生课表
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.CourseLessonService#findStudentCourseLessonInfo(java.lang.String, int, int, int)
	 */
	@Override
	public JSONResult findStudentCourseLessonInfo(String sno, int year, int term, int weekth) {
		List<Map<String,Object>> result=courseLessonApplication.findStudentCourseLessonInfo(sno, year, term, weekth);
		if(result!=null&&result.size()>0){
			System.out.println(result);
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("结果为空");
		}
	}
	/**
	 * 
	 *  @Description: 学生课程
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.CourseLessonService#findStudentAllCourse(java.lang.String, int, int)
	 */
	@Override
	public JSONResult findStudentAllCourse(String sno, int year, int term) {
		List<Map<String,Object>> result=courseLessonApplication.findStudentAllCourse(sno, year, term);
		if(result!=null&&result.size()>0){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("结果为空");
		}
	}
	/**
	 * 
	 *  @Description: 教师课表
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.CourseLessonService#findTeacherCourseLessonInfo(java.lang.String, int, int, int)
	 */
	@Override
	public JSONResult findTeacherCourseLessonInfo(String tno, int year, int term, int weekth) {
		List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		try {
			result=courseLessonApplication.findTeacherCourseLessonInfo(tno, year, term, weekth);
			return JSONResult.success(result);
		} catch (Exception e) {
			return JSONResult.failure("查询数据库异常");
		}
	}
	/**
	 * 
	 *  @Description: 教师课程
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.CourseLessonService#findTeacherAllCourse(java.lang.String, int, int)
	 */
	@Override
	public JSONResult findTeacherAllCourse(String tno, int year, int term) {
		List<Map<String,Object>> result=new ArrayList<Map<String,Object>>();
		try {
			result=courseLessonApplication.findTeacherAllCourse(tno, year, term);
			return JSONResult.success(result);
		} catch (Exception e) {
			return JSONResult.failure("查询数据库异常");
		}
	}

}
