package com.gotop.mortgage.model;

public class MortgageReserve {
	
	
	private String id;
	private String mortgageType;
	private String otherType;
	private String noticeRegisterRelation;
	private String projectNumber;
	private String otherWarrantsNumber;
	private String otherWarrantsDate;
	private String borrowerName;
	private String borrowerCardNo;
	private String orgCode;
	private String orgName;
	private String mangerName;
	private String loanType;
	private String borrowerContractNo;
	private String loanYears;
	private String recordValue;
	private String packetNumber;
	private String nextName;
	private String purchaseNumber;
	private String fileName;
	private String remark;
	private String noRegisterSign;
	private String status;
	private String afterMortgageStatus;
	private String insertTime;
	private String empId;
	private String empName;
	private String updateTime;
	private String logOutSign;
	private String otherTypeFC;
	private String loanTypeFC;
	private String otherTypeJDC;
	private String loanTypeJDC;
	private String tmpProjectNumber;//临时库存序号
	private String tmpOtherWarrantsNumber;//临时他项权证号
	private String propertyName;//产权人姓名
	private String propertyCardNo;//产权人身份证
	
	public String getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getId() {
		return id;
	}
	public String getMortgageType() {
		return mortgageType;
	}
	public String getOtherType() {
		return otherType;
	}
	public String getNoticeRegisterRelation() {
		return noticeRegisterRelation;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public String getOtherWarrantsNumber() {
		return otherWarrantsNumber;
	}
	public String getOtherWarrantsDate() {
		return otherWarrantsDate;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public String getBorrowerCardNo() {
		return borrowerCardNo;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public String getMangerName() {
		return mangerName;
	}
	public String getLoanType() {
		return loanType;
	}
	public String getBorrowerContractNo() {
		return borrowerContractNo;
	}
	public String getLoanYears() {
		return loanYears;
	}
	public String getRecordValue() {
		return recordValue;
	}
	public String getPacketNumber() {
		return packetNumber;
	}
	public String getNextName() {
		return nextName;
	}
	public String getFileName() {
		return fileName;
	}
	public String getRemark() {
		return remark;
	}
	public String getNoRegisterSign() {
		return noRegisterSign;
	}
	public String getStatus() {
		return status;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public void setNoticeRegisterRelation(String noticeRegisterRelation) {
		this.noticeRegisterRelation = noticeRegisterRelation;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public void setOtherWarrantsNumber(String otherWarrantsNumber) {
		this.otherWarrantsNumber = otherWarrantsNumber;
	}
	public void setOtherWarrantsDate(String otherWarrantsDate) {
		this.otherWarrantsDate = otherWarrantsDate;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public void setBorrowerCardNo(String borrowerCardNo) {
		this.borrowerCardNo = borrowerCardNo;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public void setBorrowerContractNo(String borrowerContractNo) {
		this.borrowerContractNo = borrowerContractNo;
	}
	public void setLoanYears(String loanYears) {
		this.loanYears = loanYears;
	}
	public void setRecordValue(String recordValue) {
		this.recordValue = recordValue;
	}
	public void setPacketNumber(String packetNumber) {
		this.packetNumber = packetNumber;
	}
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setNoRegisterSign(String noRegisterSign) {
		this.noRegisterSign = noRegisterSign;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getAfterMortgageStatus() {
		return afterMortgageStatus;
	}
	public void setAfterMortgageStatus(String afterMortgageStatus) {
		this.afterMortgageStatus = afterMortgageStatus;
	}
	public String getPurchaseNumber() {
		return purchaseNumber;
	}
	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	public String getLogOutSign() {
		return logOutSign;
	}
	public void setLogOutSign(String logOutSign) {
		this.logOutSign = logOutSign;
	}
	public String getOtherTypeFC() {
		return otherTypeFC;
	}
	public String getLoanTypeFC() {
		return loanTypeFC;
	}
	public String getOtherTypeJDC() {
		return otherTypeJDC;
	}
	public String getLoanTypeJDC() {
		return loanTypeJDC;
	}
	public void setOtherTypeFC(String otherTypeFC) {
		this.otherTypeFC = otherTypeFC;
	}
	public void setLoanTypeFC(String loanTypeFC) {
		this.loanTypeFC = loanTypeFC;
	}
	public void setOtherTypeJDC(String otherTypeJDC) {
		this.otherTypeJDC = otherTypeJDC;
	}
	public void setLoanTypeJDC(String loanTypeJDC) {
		this.loanTypeJDC = loanTypeJDC;
	}
	public String getTmpProjectNumber() {
		return tmpProjectNumber;
	}
	public String getTmpOtherWarrantsNumber() {
		return tmpOtherWarrantsNumber;
	}
	public void setTmpProjectNumber(String tmpProjectNumber) {
		this.tmpProjectNumber = tmpProjectNumber;
	}
	public void setTmpOtherWarrantsNumber(String tmpOtherWarrantsNumber) {
		this.tmpOtherWarrantsNumber = tmpOtherWarrantsNumber;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getPropertyCardNo() {
		return propertyCardNo;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public void setPropertyCardNo(String propertyCardNo) {
		this.propertyCardNo = propertyCardNo;
	}


}
