package com.graduate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graduate.service.FileInfoService;
import com.graduate.utils.JSONResult;

/**
 * 
 * @Discription: 文件 
 * @Author: JiangChunLin  
 * @ClassName: FileInfoController  
 * @Date: 2019年4月1日 下午5:05:38  
 * @Version: 1.0.0 Graduate
 */
@RestController
@RequestMapping(value="file")
public class FileInfoController {
	@Autowired
	private FileInfoService fileInfoService;
	/**
	 * 
	 *  @Discription: 查询文件信息(学生所选课程对应下)
	 *  @Author: JiangChunLin
	 *  @param sno
	 *  @param year
	 *  @param term
	 *  @return
	 *  @Date: 2019年4月1日下午5:08:12
	 */
	@RequestMapping(value="findAllFileInfo")
	public JSONResult findAllFileInfo(String sno,int year,int term){
		return fileInfoService.findAllFileInfo(sno, year, term);
	}
}
