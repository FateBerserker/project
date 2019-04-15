package com.graduate.service;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: DoubtAnwserService  
 * @Date: 2019年3月31日 下午5:15:08  
 * @Version: 1.0.0 Graduate
 */

import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 问题回复
 * @Author: JiangChunLin  
 * @ClassName: DoubtAnwserService  
 * @Date: 2019年4月13日 下午5:42:01  
 * @Version: 1.0.0 Graduate
 */
public interface DoubtAnwserService {
	/**
	 * 
	 *  @Discription: 查询问题回复
	 *  @Author: JiangChunLin
	 *  @param doubtUuid
	 *  @return
	 *  @Date: 2019年4月13日下午5:42:13
	 */
	JSONResult findDoubtAllAnwser(String doubtUuid);
	/**
	 * 
	 *  @Discription: 插入回复
	 *  @Author: JiangChunLin
	 *  @param tsno
	 *  @param doubtUuid
	 *  @param content
	 *  @param doubtAnwserUuid1
	 *  @param doubtAnwserUuid2
	 *  @param named
	 *  @return
	 *  @Date: 2019年4月13日下午5:42:34
	 */
	JSONResult insertDoubtAnwser(String tsno, String doubtUuid, String content, String doubtAnwserUuid1,
			String doubtAnwserUuid2,String named);
}
