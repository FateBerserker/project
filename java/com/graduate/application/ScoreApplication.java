package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Discription: 学生成绩   
 * @Author: JiangChunLin  
 * @ClassName: ScoreApplication  
 * @Date: 2019年3月30日 下午5:22:33  
 * @Version: 1.0.0 Graduate
 */
public interface ScoreApplication {
	/**
	 *  @Discription: 查询学生成绩
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param overNum
	 *  @param upOrDown
	 *  @return
	 *  @Date: 2019年4月13日下午5:08:13
	 */
	List<Map<String,Object>> findStudentScore(String sno,int overNum,int upOrDown);
}
