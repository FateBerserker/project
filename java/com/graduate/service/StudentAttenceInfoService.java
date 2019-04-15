package com.graduate.service;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: StudentAttenceInfoService  
 * @Date: 2019年3月31日 下午10:33:51  
 * @Version: 1.0.0 Graduate
 */

import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import com.graduate.entity.StudentAttence;
import com.graduate.utils.JSONResult;

public interface StudentAttenceInfoService {
	JSONResult findStudentAttenceInfo(String sno,String teacherCourseUuid,int year,int term);
	JSONResult findStudentAbsentInfo(String sno,int year,int term);
	JSONResult batchInsertAttenceInfo(List<StudentAttence> params);
	JSONResult queryOpenSign(String teacherCourseUuid);
	JSONResult setOpenSign(String teacherCourseUuid);
	JSONResult studentSign(StudentAttence studentAttence);
	JSONResult hasSigned(StudentAttence studentAttence);
	JSONResult hasMachineIdSign(StudentAttence studentAttence);
}
