package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Discription: 问题    
 * @Author: JiangChunLin  
 * @ClassName: DoubtApplication  
 * @Date: 2019年3月31日 下午3:47:43  
 * @Version: 1.0.0 Graduate
 */
public interface DoubtApplication {
	/**
	 *  @Discription: 发布问题
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param teacherCourseUuid
	 *  @param content
	 *  @param imagesUrl
	 *  @param courseName
	 *  @return
	 *  @Date: 2019年4月13日下午5:06:20
	 */
	int insertDoubt(String sno,String teacherCourseUuid,String content,String imagesUrl,String courseName);
	/**
	 *  @Discription: 查询对应课程下的所有问题
	 *  @Author: JiangChunLin
	 *  @param teacherCourseUuids
	 *  @return
	 *  @Date: 2019年4月13日下午5:06:35
	 */
	List<Map<String,Object>> findAllDoubt(String teacherCourseUuids);
	/**
	 *  @Discription: 更新问题的评论数
	 *  @Author: JiangChunLin
	 *  @param doubtUuid
	 *  @return
	 *  @Date: 2019年4月13日下午5:06:50
	 */
	int  updateMarkNumber(String doubtUuid);
}	
