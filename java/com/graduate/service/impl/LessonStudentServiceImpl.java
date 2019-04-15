package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.LessonStudentApplication;
import com.graduate.entity.QueryCondition;
import com.graduate.service.LessonStudentService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 学生课表 
 * @Author: JiangChunLin  
 * @ClassName: LessonStudentServiceImpl  
 * @Date: 2019年4月8日 上午11:37:08  
 * @Version: 1.0.0 Graduate
 */
@Service
public class LessonStudentServiceImpl implements LessonStudentService {
	@Autowired
	private LessonStudentApplication lessonStudentApplication;
	/**
	 * 
	 *  @Description: 查询课程人数
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.LessonStudentService#findLessonStudentTotalNum(java.lang.String, int, int, int, int, int)
	 */
	@Override
	public JSONResult findLessonStudentTotalNum(String tno, int year, int term, int weekth, int weekDay,
			int lessonIndex) {
		try {
			Map<String,Object> result=lessonStudentApplication.findLessonStudentTotalNum(tno, year, term, weekth, weekDay, lessonIndex);
			return JSONResult.success(result);
		} catch (Exception e) {
			return JSONResult.failure("数据异常或者不在上课时间段内");
		}
	}
	/**'
	 * 
	 *  @Description: 查询课程的学生信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.LessonStudentService#findLessonAllStudentInfo(java.lang.String, int, int, int, int, int)
	 */
	@Override
	public JSONResult findLessonAllStudentInfo(String tno, int year, int term, int weekth, int weekDay,
			int lessonIndex) {
		try {
			List<Map<String,Object>> result=lessonStudentApplication.findLessonAllStudentInfo(tno, year, term, weekth, weekDay, lessonIndex);
			return JSONResult.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return JSONResult.failure("数据异常或者不在上课时间段内");
		}
	}
	/**
	 * 
	 *  @Description: 查询某个时间段的课程信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.LessonStudentService#findStudentNowLessonInfo(com.graduate.entity.QueryCondition)
	 */
	@Override
	public JSONResult findStudentNowLessonInfo(QueryCondition queryCondition) {
		try {
			Map<String,Object> result=lessonStudentApplication.findStudentNowLessonInfo(queryCondition);
			return JSONResult.success(result);
		} catch (Exception e) {
			// TODO: handle exception
			return JSONResult.failure("数据查询异常");
		}
	}

}
