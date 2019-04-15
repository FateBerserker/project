package com.graduate.application;

import java.util.List;
import java.util.Map;

/**
 * 
 * @Discription: 问题回复
 * @Author: JiangChunLin  
 * @ClassName: DoubtAnwserApplication  
 * @Date: 2019年3月31日 下午3:49:23  
 * @Version: 1.0.0 Graduate
 */
public interface DoubtAnwserApplication {
	/**
	 *  @Discription: 查询问题的回复
	 *  @Author: JiangChunLin
	 *  @param doubtUuid
	 *  @return
	 *  @Date: 2019年4月13日下午9:03:23
	 */
	List<Map<String,Object>> findDoubtAllAnwser(String doubtUuid);
	/**
	 *  @Discription: 回复
	 *  @Author: JiangChunLin
	 *  @param tsno
	 *  @param doubtUuid
	 *  @param content
	 *  @param doubtAnwserUuid1
	 *  @param doubtAnwserUuid2
	 *  @param named
	 *  @return
	 *  @Date: 2019年4月13日下午9:05:04
	 */
	int insertDoubtAnwser(String tsno, String doubtUuid, String content, String doubtAnwserUuid1,
			String doubtAnwserUuid2,String named);
}
