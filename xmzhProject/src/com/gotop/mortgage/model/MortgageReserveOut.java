package com.gotop.mortgage.model;

public class MortgageReserveOut {
	
	
	private String id;
	private String warrantsId;
	private String borrowerNums;
	private String borrowerLog;
	private String operatingMatters;
	private String remark;
	private String insertTime;
	private String operatingId;
	private String nextName;
	private String tmpName;
	private String outInType;
	private String proNextName;//产权人栏
	private String outBorrowerLog;//产权人栏
	private String inBorrowerLog;//产权人栏
	private String inBorrowerNums;//入库显示外借数量
	private String inBorrowerLogInfo;//入库时显示外借操作事项
	private String logRemark;//备注信息  产权证数
	private String signType;//标志出入库显示操作事项状态
	
	public String getTmpName() {
		return tmpName;
	}
	public void setTmpName(String tmpName) {
		this.tmpName = tmpName;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getId() {
		return id;
	}
	public String getWarrantsId() {
		return warrantsId;
	}
	public String getBorrowerNums() {
		return borrowerNums;
	}
	public String getBorrowerLog() {
		return borrowerLog;
	}
	public String getOperatingMatters() {
		return operatingMatters;
	}
	public String getRemark() {
		return remark;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setWarrantsId(String warrantsId) {
		this.warrantsId = warrantsId;
	}
	public void setBorrowerNums(String borrowerNums) {
		this.borrowerNums = borrowerNums;
	}
	public void setBorrowerLog(String borrowerLog) {
		this.borrowerLog = borrowerLog;
	}
	public void setOperatingMatters(String operatingMatters) {
		this.operatingMatters = operatingMatters;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	public String getOperatingId() {
		return operatingId;
	}
	public void setOperatingId(String operatingId) {
		this.operatingId = operatingId;
	}
	public String getNextName() {
		return nextName;
	}
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}
	public String getOutInType() {
		return outInType;
	}
	public void setOutInType(String outInType) {
		this.outInType = outInType;
	}
	public String getProNextName() {
		return proNextName;
	}
	public void setProNextName(String proNextName) {
		this.proNextName = proNextName;
	}
	public String getOutBorrowerLog() {
		return outBorrowerLog;
	}
	public String getInBorrowerLog() {
		return inBorrowerLog;
	}
	public void setOutBorrowerLog(String outBorrowerLog) {
		this.outBorrowerLog = outBorrowerLog;
	}
	public void setInBorrowerLog(String inBorrowerLog) {
		this.inBorrowerLog = inBorrowerLog;
	}
	public String getInBorrowerNums() {
		return inBorrowerNums;
	}
	public void setInBorrowerNums(String inBorrowerNums) {
		this.inBorrowerNums = inBorrowerNums;
	}
	

	public String getInBorrowerLogInfo() {
		return inBorrowerLogInfo;
	}
	public void setInBorrowerLogInfo(String inBorrowerLogInfo) {
		this.inBorrowerLogInfo = inBorrowerLogInfo;
	}
	public String getLogRemark() {
		return logRemark;
	}
	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
	}

}
