package com.graduate.entity;

import java.io.Serializable;

/**
 * @Discription: 查询条件    
 * @Author: JiangChunLin  
 * @ClassName: QueryCondition  
 * @Date: 2019年4月11日 下午5:24:52  
 * @Version: 1.0.0 Graduate
 */
public class QueryCondition implements Serializable{
	/** 
	 *  @Discription: TODO
	 *  serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//年
	private int year;
	private int term;//半年
	private int weekth;//第几周
	private int weekDay;//周几
	private int lessonIndex;//第几节
	private String sno;//学号
	private String tno;//教师号
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
	public int getLessonIndex() {
		return lessonIndex;
	}
	public void setLessonIndex(int lessonIndex) {
		this.lessonIndex = lessonIndex;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	@Override
	public String toString() {
		return "{year : " + year + ", term : " + term + ", weekth : " + weekth + ", weekDay : " + weekDay
				+ ", lessonIndex : " + lessonIndex + ", sno : " + sno + ", tno : " + tno + "}";
	}
	
}
