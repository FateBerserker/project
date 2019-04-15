package com.graduate.application;

import java.util.List;
import java.util.Map;

import com.graduate.entity.StudentAttence;

/**
 * 
 * @Discription: 学生出勤信息管理   
 * @Author: JiangChunLin  
 * @ClassName: StudentAttenceInfoApplication  
 * @Date: 2019年3月31日 下午10:29:44  
 * @Version: 1.0.0 Graduate
 */
public interface StudentAttenceInfoApplication {
	/**
	 *  @Discription: 查询学生出勤信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param teacherCourseUuid
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:13:10
	 */
	List<Map<String,Object>> findStudentAttenceInfo(String sno,
			String teacherCourseUuid,int year,int term);
	/**
	 *  @Discription: 查询学生缺勤信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:13:25
	 */
	List<Map<String,Object>> findStudentAbsentInfo(String sno,int year,int term);
	/**
	 *  @Discription: 更新学生出勤信息的状态
	 *  @Author: JiangChunLin
	 *  @param attenceInfoUuid
	 *  @param type
	 *  @return
	 *  @Date: 2019年4月13日下午5:13:40
	 */
	int updateStudentAttenceInfoStatus(String attenceInfoUuid,int type);
	/**
	 *  @Discription: 批量插入学生出勤信息
	 *  @Author: JiangChunLin
	 *  @param params
	 *  @return
	 *  @Date: 2019年4月13日下午5:14:00
	 */
	int batchInsertAttenceInfo(List<StudentAttence> params);
	/**
	 *  @Discription: 查询课程的WiFi开启状态
	 *  @Author: JiangChunLin
	 *  @param teacherCourseUuid
	 *  @return
	 *  @Date: 2019年4月13日下午5:14:20
	 */
	int queryOpenSign(String teacherCourseUuid);
	/**
	 *  @Discription: 打开WiFi签到
	 *  @Author: JiangChunLin
	 *  @param teacherCourseUuid
	 *  @return
	 *  @Date: 2019年4月13日下午5:14:40
	 */
	int setOpenSign(String teacherCourseUuid);
	/**
	 *  @Discription:学生签到
	 *  @Author: JiangChunLin
	 *  @param studentAttence
	 *  @Date: 2019年4月13日下午5:14:55
	 */
	void studentSign(StudentAttence studentAttence);
	/**
	 *  @Discription: 判断某节课程学生是否已签到
	 *  @Author: JiangChunLin
	 *  @param studentAttence
	 *  @return
	 *  @Date: 2019年4月11日下午5:35:41
	 */
	int hasSigned(StudentAttence studentAttence);
	/**
	 *  @Discription: 判断某节课程是否已有对应的机器码签到过，则不能再次替别人签到
	 *  @Author: JiangChunLin
	 *  @param studentAttence
	 *  @return
	 *  @Date: 2019年4月11日下午5:36:22
	 */
	int hasMachineIdSign(StudentAttence studentAttence);
	
	
}
