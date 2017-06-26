package com.gotop.mortgage.model;

import java.io.Serializable;


public class LoanInfo implements Serializable{
	private static final long serialVersionUID = 2232407149888537837L;
//  序号
	private String loanID;
//	押品类型
	private String mortgageType;
//	查询时间
	private String queryTime;
	
	
//	查询时间 -开始时间
	private String inTimeStart;
//	查询时间 -截止时间
	private String inTimeEnd;
	
	
//	外借时间
	private String checkTime;
//	他项类型
	private String otherType;	
//  库存序号
	private String repertoryID;
//  产权证号
	private String propertyCardID;
//  产权人
	private String propertyPerson;
//  交接人
	private String borrowerNextName;
//  外借数量
	private String checkNums;
//  经办支行
	private String orgnaizationBranch;
//  经办客户经理
	private String orgnaizationCustomerManager;
//  已借天数
	private String alreadyLoanDay;
//  是否超限
	private String whetherOverrun;
//  备注
	private String remark;
//  车牌号
	private String licensePlateNumber;
//  车主
	private String owners;
	public String getLoanID() {
		return loanID;
	}
	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public String getRepertoryID() {
		return repertoryID;
	}
	public void setRepertoryID(String repertoryID) {
		this.repertoryID = repertoryID;
	}
	public String getPropertyCardID() {
		return propertyCardID;
	}
	public void setPropertyCardID(String propertyCardID) {
		this.propertyCardID = propertyCardID;
	}
	public String getPropertyPerson() {
		return propertyPerson;
	}
	public void setPropertyPerson(String propertyPerson) {
		this.propertyPerson = propertyPerson;
	}
	public String getCheckNums() {
		return checkNums;
	}
	public void setCheckNums(String checkNums) {
		this.checkNums = checkNums;
	}
	public String getOrgnaizationBranch() {
		return orgnaizationBranch;
	}
	public void setOrgnaizationBranch(String orgnaizationBranch) {
		this.orgnaizationBranch = orgnaizationBranch;
	}
	public String getOrgnaizationCustomerManager() {
		return orgnaizationCustomerManager;
	}
	public void setOrgnaizationCustomerManager(String orgnaizationCustomerManager) {
		this.orgnaizationCustomerManager = orgnaizationCustomerManager;
	}
	public String getAlreadyLoanDay() {
		return alreadyLoanDay;
	}
	public void setAlreadyLoanDay(String alreadyLoanDay) {
		this.alreadyLoanDay = alreadyLoanDay;
	}
	public String getWhetherOverrun() {
		return whetherOverrun;
	}
	public void setWhetherOverrun(String whetherOverrun) {
		this.whetherOverrun = whetherOverrun;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}
	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
	public String getOwners() {
		return owners;
	}
	public void setOwners(String owners) {
		this.owners = owners;
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getMortgageType() {
		return mortgageType;
	}
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public String getInTimeStart() {
		return inTimeStart;
	}
	public void setInTimeStart(String inTimeStart) {
		this.inTimeStart = inTimeStart;
	}
	public String getInTimeEnd() {
		return inTimeEnd;
	}
	public void setInTimeEnd(String inTimeEnd) {
		this.inTimeEnd = inTimeEnd;
	}
	public String getBorrowerNextName() {
		return borrowerNextName;
	}
	public void setBorrowerNextName(String borrowerNextName) {
		this.borrowerNextName = borrowerNextName;
	}

	
	

}
