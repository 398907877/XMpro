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
	private String A1_A;
	public String getA1_A() {
		return A1_A;
	}
	public void setA1_A(String a1_A) {
		A1_A = a1_A;
	}
	public String getOrgCodeTwoRows() {
		return orgCodeTwoRows;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}
}
