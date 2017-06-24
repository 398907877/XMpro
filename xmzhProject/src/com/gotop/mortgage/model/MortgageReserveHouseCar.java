package com.gotop.mortgage.model;

public class MortgageReserveHouseCar {

	/*
	 * 主键id
	 * */
	private String id;
	/*
	 * 项目id
	 * */
	private String warrantsId;
	/*
	 *产权证号 
	 * */
	private String propertyNo;
	/*
	 * 产权人姓名
	 * */
	private String propertyName;
	/*
	 * 产权人身份证号
	 * */
	private String propertyCardNo;
	/*
	 * 产权地址
	 * */
	private String propertyAddres;
	
	/*
	 * 产权证数
	 * */
	private String propertyNums;
	/*
	 * 产权证填发日期
	 * */
	private String propertyDate;
	/*
	 * 补登记确认
	 * */
	private String  noRegisterSign;
	/*
	 * 货种
	 * 贷款种类(押品类型为房产的可选：二手房、一手房、综消、
	 * 个商、小额、小企业；押品类型为机动车的可选：汽车消费、经营性车辆贷款)
	 * */
	private String loanType;
	/*
	 * 借款人姓名
	 * */
	private String borrowerName;
	/*
	 * 借款人身份证号
	 * */
	private String borrowerCardNo;
	/*
	 * 库存状态
	 * (1：正常，2：注销)
	 * */
	private String status;
	/*
	 * 库存序号
	 * */
	private String projectNumber;
	/*
	 * 他项类型 他项类型1：不动产抵押权
	2：不动产预告登记
	3：预告登记证明
	4：机动车登记证明
	（押品类型为房产时可选1、2、3；押品为机动车时选4）
	 * */
	private String otherType;
	/*
	 * 他项权证号
	 * */
	private String  otherWarrantsNumber;  
	/*
	 * 入库的时间
	 * */
	private String insertTime;
	/*
	 * 操作事项
	 * */
	private String operatingMatters;
	/*
	 * 出库记录
	 * */
	private String  borrowerLog;
	/*
	 * 外借数量
	 * */
	private String borrowerNums;
	/*
	 * 经办客户经理
	 * */
	private String mangerName;
	/*
	 * 交接人
	 * */
	private String nextName;   
	
	//借款合同号
	private String borrowerContractno;
	public String getId() {
		return id;
	}
	public String getWarrantsId() {
		return warrantsId;
	}
	public String getPropertyNo() {
		return propertyNo;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public String getPropertyCardNo() {
		return propertyCardNo;
	}
	public String getPropertyAddres() {
		return propertyAddres;
	}
	public String getPropertyNums() {
		return propertyNums;
	}
	public String getPropertyDate() {
		return propertyDate;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setWarrantsId(String warrantsId) {
		this.warrantsId = warrantsId;
	}
	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public void setPropertyCardNo(String propertyCardNo) {
		this.propertyCardNo = propertyCardNo;
	}
	public void setPropertyAddres(String propertyAddres) {
		this.propertyAddres = propertyAddres;
	}
	public void setPropertyNums(String propertyNums) {
		this.propertyNums = propertyNums;
	}
	public void setPropertyDate(String propertyDate) {
		this.propertyDate = propertyDate;
	}
	public String getNoRegisterSign() {
		return noRegisterSign;
	}
	public void setNoRegisterSign(String noRegisterSign) {
		this.noRegisterSign = noRegisterSign;
	}
	
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public String getOtherWarrantsNumber() {
		return otherWarrantsNumber;
	}
	public void setOtherWarrantsNumber(String otherWarrantsNumber) {
		this.otherWarrantsNumber = otherWarrantsNumber;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	public String getOperatingMatters() {
		return operatingMatters;
	}
	public void setOperatingMatters(String operatingMatters) {
		this.operatingMatters = operatingMatters;
	}
	public String getBorrowerLog() {
		return borrowerLog;
	}
	public void setBorrowerLog(String borrowerLog) {
		this.borrowerLog = borrowerLog;
	}
	public String getBorrowerNums() {
		return borrowerNums;
	}
	public void setBorrowerNums(String borrowerNums) {
		this.borrowerNums = borrowerNums;
	}
	public String getMangerName() {
		return mangerName;
	}
	public void setMangerName(String mangerName) {
		this.mangerName = mangerName;
	}
	public String getNextName() {
		return nextName;
	}
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}
	public String getBorrowerContractno() {
		return borrowerContractno;
	}
	public void setBorrowerContractno(String borrowerContractno) {
		this.borrowerContractno = borrowerContractno;
	}
	public String getBorrowerCardNo() {
		return borrowerCardNo;
	}
	public void setBorrowerCardNo(String borrowerCardNo) {
		this.borrowerCardNo = borrowerCardNo;
	}

	
}
