package com.graduate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.AbsentApplyApplication;
import com.graduate.application.StudentAttenceInfoApplication;
import com.graduate.service.AbsentApplyService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 缺勤申请   
 * @Author: JiangChunLin  
 * @ClassName: AbsentApplyServiceImpl  
 * @Date: 2019年4月1日 下午2:50:38  
 * @Version: 1.0.0 Graduate
 */
@Service
public class AbsentApplyServiceImpl implements AbsentApplyService {
	@Autowired
	private AbsentApplyApplication absentApplyApplication;
	/**
	 * 
	 *  @Description: 插入缺勤申请
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AbsentApplyService#insertAbsentApply(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONResult insertAbsentApply(String sno, String attenceInfoUuid, String reason, String imageUrl) {
		int row=absentApplyApplication.insertAbsentApply(sno, attenceInfoUuid, reason, imageUrl);
		if(row==1){
			return JSONResult.success();
		}else{
			return JSONResult.failure("插入失败");
		}
	}
	
	/**
	 * 
	 *  @Description: 查询学生缺勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AbsentApplyService#findStudentAbsentApplyInf(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public JSONResult findStudentAbsentApplyInf(String tno, String teacherCourseUuid, int year, int term) {
		List<Map<String,Object>> result=new ArrayList<>();
		try {
			result=absentApplyApplication.findStudentAbsentApply(tno, teacherCourseUuid, year, term);
			return JSONResult.success(result);
		} catch (Exception e) {
			return JSONResult.failure("查询数据异常");
		}
	}
	@Autowired
	private StudentAttenceInfoApplication studentAttenceInfoApplication;
	/**
	 * 
	 *  @Description: behavior 3:同意，4:拒绝
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.AbsentApplyService#updateAbsentApply(java.lang.String, java.lang.String, int)
	 */
	@Override
	public JSONResult updateAbsentApply(String absentApplyUuid, String attenceInfoUuid, int behavior) {
		try {
			absentApplyApplication.dealStudentAbsentApply(absentApplyUuid);
			studentAttenceInfoApplication.updateStudentAttenceInfoStatus(attenceInfoUuid, behavior);
			return JSONResult.success();
		} catch (Exception e) {
			return JSONResult.failure("更新异常");
		}
	}

}
