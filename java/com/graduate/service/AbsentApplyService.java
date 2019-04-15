package com.graduate.service;

import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 缺勤   
 * @Author: JiangChunLin  
 * @ClassName: AbsentApplyService  
 * @Date: 2019年4月13日 下午5:35:10  
 * @Version: 1.0.0 Graduate
 */
public interface AbsentApplyService {
	/**
	 * 
	 *  @Discription: 插入缺勤申请
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param attenceInfoUuid
	 *  @param reason
	 *  @param imageUrl
	 *  @return
	 *  @Date: 2019年4月13日下午5:38:42
	 */
	JSONResult insertAbsentApply(String sno,String attenceInfoUuid,String reason,String imageUrl);
	/**
	 * 
	 *  @Discription: 查询学期缺勤信息
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param teacherCourseUuid
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:39:03
	 */
	JSONResult findStudentAbsentApplyInf(String tno,String teacherCourseUuid,int year,int term);
	/**
	 * 
	 *  @Discription:更新学生的缺勤申请
	 *  @Author: JiangChunLin
	 *  @param absentApplyUuid
	 *  @param attenceInfoUuid
	 *  @param behavior
	 *  @return
	 *  @Date: 2019年4月13日下午5:39:20
	 */
	JSONResult updateAbsentApply(String absentApplyUuid,String attenceInfoUuid,int behavior);
}
