package com.gotop.mortgage.model;


import java.io.Serializable;

/**
 * 操作日志类
 * @author gotop
 *
 */
public class MortgageLog implements Serializable{
	private static final long serialVersionUID = 2232407149888537837L;
//  操作时间
	private String operateTime;
//	操作类型
	private String operateType;
//	库存序号
	private String projectNumber;
	
//	操作开始时间
	private String airTime;
//	操作结束时间
	private String stopTime;
//	部门名称
	private String orgName;	
//  操作人员
	private String empName;
//  操作内容
	private String operateContent;
//  备注
	private String remark;
	public String getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}
	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	public String getAirTime() {
		return airTime;
	}
	public void setAirTime(String airTime) {
		this.airTime = airTime;
	}
	public String getStopTime() {
		return stopTime;
	}
	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getOperateContent() {
		return operateContent;
	}
	public void setOperateContent(String operateContent) {
		this.operateContent = operateContent;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	
	
	
	
	

}
