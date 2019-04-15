package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.graduate.service.ScoreService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 成绩  
 * @Author: JiangChunLin  
 * @ClassName: ScoreController  
 * @Date: 2019年3月30日 下午5:26:17  
 * @Version: 1.0.0 Graduate
 */
@Controller
@RequestMapping(value="score")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	/**
	 * 
	 *  @Discription: 查询学生成绩
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param overNum
	 *  @param upOrDown
	 *  @return
	 *  @Date: 2019年3月30日下午5:30:55
	 */
	@ResponseBody
	@RequestMapping(value="findStudentScore")
	public JSONResult findStudentScore(String sno,int overNum,int upOrDown){
		return scoreService.findStudentScore(sno, upOrDown, overNum);
	}
	
	
	
	
	
}
