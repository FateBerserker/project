package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduate.service.DoubtAnwserService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 问题、回复
 * @Author: JiangChunLin  
 * @ClassName: DoubtAnwserController  
 * @Date: 2019年3月31日 下午5:17:56  
 * @Version: 1.0.0 Graduate
 */
@RestController
@RequestMapping(value="doubtAnwser")
public class DoubtAnwserController {
	@Autowired
	private DoubtAnwserService doubtAnwserService;
	
	/**
	 * 
	 *  @Discription: 查询问题的回复
	 *  @Author: JiangChunLin
	 *  @param doubtUuid
	 *  @return
	 *  @Date: 2019年3月31日下午5:19:22
	 */
	@RequestMapping(value="findDoubtAllAnwser")
	public JSONResult findDoubtAllAnwser(String doubtUuid){
		return doubtAnwserService.findDoubtAllAnwser(doubtUuid);
	}
	
	/**
	 * 
	 *  @Discription: 插入问题回复
	 *  @Author: JiangChunLin
	 *  @param tsno 回复人编号
	 *  @param doubtUuid  问题的uuid
	 *  @param content 回复内容
	 *  @param doubtAnwserUuid1  祖先回复的uuid
	 *  @param doubtAnwserUuid2 直接父回复的uuid
	 *  @return
	 *  @Date: 2019年3月31日下午7:21:43
	 */
	@RequestMapping(value="insertDoubtAnwser")
	public JSONResult insertDoubtAnwser(String tsno,String doubtUuid,String content,
			String doubtAnswerUuid1,String  doubtAnswerUuid2,String named){
		return doubtAnwserService.insertDoubtAnwser(tsno,doubtUuid,content,
				doubtAnswerUuid1,doubtAnswerUuid2,named);
	}
	
	
}
