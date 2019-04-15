package com.graduate.service;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: ScoreService  
 * @Date: 2019年3月30日 下午5:26:58  
 * @Version: 1.0.0 Graduate
 */

import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription:成绩    
 * @Author: JiangChunLin  
 * @ClassName: ScoreService  
 * @Date: 2019年4月13日 下午5:44:11  
 * @Version: 1.0.0 Graduate
 */
public interface ScoreService {
	/**
	 * 
	 *  @Discription: 查询成绩
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param upOrDown
	 *  @param overNum
	 *  @return
	 *  @Date: 2019年4月13日下午5:44:17
	 */
	JSONResult findStudentScore(String sno,int upOrDown,int overNum);
}
