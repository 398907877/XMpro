package com.gotop.mortgage.model;





public class MortgageList {
	//总记录数
	private String alls;
	private String cars;
	private String others;
	//出入库类型
	private String type;
	
	public String getCars() {
		return cars;
	}
	public void setCars(String cars) {
		this.cars = cars;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	/*
	 * 主键id
	 * */
	private String id;
	/*
	 * 押品类型
	 * */
	private String mortgageType;
	/*
	 * 项目id
	 * */
	private String warrantsId;
	/*
	 * 外借数量
	 * */
	private String borrowerNums;
	/*
	 * 出库记录
	 * */
	private String borrowerLog;
	/*
	 * 操作事项(全部、外借、注销、同注同抵、领取、其他）
	 * */
	private String operatingMatters;
	/*
	 * 备注信息
	 * */
	private String remark;
	/*
	 * 操作时间（出入库时间）
	 * */
	private String operatingTime;
	//出入库的查询的截止时间
	private String operatingEndTime;
	/*
	 * 库存序号
	 * */
	private String projectNumber;
	/*
	 *产权证号 
	 * */
	private String propertyNo;
	/*
	 * 产权证数
	 * */
	private String propertyNums;
	/*
	 * 他项权证数
	 * */
	private String otherWarrantsNums;
	/*
	 * 产权人姓名
	 * */
	private String propertyName;
	/*
	 * 他项权证号
	 * */
	private String otherWarrantsNumber;  
	/*
	 * 操作人员
	 * */
	private String operatingUserId;
	/*
	 * 交接人
	 * */
	private String nextName;  
	/*
	 * 备注
	 * */
	private String operatingRemark;
	/*
	 * 操作类型(出库、入库、库存变更、新增入库等)
	 * */
	private String operatingType;
	/*
	 *车牌号
	 * */
	private String carNo;
	/*
	 * 车主姓名
	 * */
	private String carName;
	/*
	 * 库存状态
	 * (1：正常，2：注销)
	 * */
	private String status;
	/*
	 * 是否外借
	 * */
	private String isBorrow;
	/*
	 * 操作对应权证id(操作日志的外键)
	 * */
	private String operatingMortgagId;
	
	/*
	 * 注销是否入库
	 * */
	private String checkboxStatus;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWarrantsId() {
		return warrantsId;
	}
	public void setWarrantsId(String warrantsId) {
		this.warrantsId = warrantsId;
	}
	
	public String getBorrowerNums() {
		return borrowerNums;
	}
	public void setBorrowerNums(String borrowerNums) {
		this.borrowerNums = borrowerNums;
	}
	public String getBorrowerLog() {
		return borrowerLog;
	}
	public void setBorrowerLog(String borrowerLog) {
		this.borrowerLog = borrowerLog;
	}
	public String getOperatingMatters() {
		return operatingMatters;
	}
	public void setOperatingMatters(String operatingMatters) {
		this.operatingMatters = operatingMatters;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMortgageType() {
		return mortgageType;
	}
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public String getOperatingTime() {
		return operatingTime;
	}
	public void setOperatingTime(String operatingTime) {
		this.operatingTime = operatingTime;
	}
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getPropertyNo() {
		return propertyNo;
	}
	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getOtherWarrantsNumber() {
		return otherWarrantsNumber;
	}
	public void setOtherWarrantsNumber(String otherWarrantsNumber) {
		this.otherWarrantsNumber = otherWarrantsNumber;
	}
	public String getOperatingUserId() {
		return operatingUserId;
	}
	public void setOperatingUserId(String operatingUserId) {
		this.operatingUserId = operatingUserId;
	}
	public String getNextName() {
		return nextName;
	}
	public void setNextName(String nextName) {
		this.nextName = nextName;
	}
	public String getOperatingRemark() {
		return operatingRemark;
	}
	public void setOperatingRemark(String operatingRemark) {
		this.operatingRemark = operatingRemark;
	}
	public String getOperatingType() {
		return operatingType;
	}
	public void setOperatingType(String operatingType) {
		this.operatingType = operatingType;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsBorrow() {
		return isBorrow;
	}
	public void setIsBorrow(String isBorrow) {
		this.isBorrow = isBorrow;
	}
	public String getOperatingMortgagId() {
		return operatingMortgagId;
	}
	public void setOperatingMortgagId(String operatingMortgagId) {
		this.operatingMortgagId = operatingMortgagId;
	}
	public String getOperatingEndTime() {
		return operatingEndTime;
	}
	public void setOperatingEndTime(String operatingEndTime) {
		this.operatingEndTime = operatingEndTime;
	}
	public String getPropertyNums() {
		return propertyNums;
	}
	public void setPropertyNums(String propertyNums) {
		this.propertyNums = propertyNums;
	}
	public String getOtherWarrantsNums() {
		return otherWarrantsNums;
	}
	public void setOtherWarrantsNums(String otherWarrantsNums) {
		this.otherWarrantsNums = otherWarrantsNums;
	}
	public String getAlls() {
		return alls;
	}
	public void setAlls(String alls) {
		this.alls = alls;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCheckboxStatus() {
		return checkboxStatus;
	}
	public void setCheckboxStatus(String checkboxStatus) {
		this.checkboxStatus = checkboxStatus;
	}
	
	
}
