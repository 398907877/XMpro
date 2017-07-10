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
	private String activityNameLast;
	private String activityNameNext;
	private String activityNameRN;
	private String reportTime;
	private String displayOrderOne;
	private String displayOrderTwo;
	private String zhgpdTimeOne;
	private String zhgpdTimeTwo;
	private String zhgpdTimeThree;
	private String reviewApprovalOneTime;
	private String reviewApprovalTwoTime;
	private String reviewApprovalThreeOrMoreTime;
	private String allProcessTimeOne;
	private String allProcessTimeTwo;
	private String zlwzhApprovalTime;
	private String flowId;
	private String tempTime;
	private String zdCustManager;
	private String sppTimeStart;
	private String sppTimeEnd;
	
	
	public String getSppTimeStart() {
		return sppTimeStart;
	}
	public void setSppTimeStart(String sppTimeStart) {
		this.sppTimeStart = sppTimeStart;
	}
	public String getSppTimeEnd() {
		return sppTimeEnd;
	}
	public void setSppTimeEnd(String sppTimeEnd) {
		this.sppTimeEnd = sppTimeEnd;
	}
	public String getZdCustManager() {
		return zdCustManager;
	}
	public void setZdCustManager(String zdCustManager) {
		this.zdCustManager = zdCustManager;
	}
	public String getTempTime() {
		return tempTime;
	}
	public void setTempTime(String tempTime) {
		this.tempTime = tempTime;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getZhgpdTimeOne() {
		return zhgpdTimeOne;
	}
	public void setZhgpdTimeOne(String zhgpdTimeOne) {
		this.zhgpdTimeOne = zhgpdTimeOne;
	}
	public String getZhgpdTimeTwo() {
		return zhgpdTimeTwo;
	}
	public void setZhgpdTimeTwo(String zhgpdTimeTwo) {
		this.zhgpdTimeTwo = zhgpdTimeTwo;
	}
	public String getZhgpdTimeThree() {
		return zhgpdTimeThree;
	}
	public void setZhgpdTimeThree(String zhgpdTimeThree) {
		this.zhgpdTimeThree = zhgpdTimeThree;
	}
	public String getReviewApprovalOneTime() {
		return reviewApprovalOneTime;
	}
	public void setReviewApprovalOneTime(String reviewApprovalOneTime) {
		this.reviewApprovalOneTime = reviewApprovalOneTime;
	}
	public String getReviewApprovalTwoTime() {
		return reviewApprovalTwoTime;
	}
	public void setReviewApprovalTwoTime(String reviewApprovalTwoTime) {
		this.reviewApprovalTwoTime = reviewApprovalTwoTime;
	}
	public String getReviewApprovalThreeOrMoreTime() {
		return reviewApprovalThreeOrMoreTime;
	}
	public void setReviewApprovalThreeOrMoreTime(
			String reviewApprovalThreeOrMoreTime) {
		this.reviewApprovalThreeOrMoreTime = reviewApprovalThreeOrMoreTime;
	}
	public String getAllProcessTimeOne() {
		return allProcessTimeOne;
	}
	public void setAllProcessTimeOne(String allProcessTimeOne) {
		this.allProcessTimeOne = allProcessTimeOne;
	}
	public String getAllProcessTimeTwo() {
		return allProcessTimeTwo;
	}
	public void setAllProcessTimeTwo(String allProcessTimeTwo) {
		this.allProcessTimeTwo = allProcessTimeTwo;
	}
	public String getZlwzhApprovalTime() {
		return zlwzhApprovalTime;
	}
	public void setZlwzhApprovalTime(String zlwzhApprovalTime) {
		this.zlwzhApprovalTime = zlwzhApprovalTime;
	}
	public String getActivityNameRN() {
		return activityNameRN;
	}
	public void setActivityNameRN(String activityNameRN) {
		this.activityNameRN = activityNameRN;
	}
	public String getDisplayOrderOne() {
		return displayOrderOne;
	}
	public void setDisplayOrderOne(String displayOrderOne) {
		this.displayOrderOne = displayOrderOne;
	}
	public String getDisplayOrderTwo() {
		return displayOrderTwo;
	}
	public void setDisplayOrderTwo(String displayOrderTwo) {
		this.displayOrderTwo = displayOrderTwo;
	}
	public String getActivityNameLast() {
		return activityNameLast;
	}
	public void setActivityNameLast(String activityNameLast) {
		this.activityNameLast = activityNameLast;
	}
	public String getActivityNameNext() {
		return activityNameNext;
	}
	public void setActivityNameNext(String activityNameNext) {
		this.activityNameNext = activityNameNext;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
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
