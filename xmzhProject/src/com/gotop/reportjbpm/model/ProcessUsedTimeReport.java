package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class ProcessUsedTimeReport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orgCodeOne;
	private String orgCodeTwo;
	private String orgNameOne;
	private String orgNameTwo;
	private String oneCategory;
	private String loanCategory;
	private String timeLimitType;
	private String onedaysDealNum;
	private String twodaysDealNum;
	private String threedaysDealNum;
	private String repTimeStart;
	private String repTimeEnd;

	public String getOrgCodeOne() {
		return orgCodeOne;
	}
	public void setOrgCodeOne(String orgCodeOne) {
		this.orgCodeOne = orgCodeOne;
	}
	public String getOrgCodeTwo() {
		return orgCodeTwo;
	}
	public void setOrgCodeTwo(String orgCodeTwo) {
		this.orgCodeTwo = orgCodeTwo;
	}
	public String getRepTimeStart() {
		return repTimeStart;
	}
	public void setRepTimeStart(String repTimeStart) {
		this.repTimeStart = repTimeStart;
	}
	public String getRepTimeEnd() {
		return repTimeEnd;
	}
	public void setRepTimeEnd(String repTimeEnd) {
		this.repTimeEnd = repTimeEnd;
	}
	public String getOrgNameOne() {
		return orgNameOne;
	}
	public void setOrgNameOne(String orgNameOne) {
		this.orgNameOne = orgNameOne;
	}
	public String getOrgNameTwo() {
		return orgNameTwo;
	}
	public void setOrgNameTwo(String orgNameTwo) {
		this.orgNameTwo = orgNameTwo;
	}
	public String getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}
	public String getLoanCategory() {
		return loanCategory;
	}
	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}
	public String getTimeLimitType() {
		return timeLimitType;
	}
	public void setTimeLimitType(String timeLimitType) {
		this.timeLimitType = timeLimitType;
	}
	public String getOnedaysDealNum() {
		return onedaysDealNum;
	}
	public void setOnedaysDealNum(String onedaysDealNum) {
		this.onedaysDealNum = onedaysDealNum;
	}
	public String getTwodaysDealNum() {
		return twodaysDealNum;
	}
	public void setTwodaysDealNum(String twodaysDealNum) {
		this.twodaysDealNum = twodaysDealNum;
	}
	public String getThreedaysDealNum() {
		return threedaysDealNum;
	}
	public void setThreedaysDealNum(String threedaysDealNum) {
		this.threedaysDealNum = threedaysDealNum;
	}
	
	
}
