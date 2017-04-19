package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class TimeLimitConditionReport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orgCodeOne;
	private String orgCodeTwo;
	private String orgNameOne;
	private String orgNameTwo;
	private String oneCategory;
	private String loanCategory;
	private String zdCustManager;
	private String repTimeStart;
	private String repTimeEnd;
	private double zhgpdTimeOne;
	private double zhgpdTimeTwo;
	private double zhgpdTimeThree;
	private double reviewApprovalOneTime;
	private double reviewApprovalTwoTime;
	private double reviewApprovalThreeOrMoreTime;
	private double allProcessTimeOne;
	private double allProcessTimeTwo;
	private double zlwzhApprovalTime;

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
	public String getZdCustManager() {
		return zdCustManager;
	}
	public void setZdCustManager(String zdCustManager) {
		this.zdCustManager = zdCustManager;
	}
	public double getZhgpdTimeOne() {
		return zhgpdTimeOne;
	}
	public void setZhgpdTimeOne(double zhgpdTimeOne) {
		this.zhgpdTimeOne = zhgpdTimeOne;
	}
	public double getZhgpdTimeTwo() {
		return zhgpdTimeTwo;
	}
	public void setZhgpdTimeTwo(double zhgpdTimeTwo) {
		this.zhgpdTimeTwo = zhgpdTimeTwo;
	}
	public double getZhgpdTimeThree() {
		return zhgpdTimeThree;
	}
	public void setZhgpdTimeThree(double zhgpdTimeThree) {
		this.zhgpdTimeThree = zhgpdTimeThree;
	}
	public double getReviewApprovalOneTime() {
		return reviewApprovalOneTime;
	}
	public void setReviewApprovalOneTime(double reviewApprovalOneTime) {
		this.reviewApprovalOneTime = reviewApprovalOneTime;
	}
	public double getReviewApprovalTwoTime() {
		return reviewApprovalTwoTime;
	}
	public void setReviewApprovalTwoTime(double reviewApprovalTwoTime) {
		this.reviewApprovalTwoTime = reviewApprovalTwoTime;
	}
	public double getReviewApprovalThreeOrMoreTime() {
		return reviewApprovalThreeOrMoreTime;
	}
	public void setReviewApprovalThreeOrMoreTime(
			double reviewApprovalThreeOrMoreTime) {
		this.reviewApprovalThreeOrMoreTime = reviewApprovalThreeOrMoreTime;
	}
	public double getAllProcessTimeOne() {
		return allProcessTimeOne;
	}
	public void setAllProcessTimeOne(double allProcessTimeOne) {
		this.allProcessTimeOne = allProcessTimeOne;
	}
	public double getAllProcessTimeTwo() {
		return allProcessTimeTwo;
	}
	public void setAllProcessTimeTwo(double allProcessTimeTwo) {
		this.allProcessTimeTwo = allProcessTimeTwo;
	}
	public double getZlwzhApprovalTime() {
		return zlwzhApprovalTime;
	}
	public void setZlwzhApprovalTime(double zlwzhApprovalTime) {
		this.zlwzhApprovalTime = zlwzhApprovalTime;
	}
	
	
	
	
}
