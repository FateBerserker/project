package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.ScoreApplication;
import com.graduate.service.ScoreService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 成绩    
 * @Author: JiangChunLin  
 * @ClassName: ScoreServiceImpl  
 * @Date: 2019年3月30日 下午5:27:50  
 * @Version: 1.0.0 Graduate
 */
@Service
public class ScoreServiceImpl implements ScoreService{
	
	
	@Autowired
	private ScoreApplication scoreApplication;
	/**
	 * 
	 *  @Description: 查询学生成绩
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.ScoreService#findStudentScore(java.lang.String, int, int)
	 */
	@Override
	public JSONResult findStudentScore(String sno, int upOrDown, int overNum) {
		List<Map<String,Object>> result=scoreApplication.findStudentScore(sno, overNum, upOrDown);
		if(result!=null&&result.size()>0){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("查询结果为空");
		}
	}

}
