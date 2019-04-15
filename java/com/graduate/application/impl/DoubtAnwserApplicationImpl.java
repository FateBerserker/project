package com.graduate.application.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.DoubtAnwserApplication;
import com.graduate.application.DoubtApplication;
import com.graduate.utils.StringUtils;
/**
 * 
 * @Discription: TODO    
 * @Author: JiangChunLin  
 * @ClassName: DoubtAnwserApplicationImpl  
 * @Date: 2019年3月31日 下午3:50:36  
 * @Version: 1.0.0 Graduate
 */
@Component
@Transactional
public class DoubtAnwserApplicationImpl implements DoubtAnwserApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 查询问题回复
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.DoubtAnwserApplication#findDoubtAllAnwser(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> findDoubtAllAnwser(String doubtUuid) {
		String sql="SELECT \r\n" + 
				"	if(b.sno is not null,b.name,c.name) name,-- 回复者名字\r\n" + 
				"	if(b.sno is not null,b.sex,c.sex) sex, --  性别\r\n" + 
				"	a.uuid,\r\n" + 
				"	a.doubtUuid,a.doubtAnswerUuid1,a.doubtAnswerUuid2,\r\n" + 
				"	a.content,a.named ,DATE_FORMAT(a.answerTime,'%Y/%m/%d %H:%i:%s') answerTime\r\n" + 
				"FROM \r\n" + 
				"	doubtanswer a \r\n" + 
				"	LEFT JOIN  studentinfo b on a.tsno=b.sno\r\n" + 
				"  LEFT JOIN teacherinfo c on a.tsno=c.tno	\r\n" + 
				"WHERE doubtUuid='"+doubtUuid+"'   "+
				" ORDER BY a.answerTime DESC";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	
	@Autowired
	private DoubtApplication doubtApplication;
	/**
	 *  @Description: 回复
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.DoubtAnwserApplication#insertDoubtAnwser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int insertDoubtAnwser(String tsno, String doubtUuid, String content, String doubtAnswerUuid1,
			String doubtAnswerUuid2,String named) {
		String uuid=StringUtils.uuid(32);
		String date=StringUtils.dateToYMDHMS(new Date());
		String sql="INSERT INTO doubtanswer "
				+ "VALUES('"+uuid+"','"+tsno+"','"+date+"','"+doubtUuid+"','"
				+doubtAnswerUuid1+"','"+doubtAnswerUuid2+"','"+content+"','"+named+"')";
		doubtApplication.updateMarkNumber(doubtUuid);
		int row=jdbcTemplate.update(sql);
		return row;
	}

}
