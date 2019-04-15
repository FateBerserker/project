package com.graduate.application.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.graduate.application.StudentAttenceInfoApplication;
import com.graduate.entity.StudentAttence;
import com.graduate.utils.StringUtils;
/**
 * 
 * @Discription: 学生出勤    
 * @Author: JiangChunLin  
 * @ClassName: StudentAttenceInfoApplicationImpl  
 * @Date: 2019年3月31日 下午10:31:59  
 * @Version: 1.0.0 Graduate
 */
@Component
public class StudentAttenceInfoApplicationImpl implements StudentAttenceInfoApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 *  @Description: 查询学生出勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#findStudentAttenceInfo(java.lang.String, java.lang.String, int, int)
	 */
	@Override
	public List<Map<String, Object>> findStudentAttenceInfo(String sno, String teacherCourseUuid, int year, int term) {
		String sql="SELECT \r\n" + 
				"	a.uuid,d.courseName,e.`name`,a.weekth,a.weekDay,a.type,a.mark,a.rangeText,\r\n" + 
				"	DATE_FORMAT(a.signTime,'%Y/%m/%d %H:%i:%s') signTime\r\n" + 
				"FROM \r\n" + 
				"		studentattenceinfo a \r\n" + 
				"		LEFT JOIN teachercourse c on a.teacherCourseUuid=c.uuid\r\n" + 
				"		LEFT JOIN course d on c.courseCode=d.courseCode\r\n" + 
				"		LEFT JOIN teacherinfo e on c.tno=e.tno\r\n" + 
				"WHERE \r\n" + 
				"	a.sno='"+sno+"'\r\n" ;
		if(teacherCourseUuid.equals("-1")){ //查询所有课程考勤信息
			sql+="	AND c.`year`=2019\r\n" + 
					"	AND c.term=1\r\n";
		}else{ //查询某一课程的考勤信息
			sql+="	AND c.uuid='"+teacherCourseUuid+"'	\r\n" ;
					
		}				
		sql+="	ORDER BY signTime DESC";
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	/**
	 *  @Description: 查询学生缺勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#findStudentAbsentInfo(java.lang.String, int, int)
	 */
	@Override
	public List<Map<String, Object>> findStudentAbsentInfo(String sno, int year, int term) {
		String sql="SELECT a.uuid,  a.weekth,a.weekDay,a.rangeText,c.courseName\r\n" + 
				"	FROM \r\n" + 
				"		studentattenceinfo a \r\n" + 
				"		LEFT JOIN teachercourse b on a.teacherCourseUuid=b.uuid\r\n" + 
				"		LEFT JOIN course c on b.courseCode=c.courseCode\r\n" + 
				"	WHERE a.sno='"+sno+"' AND a.type=0\r\n" + 
				"	AND b.`year`="+year+" AND b.term="+term;
		List<Map<String,Object>> result=jdbcTemplate.queryForList(sql);
		return result;
	}
	/**
	 * 
	 *  @Description: 更新学生的考勤状态
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#updateStudentAttenceInfoStatus(java.lang.String, int)
	 */
	@Override
	public int updateStudentAttenceInfoStatus(String attenceInfoUuid, int type) {
		String mark="";
		if(type==2){
			mark="请假审批中";
		}else if(type==3){
			mark="补假通过";
		}else if(type==4){
			mark="拒绝补假";
		}
		String sql="UPDATE studentattenceinfo SET type="+type+" ,mark='"+mark+"'  WHERE uuid='"+attenceInfoUuid+"'";
		int row=jdbcTemplate.update(sql);
		return row;
	}
	/**
	 *  @Description: 批量插入学生考勤信息
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#batchInsertAttenceInfo(java.util.List)
	 */
	@Override
	public int batchInsertAttenceInfo(List<StudentAttence> params) {
		//('uuid','teacherCourseUuid',1,SYSDATE(),'sno','mark',7,4,'rangeText')
		String sql="INSERT INTO studentattenceinfo "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
			/**
			 *  @Description: 批量更新下的每行的参数值
			 *  @Author: JiangChunLin
			 *  @see org.springframework.jdbc.core.BatchPreparedStatementSetter#setValues(java.sql.PreparedStatement, int)
			 */
			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				StudentAttence studentAttence=params.get(index);
				String uuid=StringUtils.uuid(32);
				String teacherCourseUuid= studentAttence.getTeacherCourseUuid();
				int type=studentAttence.getType();
				String mark="正常考勤";
				if(type==1){
					mark="正常考勤";
				}else if(type==0){
					mark="缺勤";
				}
				Date date=new Date();
				String sno=studentAttence.getSno();
				int weekth=studentAttence.getWeekth();
				int weekDay=studentAttence.getWeekDay();
				String rangeText=studentAttence.getRangeText();
				/**
				 * 设置占位参数
				 */
				ps.setString(1, uuid);
				ps.setString(2, studentAttence.getMachineId());
				ps.setString(3, teacherCourseUuid);
				ps.setInt(4, type);
				ps.setString(5, StringUtils.dateToYMDHMS(date));
				ps.setString(6, sno);
				ps.setString(7, mark);
				ps.setInt(8,weekth);
				ps.setInt(9,weekDay);
				ps.setInt(10,studentAttence.getLessonIndex());
				ps.setString(11, rangeText);
			}
			
			@Override
			public int getBatchSize() {
				return params.size();
			}
		});
		
		return 0;
	}
	/**
	 *  @Description: 查询课程是否开启自主打卡
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#queryOpenSign(java.lang.String)
	 */
	@Override
	public int queryOpenSign(String teacherCourseUuid) {
		String sql="SELECT openSign FROM teachercourse WHERE uuid='"+teacherCourseUuid+"'";
		int openSign=jdbcTemplate.queryForObject(sql, int.class);
		return openSign;
	}
	/**
	 *  @Description: 开启学生自主打卡
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#setOpenSign(java.lang.String)
	 */
	@Override
	public int setOpenSign(String teacherCourseUuid) {
		String sql="UPDATE teachercourse set openSign=1 WHERE uuid='"+teacherCourseUuid+"'";
		int row=jdbcTemplate.update(sql);
		return row;
	}
	/**
	 * 
	 *  @Description: 学生签到
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#studentSign(com.graduate.entity.StudentAttence)
	 */
	@Override
	public void studentSign(StudentAttence studentAttence) {
		if(studentAttence==null){
			return ;
		}else{
			//('uuid','machineId','teacherCourseUuid',1,SYSDATE(),'sno','mark',7,4,lessonIndex,'rangeText')
			String uuid=StringUtils.uuid(32);
			String date=StringUtils.dateToYMDHMS(new Date());
			String mark="异常考勤";
			if(studentAttence.getType()==1){
				mark="正常考勤";
			}
			String sql="INSERT INTO studentattenceinfo \r\n" + 
					" VALUES('"+uuid+"','"+studentAttence.getMachineId()+"','"+studentAttence.getTeacherCourseUuid()
					+"',"+studentAttence.getType()+",'"+date+"','"+studentAttence.getSno()
					+"','"+mark+"',"+studentAttence.getWeekth()+","+studentAttence.getWeekDay()
					+","+studentAttence.getLessonIndex()
					+",'"+studentAttence.getRangeText()+"')";
//			jdbcTemplate.update(sql, uuid,studentAttence.getTeacherCourseUuid(),studentAttence.getType(),
//					date,studentAttence.getSno(),mark,studentAttence.getWeekth(),studentAttence.getWeekDay(),
//					studentAttence.getRangeText());
			jdbcTemplate.update(sql);
			return ;
		}
		
	}
	/**
	 *  @Description: 查询是否已经打过卡
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#hasSigned(com.graduate.entity.StudentAttence)
	 */
	@Override
	public int hasSigned(StudentAttence studentAttence) {
		String sql="SELECT COUNT(1) row FROM studentattenceinfo \r\n" + 
				"WHERE \r\n" + 
				"	sno='"+studentAttence.getSno()+"' \r\n" + 
				"	AND teacherCourseUuid='"+studentAttence.getTeacherCourseUuid()+"' \r\n" + 
				"	AND weekth="+studentAttence.getWeekth()+" \r\n" + 
				"	AND weekDay="+studentAttence.getWeekDay()+" \r\n" + 
				"	AND lessonIndex="+studentAttence.getLessonIndex();
		int row=jdbcTemplate.queryForObject(sql, int.class);
		return row;
	}
	/**
	 * 
	 *  @Description: 是否代签
	 *  @Author: JiangChunLin
	 *  @see com.graduate.application.StudentAttenceInfoApplication#hasMachineIdSign(com.graduate.entity.StudentAttence)
	 */
	@Override
	public int hasMachineIdSign(StudentAttence studentAttence) {
		String sql="SELECT COUNT(1) row FROM studentattenceinfo \r\n" + 
				"WHERE \r\n" + 
				"	teacherCourseUuid='"+studentAttence.getTeacherCourseUuid()+"' \r\n" + 
				"	AND weekth="+studentAttence.getWeekth()+" \r\n" + 
				"	AND weekDay="+studentAttence.getWeekDay()+" \r\n" + 
				"	AND lessonIndex="+studentAttence.getLessonIndex()+"\r\n" + 
				"	AND machineId='"+studentAttence.getMachineId()+"'";
		int row=jdbcTemplate.queryForObject(sql, int.class);
		return row;
	}

}
