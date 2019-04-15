package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Discription: 文件信息   
 * @Author: JiangChunLin  
 * @ClassName: FileInfoApplication  
 * @Date: 2019年4月1日 下午4:59:48  
 * @Version: 1.0.0 Graduate
 */
public interface FileInfoApplication {
	/**
	 *  @Discription: 查询所有文件
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月13日下午5:07:19
	 */
	List<Map<String,Object>> findAllFileInfo(String sno,int year,int term);
}
