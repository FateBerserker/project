package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.StudentAttenceInfoApplication;
import com.graduate.entity.StudentAttence;
import com.graduate.service.StudentAttenceInfoService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 学生出勤 
 * @Author: JiangChunLin  
 * @ClassName: StudentAttenceInfoServiceImpl  
 * @Date: 2019年3月31日 下午10:34:39  
 * @Version: 1.0.0 Graduate
 */
@Service
public class StudentAttenceInfoServiceImpl implements StudentAttenceInfoService {
	@Autowired
	private StudentAttenceInfoApplication saia;
	/**
	 * 
	 *  @Description: 查询学生出勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#findStudentAttenceInfo(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public JSONResult findStudentAttenceInfo(String sno, String teacherCourseUuid, int year, int term) {
		List<Map<String,Object>> result= saia.findStudentAttenceInfo(sno, teacherCourseUuid, year, term);
		if(result!=null&&result.size()>0){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("结果为空");
		}
	}
	/**
	 * 
	 *  @Description: 学生缺勤
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#findStudentAbsentInfo(java.lang.String, int, int)
	 */
	@Override
	public JSONResult findStudentAbsentInfo(String sno, int year, int term) {
		List<Map<String,Object>> result=saia.findStudentAbsentInfo(sno, year, term);
		if(result!=null&&result.size()>0){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("结果为空");
		}
	}
	/**
	 * 
	 *  @Description: 批量插入考勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#batchInsertAttenceInfo(java.util.List)
	 */
	@Override
	public JSONResult batchInsertAttenceInfo(List<StudentAttence> params) {
		try {
			saia.batchInsertAttenceInfo(params);
			return JSONResult.success();
		} catch (Exception e) {
			return JSONResult.failure("批量插入考勤信息失败");
		}
	}
	/**
	 *  @Description: 查询是否学生可以WiFi签到
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#queryOpenSign(java.lang.String)
	 */
	@Override
	public JSONResult queryOpenSign(String teacherCourseUuid) {
		try {
			int openSign=saia.queryOpenSign(teacherCourseUuid);
			return JSONResult.success(openSign);
		} catch (Exception e) {
			return JSONResult.success(0);
		}
	}
	/**
	 *  @Description: 打开WiFi签到
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#setOpenSign(java.lang.String)
	 */
	@Override
	public JSONResult setOpenSign(String teacherCourseUuid) {
		try {
			int row=saia.setOpenSign(teacherCourseUuid);
			return JSONResult.success(row);
		} catch (Exception e) {
			return JSONResult.failure("打开WiFi签到失败");
		}
	}
	/**
	 * 
	 *  @Description: 学生签到
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#studentSign(com.graduate.entity.StudentAttence)
	 */
	@Override
	public JSONResult studentSign(StudentAttence studentAttence) {
		try {
			saia.studentSign(studentAttence);
			return JSONResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			return JSONResult.failure("签到异常");
		}
	}
	/**
	 * 
	 *  @Description: 是否已签到
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#hasSigned(com.graduate.entity.StudentAttence)
	 */
	@Override
	public JSONResult hasSigned(StudentAttence studentAttence) {
		try {
			int row=saia.hasSigned(studentAttence);
			if(row==1){
				return JSONResult.success(1);
			}else{
				return JSONResult.success(0);
			}			
		} catch (Exception e) {
			return JSONResult.failure("查询异常");
		}
	}
	/**
	 * 
	 *  @Description:该机器码已签到
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.StudentAttenceInfoService#hasMachineIdSign(com.graduate.entity.StudentAttence)
	 */
	@Override
	public JSONResult hasMachineIdSign(StudentAttence studentAttence) {
		try {
			int row=saia.hasMachineIdSign(studentAttence);
			if(row!=0){
				return JSONResult.success(1);
			}else{
				return JSONResult.success(0);
			}
		} catch (Exception e) {
			return JSONResult.failure("查询异常");
		}
	}

}
