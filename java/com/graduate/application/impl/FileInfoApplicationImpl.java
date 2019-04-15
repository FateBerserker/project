package com.graduate.application.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graduate.application.FileInfoApplication;
/**
 * 
 * @Discription: 文件  
 * @Author: JiangChunLin  
 * @ClassName: FileInfoApplicationImpl  
 * @Date: 2019年4月1日 下午5:00:42  
 * @Version: 1.0.0 Graduate
 */
@Component
public class FileInfoApplicationImpl implements FileInfoApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 *  @Description: 查询学生所选课程的文件信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.FileInfoApplication#findAllFileInfo(java.lang.String, int, int)
	 */
	@Override
	public List<Map<String, Object>> findAllFileInfo(String sno, int year, int term) {
		String sql="SELECT \r\n" + 
				"	a.uuid,a.type,a.fileName,a.fileUrl,b.courseCode,e.courseName,a.downloadSize\r\n" + 
				"FROM\r\n" + 
				"	fileinfo a LEFT JOIN teachercourse b on a.teacherCourseUuid=b.uuid\r\n" + 
				"	LEFT JOIN studentlesson d on d.teacherCourseUuid=a.teacherCourseUuid\r\n" + 
				"	LEFT JOIN course e on b.courseCode=e.courseCode\r\n" + 
				"WHERE d.sno='"+sno+"'\r\n" + 
				" AND b.`year`="+year+"\r\n" + 
				" AND b.term="+term;
		List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}

}
