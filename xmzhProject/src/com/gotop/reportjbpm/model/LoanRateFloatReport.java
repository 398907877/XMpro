package com.gotop.reportjbpm.model;

import java.io.Serializable;


public class LoanRateFloatReport implements Serializable{
//	放款起始时间
	private String makeLoansDateStart;
//	放款结束时间
	private String makeLoansDateEnd;
	/**
	 * 受理支行（一级选项）
	*/
	private String orgCodeOne;
	
	/**
	 * 受理支行（二级选项）
	*/
	private String orgCodeTwo;
	
	/**
	 * 受理支行一	名称
	 */
	private String orgNameOne;
	
	/**
	 * 受理支行二	名称
	 */
	private String orgNameTwo;
	//	一级分类(名称)
	private String oneCategory;
	private String oneCategoryId;
	
//	货种分类名称
	private String loanCategory;
	private String loanCategoryId;
//	主调信贷员
	private String creatorName;
//	营业主管
	private String yyzg;
//	利率区间(开始)
	private String rateStart;
//	利率区间(结束)
	private String rateEnd;
//	放款日期
	private String makeLoansDate;
//	笔数
	private String nums;
//	金额
	private String amount;
	public String getMakeLoansDateStart() {
		return makeLoansDateStart;
	}
	public void setMakeLoansDateStart(String makeLoansDateStart) {
		this.makeLoansDateStart = makeLoansDateStart;
	}
	public String getMakeLoansDateEnd() {
		return makeLoansDateEnd;
	}
	public void setMakeLoansDateEnd(String makeLoansDateEnd) {
		this.makeLoansDateEnd = makeLoansDateEnd;
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
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public String getYyzg() {
		return yyzg;
	}
	public void setYyzg(String yyzg) {
		this.yyzg = yyzg;
	}
	public String getRateStart() {
		return rateStart;
	}
	public void setRateStart(String rateStart) {
		this.rateStart = rateStart;
	}
	public String getRateEnd() {
		return rateEnd;
	}
	public void setRateEnd(String rateEnd) {
		this.rateEnd = rateEnd;
	}
	public String getMakeLoansDate() {
		return makeLoansDate;
	}
	public void setMakeLoansDate(String makeLoansDate) {
		this.makeLoansDate = makeLoansDate;
	}
	public String getNums() {
		return nums;
	}
	public void setNums(String nums) {
		this.nums = nums;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
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
