package com.graduate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.graduate.entity.StudentAttence;
import com.graduate.service.StudentAttenceInfoService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 学生出勤信息
 * @Author: JiangChunLin  
 * @ClassName: StudentAttenceInfoController  
 * @Date: 2019年3月31日 下午10:33:16  
 * @Version: 1.0.0 Graduate
 */
@RestController
public class StudentAttenceInfoController {
	@Autowired
	private StudentAttenceInfoService sais;
	/**
	 * 
	 *  @Discription: 查询学生出勤信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param teacherCourseUuid
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年3月31日下午10:37:44
	 */
	@RequestMapping(value="findStudentAttenceInfo")
	public JSONResult findStudentAttenceInfo(String sno,String teacherCourseUuid,int year,int term){
		System.out.println(sno+" -> "+teacherCourseUuid+"   ->  "+year+"  ->  "+term);
		return sais.findStudentAttenceInfo(sno, teacherCourseUuid, year, term);
	}
	/**
	 * 
	 *  @Discription: 查询学生缺勤信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:29:37
	 */
	@RequestMapping(value="findStudentAbsentInfo")
	public JSONResult findStudentAbsentInfo(String sno,int year,int term){
		return sais.findStudentAbsentInfo(sno, year, term);
	}
	
	/**
	 * 
	 *  @Discription: 批量插入学生出勤信息
	 *  @Author: JiangChunLin
	 *  @param param
	 *  @return
	 *  @Date: 2019年4月13日下午5:29:51
	 */
	@RequestMapping(value="batchInsertAttenceInfo")
	public JSONResult batchInsertAttenceInfo(String  param){
		List<StudentAttence> studentAttences=JSON.parseArray(param, StudentAttence.class);
		System.out.println(studentAttences);
		return sais.batchInsertAttenceInfo(studentAttences);
	}
	
	/**
	 *  @Discription: 学生WiFi签到
	 *  @Author: JiangChunLin
	 *  @param param
	 *  @return
	 *  @Date: 2019年4月11日下午5:34:53
	 */
	@RequestMapping(value="studentSign")
	public JSONResult studentSign(String param){
		StudentAttence studentAttence=JSON.parseObject(param, StudentAttence.class);
		System.out.println(studentAttence);
		return sais.studentSign(studentAttence);
	}
	
//	@RequestMapping(value="queryOpenSign")
//	public JSONResult queryOpenSign(String teacherCourseUuid){
//		return sais.queryOpenSign(teacherCourseUuid);
//	}
	
	/**
	 *  @Discription: 教师开启学生签到
	 *  @Author: JiangChunLin
	 *  @param teacherCourseUuid
	 *  @return
	 *  @Date: 2019年4月11日下午5:34:35
	 */
	@RequestMapping(value="openOpenSign")
	public JSONResult openOpenSign(String teacherCourseUuid){
		return sais.setOpenSign(teacherCourseUuid);
	}
	/**
	 * 
	 *  @Discription: 是否该课程已签到
	 *  @Author: JiangChunLin
	 *  @param param
	 *  @return
	 *  @Date: 2019年4月13日下午5:30:10
	 */
	@RequestMapping(value="hasSigned")
	public JSONResult hasSigned(String param){
		StudentAttence studentAttence=JSON.parseObject(param, StudentAttence.class);
		System.out.println(studentAttence);
		return sais.hasSigned(studentAttence);
	}
	
	
	/**
	 *  @Discription: 是否该机器码已签到过
	 *  @Author: JiangChunLin
	 *  @param studentAttence
	 *  @return
	 *  @Date: 2019年4月11日下午5:45:06
	 */
	@RequestMapping(value="hasMachineIdSign")
	public JSONResult hasMachineIdSign(String param){
		StudentAttence studentAttence=JSON.parseObject(param, StudentAttence.class);
		System.out.println(studentAttence);
		return sais.hasMachineIdSign(studentAttence);
	}
	
	
}
