package com.graduate.application.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.graduate.application.AbsentApplyApplication;
import com.graduate.application.StudentAttenceInfoApplication;
import com.graduate.utils.StringUtils;
/**
 * 
 * @Discription: 实现层
 * @Author: JiangChunLin  
 * @ClassName: AbsentApplyApplicationImpl  
 * @Date: 2019年4月1日 下午2:47:26  
 * @Version: 1.0.0 Graduate
 */
@Component
@Transactional
public class AbsentApplyApplicationImpl implements AbsentApplyApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 
	 *  @Description: 插入缺勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AbsentApplyApplication#insertAbsentApply(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int insertAbsentApply(String sno, String attenceInfoUuid, String reason, String imageUrl) {
		String uuid=StringUtils.uuid(32);
		String date=StringUtils.dateToYMDHMS(new Date());
		String sql="INSERT absentapply VALUES('"+uuid+"','"+sno+"','"+attenceInfoUuid+"','"
				+reason+"','"+imageUrl+"','"+date+"',0)";
		int row=jdbcTemplate.update(sql);
		int row1=saia.updateStudentAttenceInfoStatus(attenceInfoUuid, 2);
		if(row==1&&row1==1){
			return 1;
		}else{
			return 0;
		}
	}

	

	@Autowired
	private StudentAttenceInfoApplication saia;
	
	
	/**
	 *  @Description: 查询学生缺勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AbsentApplyApplication#findStudentAbsentApply(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public List<Map<String, Object>> findStudentAbsentApply(String tno, String teacherCourseUuid, int year, int term) {
		String sql="SELECT \r\n" + 
				"a.uuid absentApplyUuid,	d.`name`, e.courseName,a.reason,a.imageUrl,DATE_FORMAT(a.applyTime,'%Y/%m/%d %H:%i:%s') applyTime,b.rangeText,\r\n" + 
				"  b.weekth,b.weekDay,b.uuid attenceInfoUuid "+
				"FROM \r\n" + 
				"	absentapply a LEFT JOIN studentattenceinfo b  on a.attenceInfoUuid=b.uuid\r\n" + 
				"	LEFT JOIN teachercourse c on c.uuid=b.teacherCourseUuid\r\n" + 
				"	LEFT JOIN studentinfo d on b.sno=d.sno\r\n" + 
				"	LEFT JOIN course e on e.courseCode=c.courseCode\r\n" + 
				"WHERE c.tno='"+tno+"' \r\n" ;
		if("-1".equals(teacherCourseUuid)){
			sql+="			AND c.`year`="+year+"\r\n" + 
					"			AND c.term="+term+"\r\n" + 
					"			AND a.`status`=0";
		}else{
			sql+="			AND c.uuid='"+teacherCourseUuid+"'\r\n" + 
					"			AND c.`year`="+year+"\r\n" + 
					"			AND c.term="+term+"\r\n" + 
					"			AND a.`status`=0";
		}
				
				
		List<Map<String, Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	
	/**
	 * 
	 *  @Description: 更新学生申请信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.AbsentApplyApplication#dealStudentAbsentApply(java.lang.String)
	 */
	@Override
	public int dealStudentAbsentApply(String absentApplyUuid) {
		String sql="update absentapply set status=1 where uuid='"+absentApplyUuid+"'";
		int row=jdbcTemplate.update(sql);
		return row;
	}

}
