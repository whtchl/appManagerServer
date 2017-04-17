package com.cncoman.product.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseInfo implements Serializable {

	
	private static final long serialVersionUID = 1L;
	/**
	 * yyyy-MM-dd
	 */
	protected static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Calendar c = Calendar.getInstance();
	private int year = c.get(Calendar.YEAR);
	private int month = c.get(Calendar.MONTH) + 1;
	
	private long id;
	private int intId;
	
	protected String name;
	protected String monthFirstDay = year + "-" + (month > 9 ? "" : "0") + month + "-01";	
	private String toDay = sdf.format(new Date());
	private String fromDay = toDay;
	private String createTime;
	private String keyWord;
	
	public static String getOperator(int operator){		
		if(operator == 1)
			return "中国移动";
		if(operator == 2)
			return "中国联通";
		if(operator == 3)
			return "中国电信";
		return "未知";
	}	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public String getFromDay() {
		return fromDay;
	}
	public void setFromDay(String fromDay) {
		this.fromDay = fromDay;
	}
	public String getToDay() {
		return toDay;
	}
	public void setToDay(String toDay) {
		this.toDay = toDay;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public String getMonthFirstDay() {
		return monthFirstDay;
	}

	public void setMonthFirstDay(String monthFirstDay) {
		this.monthFirstDay = monthFirstDay;
	}

}
