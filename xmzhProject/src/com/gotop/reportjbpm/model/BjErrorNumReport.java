package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class BjErrorNumReport implements Serializable {
	//报单日期-开始
	private String repTimeStart;
	//报单日期--结束
	private String repTimeEnd;
	//一级支行
	private String orgCodeOne;
	//一级支行--名称
	private String orgNameOne;
	//二级支行
	private String orgCodeTwo;
	//二级支行--名称
	private String orgNameTwo;
	//一级分类名称
	private String oneCategory;
	//一级分类id
	private String oneCategoryId;
	//贷种分类名称
	private String loanCategory;
	//贷种分类
	private String loanCategoryId;

	//笔均差错数
	private double averageCount;
	
	
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
	public String getOrgCodeOne() {
		return orgCodeOne;
	}
	public void setOrgCodeOne(String orgCodeOne) {
		this.orgCodeOne = orgCodeOne;
	}
	public String getOrgNameOne() {
		return orgNameOne;
	}
	public void setOrgNameOne(String orgNameOne) {
		this.orgNameOne = orgNameOne;
	}
	public String getOrgCodeTwo() {
		return orgCodeTwo;
	}
	public void setOrgCodeTwo(String orgCodeTwo) {
		this.orgCodeTwo = orgCodeTwo;
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
	
	public String getOneCategoryId() {
		return oneCategoryId;
	}
	public void setOneCategoryId(String oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}
	public String getLoanCategoryId() {
		return loanCategoryId;
	}
	public void setLoanCategoryId(String loanCategoryId) {
		this.loanCategoryId = loanCategoryId;
	}
	public double getAverageCount() {
		return averageCount;
	}
	public void setAverageCount(double averageCount) {
		this.averageCount = averageCount;
	}
	
	
	
	
	
}
