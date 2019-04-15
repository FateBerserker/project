package com.graduate.service;

import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 问题 
 * @Author: JiangChunLin  
 * @ClassName: DoubtService  
 * @Date: 2019年3月31日 下午3:52:32  
 * @Version: 1.0.0 Graduate
 */
public interface DoubtService {
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
	 *  @Date: 2019年4月13日下午5:42:52
	 */
	JSONResult insert(String sno, String teacherCourseUuid, String courseName, String content, String imagesUrl);
	/**
	 * 
	 *  @Discription: 查询课程下的问题
	 *  @Author: JiangChunLin
	 *  @param teacherCourseUuids
	 *  @return
	 *  @Date: 2019年4月13日下午5:43:04
	 */
	JSONResult findAllDoubt(String teacherCourseUuids);
}
