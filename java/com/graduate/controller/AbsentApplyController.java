package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduate.service.AbsentApplyService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 缺勤申请  
 * @Author: JiangChunLin  
 * @ClassName: AbsentApplyController  
 * @Date: 2019年4月1日 下午2:41:47  
 * @Version: 1.0.0 Graduate
 */
@RestController
public class AbsentApplyController {
	@Autowired
	private AbsentApplyService absentApplyService;
	/**
	 * 
	 *  @Discription: 提交申请
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param attenceInfoUuid
	 *  @param reason
	 *  @param imageUrl
	 *  @return
	 *  @Date: 2019年4月1日下午2:53:44
	 */
	@RequestMapping(value="insertAbsentApply")
	public JSONResult insertAbsentApply(String sno,String attenceInfoUuid,String reason,String imageUrl){
		return absentApplyService.insertAbsentApply(sno, attenceInfoUuid, reason, imageUrl);
	}
	
	/**
	 * 
	 *  @Discription: 查询学生缺勤
	 *  @Author: JiangChunLin
	 *  @param tno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月1日下午2:54:40
	 */
	@RequestMapping(value="findStudentAbsentApply")
	public JSONResult findAllAbsentApply(String tno,int year, int term,String teacherCourseUuid){
		return absentApplyService.findStudentAbsentApplyInf(tno, teacherCourseUuid, year, term);
	}
	
	/**
	 * 
	 *  @Discription: 更新申请的状态
	 *  @Author: JiangChunLin
	 *  @param absentApplyUuid
	 *  @param attenceInfoUuid
	 *  @param behavior
	 *  @return
	 *  @Date: 2019年4月5日下午4:00:50
	 */
	@RequestMapping(value="updateAbsentApplyStatus")
	public JSONResult updateAbsentApplyStatus(String absentApplyUuid,String attenceInfoUuid,int behavior){
		return absentApplyService.updateAbsentApply(absentApplyUuid, attenceInfoUuid, behavior);
	}
	
}
