package com.graduate.service;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: FileInfoService  
 * @Date: 2019年4月1日 下午5:02:43  
 * @Version: 1.0.0 Graduate
 */

import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 文件   
 * @Author: JiangChunLin  
 * @ClassName: FileInfoService  
 * @Date: 2019年4月13日 下午5:43:19  
 * @Version: 1.0.0 Graduate
 */
public interface FileInfoService {
	/**
	 * 
	 *  @Discription: 查询学生对于的文件信息
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:43:27
	 */
	JSONResult findAllFileInfo(String sno,int year,int term);
}
