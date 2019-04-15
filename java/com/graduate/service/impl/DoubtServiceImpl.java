package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.DoubtApplication;
import com.graduate.service.DoubtService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 问题  
 * @Author: JiangChunLin  
 * @ClassName: DoubtServiceImpl  
 * @Date: 2019年3月31日 下午3:52:52  
 * @Version: 1.0.0 Graduate
 */
@Service
public class DoubtServiceImpl implements DoubtService{
	@Autowired
	private DoubtApplication doubtApplication;
	/**
	 * 
	 *  @Description: 插入问题
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.DoubtService#insert(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONResult insert(String sno, String teacherCourseUuid, String courseName, String content,
			String imagesUrl) {
		int row=doubtApplication.insertDoubt(sno, teacherCourseUuid, content, imagesUrl, courseName);
		if(row==1){
			return JSONResult.success();
		}else{
			return JSONResult.failure("插入失败");
		}
	}
	/**
	 * 
	 *  @Description: 查询问题
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.DoubtService#findAllDoubt(java.lang.String)
	 */
	@Override
	public JSONResult findAllDoubt(String teacherCourseUuids) {
		List<Map<String,Object>> result=doubtApplication.findAllDoubt(teacherCourseUuids);
		if(result!=null&&result.size()>0){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("查询结果为空");
		}
	}

}
