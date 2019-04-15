package com.graduate.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.application.FileInfoApplication;
import com.graduate.service.FileInfoService;
import com.graduate.utils.JSONResult;
/**
 * 
 * @Discription: 文件    
 * @Author: JiangChunLin  
 * @ClassName: FileInfoServiceImpl  
 * @Date: 2019年4月1日 下午5:03:32  
 * @Version: 1.0.0 Graduate
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {
	@Autowired
	private FileInfoApplication fileInfoApplication;
	/**
	 * 
	 *  @Description: 查询文件信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.service.FileInfoService#findAllFileInfo(java.lang.String, int, int)
	 */
	@Override
	public JSONResult findAllFileInfo(String sno, int year, int term) {
		try {
			List<Map<String,Object>> result=fileInfoApplication.findAllFileInfo(sno, year, term);
			return JSONResult.success(result);
		} catch (Exception e) {
			e.printStackTrace();
			return JSONResult.failure("数据库查询异常");
		}
	}

}
