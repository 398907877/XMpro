package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class PassRateReport implements Serializable {
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
	
	//贷种分类
	private String loanCategory;
	//贷种分类id
	private String loanCategoryId;
	//审查人
	private String reviewEmpname;
	//审批人
	private String approvalEmpname;
	//一次审批通过笔数
	private String businessNumberOne;

	//二次审批通过笔数
	private String businessNumberTwo;
	//三次审批通过笔数
	private String businessNumberThree;
	//3次以上次审批通过笔数
	private String businessNumberMoreThree;
	//4次以上次审批通过笔数
	private String businessNumberMoreFour;
	
	//一次通过率
	private String onePassRate;
	//二次通过率
	private String twoPassRate;
	//三次以上通过率
	private String threeOrMorePassRate;
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
	public String getReviewEmpname() {
		return reviewEmpname;
	}
	public void setReviewEmpname(String reviewEmpname) {
		this.reviewEmpname = reviewEmpname;
	}
	public String getApprovalEmpname() {
		return approvalEmpname;
	}
	public void setApprovalEmpname(String approvalEmpname) {
		this.approvalEmpname = approvalEmpname;
	}
	
	public String getOnePassRate() {
		return onePassRate;
	}
	public void setOnePassRate(String onePassRate) {
		this.onePassRate = onePassRate;
	}
	
	public String getTwoPassRate() {
		return twoPassRate;
	}
	public void setTwoPassRate(String twoPassRate) {
		this.twoPassRate = twoPassRate;
	}
	public String getThreeOrMorePassRate() {
		return threeOrMorePassRate;
	}
	public void setThreeOrMorePassRate(String threeOrMorePassRate) {
		this.threeOrMorePassRate = threeOrMorePassRate;
	}
	public String getBusinessNumberOne() {
		return businessNumberOne;
	}
	public void setBusinessNumberOne(String businessNumberOne) {
		this.businessNumberOne = businessNumberOne;
	}
	public String getBusinessNumberTwo() {
		return businessNumberTwo;
	}
	public void setBusinessNumberTwo(String businessNumberTwo) {
		this.businessNumberTwo = businessNumberTwo;
	}
	public String getBusinessNumberThree() {
		return businessNumberThree;
	}
	public void setBusinessNumberThree(String businessNumberThree) {
		this.businessNumberThree = businessNumberThree;
	}
	public String getBusinessNumberMoreThree() {
		return businessNumberMoreThree;
	}
	public void setBusinessNumberMoreThree(String businessNumberMoreThree) {
		this.businessNumberMoreThree = businessNumberMoreThree;
	}
	public String getBusinessNumberMoreFour() {
		return businessNumberMoreFour;
	}
	public void setBusinessNumberMoreFour(String businessNumberMoreFour) {
		this.businessNumberMoreFour = businessNumberMoreFour;
	}
	public String getLoanCategoryId() {
		return loanCategoryId;
	}
	public void setLoanCategoryId(String loanCategoryId) {
		this.loanCategoryId = loanCategoryId;
	}
	public String getOneCategoryId() {
		return oneCategoryId;
	}
	public void setOneCategoryId(String oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}
	

	
}
