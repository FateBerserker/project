package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.DoubtAnwserApplication;
import com.graduate.service.DoubtAnwserService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 问题回复   
 * @Author: JiangChunLin  
 * @ClassName: DoubtAnwserServiceImpl  
 * @Date: 2019年3月31日 下午5:16:01  
 * @Version: 1.0.0 Graduate
 */
@Service
public class DoubtAnwserServiceImpl implements DoubtAnwserService {
	@Autowired
	private DoubtAnwserApplication doubtAnwserApplication;
	/**
	 * 
	 *  @Description: 查询问题回复
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.DoubtAnwserService#findDoubtAllAnwser(java.lang.String)
	 */
	@Override
	public JSONResult findDoubtAllAnwser(String doubtUuid) {
		List<Map<String,Object>> result=doubtAnwserApplication.findDoubtAllAnwser(doubtUuid);
		if(result!=null&&result.size()>0){
			return JSONResult.success(result);
		}else{
			return JSONResult.failure("结果为空");
		}
	}
	/**
	 * 
	 *  @Description: 回复问题
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.DoubtAnwserService#insertDoubtAnwser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public JSONResult insertDoubtAnwser(String tsno, String doubtUuid, String content, String doubtAnwserUuid1,
			String doubtAnwserUuid2,String named) {
		int row=doubtAnwserApplication.insertDoubtAnwser(tsno,doubtUuid,content,doubtAnwserUuid1,doubtAnwserUuid2,named);
		if(row==1){
			return JSONResult.success();
		}else{
			return JSONResult.failure("失败"); 
		}
	}

}
