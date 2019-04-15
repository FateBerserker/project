package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduate.service.DoubtService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 问题 
 * @Author: JiangChunLin  
 * @ClassName: DoubtController  
 * @Date: 2019年3月31日 下午3:53:09  
 * @Version: 1.0.0 Graduate
 */
@RestController
@RequestMapping(value="doubt")
public class DoubtController {
	@Autowired
	private DoubtService doubtService;
	/**
	 * 
	 *  @Discription: 插入问题
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param teacherCourseUuid
	 *  @param courseName
	 *  @param content
	 *  @param imagesUrl
	 *  @return
	 *  @Date: 2019年3月31日下午4:01:25
	 */
	@RequestMapping(value="insertDoubt")
	public JSONResult insertDoubt(String sno,String teacherCourseUuid,String courseName,String content,String imagesUrl){
		return doubtService.insert(sno,teacherCourseUuid,courseName,content,imagesUrl);
	}
	/**
	 * 
	 *  @Discription: 查询问题
	 *  @Author: JiangChunLin
	 *  @param teacherCourseUuids
	 *  @return
	 *  @Date: 2019年4月13日下午5:27:09
	 */
	@RequestMapping(value="findAllDoubt")
	public JSONResult findAllDoubt(String teacherCourseUuids){
		return doubtService.findAllDoubt(teacherCourseUuids);
	}
	
	
}
