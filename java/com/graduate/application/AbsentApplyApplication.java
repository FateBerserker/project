package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Discription: 缺勤处理接口  
 * @Author: JiangChunLin  
 * @ClassName: AbsentApplyApplication  
 * @Date: 2019年4月1日 下午2:44:35  
 * @Version: 1.0.0 Graduate
 */
public interface AbsentApplyApplication {
	/**
	 *  @Discription: 插入一条缺勤信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param attenceInfoUuid
	 *  @param reason
	 *  @param imageUrl
	 *  @return
	 *  @Date: 2019年4月13日下午8:58:47
	 */
	int insertAbsentApply(String sno,String attenceInfoUuid,String reason,String imageUrl);
	
	
	/**
	 *  @Discription: 查询学生的出勤信息
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param teacherCourseUuid
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午8:59:05
	 */
	List<Map<String,Object>> findStudentAbsentApply(String tno,String teacherCourseUuid,int year,int term);
	
	/**
	 *  @Discription: 教师处理学生的出勤信息
	 *  @Author: JiangChunLin
	 *  @param absentApplyUuid
	 *  @return
	 *  @Date: 2019年4月13日下午8:59:25
	 */
	int dealStudentAbsentApply(String absentApplyUuid);
}
