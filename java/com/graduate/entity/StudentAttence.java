package com.graduate.entity;

import java.io.Serializable;

/**
 * @Discription:学生考勤信息类
 * @Author: JiangChunLin  
 * @ClassName: StudentAttence  
 * @Date: 2019年4月11日 下午5:00:13  
 * @Version: 1.0.0 Graduate
 */
public class StudentAttence implements Serializable{
	private static final long serialVersionUID = 1L;
	private String sno;//学号
	private String name;//名字
	private String machineId;//机器码
	public String getMachineId() {
		return machineId;
	}
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	private int grade;//年级
	private String major;//专业
	private int classth;//班
	private String sex;//性别
	private String teacherCourseUuid;//课程号
	private int weekth;//第几周
	private int weekDay;//周几
	private String rangeText;//课程节描述
	private int type;//类型
	private int lessonIndex;//第几节
	private int year;//年
	public int getLessonIndex() {
		return lessonIndex;
	}
	public void setLessonIndex(int lessonIndex) {
		this.lessonIndex = lessonIndex;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	private int term;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getClassth() {
		return classth;
	}
	public void setClassth(int classth) {
		this.classth = classth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTeacherCourseUuid() {
		return teacherCourseUuid;
	}
	public void setTeacherCourseUuid(String teacherCourseUuid) {
		this.teacherCourseUuid = teacherCourseUuid;
	}
	public int getWeekth() {
		return weekth;
	}
	public void setWeekth(int weekth) {
		this.weekth = weekth;
	}
	public int getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}
	public String getRangeText() {
		return rangeText;
	}
	public void setRangeText(String rangeText) {
		this.rangeText = rangeText;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "{sno : " + sno + ", name : " + name + ", machineId : " + machineId + ", grade : " + grade + ", major : "
				+ major + ", classth : " + classth + ", sex : " + sex + ", teacherCourseUuid : " + teacherCourseUuid
				+ ", weekth : " + weekth + ", weekDay : " + weekDay + ", rangeText : " + rangeText + ", type : " + type
				+ ", lessonIndex : " + lessonIndex + ", year : " + year + ", term : " + term + "}";
	}
}
