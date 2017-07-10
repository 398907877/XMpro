package com.gotop.reportjbpm.model;

import java.io.Serializable;

public class SxApprovalReport implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orgNameOne;
	private String orgNameTwo;
	private String oneCategory;//类型
	private String oneCategoryNum;//笔数
	private String oneCategoryMoney;//金额
	private String orgCodeOne;
	private String orgCodeTwoRows;
	private String oneCategoryName;
	private String approvalTimeStart;
	private String approvalTimeEnd;
	
	public String getOneCategoryName() {
		return oneCategoryName;
	}
	public void setOneCategoryName(String oneCategoryName) {
		this.oneCategoryName = oneCategoryName;
	}
	public String getOrgCodeTwoRows() {
		return orgCodeTwoRows;
	}
	public String getApprovalTimeStart() {
		return approvalTimeStart;
	}
	public void setApprovalTimeStart(String approvalTimeStart) {
		this.approvalTimeStart = approvalTimeStart;
	}
	public String getApprovalTimeEnd() {
		return approvalTimeEnd;
	}
	public void setApprovalTimeEnd(String approvalTimeEnd) {
		this.approvalTimeEnd = approvalTimeEnd;
	}
	public void setOrgCodeTwoRows(String orgCodeTwoRows) {
		this.orgCodeTwoRows = orgCodeTwoRows;
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
	public String getOrgNameTwo() {
		return orgNameTwo;
	}
	public void setOrgNameTwo(String orgNameTwo) {
		this.orgNameTwo = orgNameTwo;
	}
	public String getOneCategoryNum() {
		return oneCategoryNum;
	}
	public void setOneCategoryNum(String oneCategoryNum) {
		this.oneCategoryNum = oneCategoryNum;
	}
	public String getOneCategoryMoney() {
		return oneCategoryMoney;
	}
	public void setOneCategoryMoney(String oneCategoryMoney) {
		this.oneCategoryMoney = oneCategoryMoney;
	}
	
	public String getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}
}
