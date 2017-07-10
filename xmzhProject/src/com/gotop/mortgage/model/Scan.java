package com.gotop.mortgage.model;

import java.io.Serializable;


public class Scan implements Serializable{
	private static final long serialVersionUID = 2232407149888537837L;
//  ID
	private String scanID;
//	操作时间
	private String operationTime;
//	扫描件种类
	private String scanType;	
//  扫描文件名
	private String fileName;
//  新文件名称
	private String fileReName;
//  关联的项目ID
	private String warrantsID;
//文件路径
	private String filePath;
//入库开始时间
	private String inTimeStart;
//入库截止时间
	private String inTimeEnd;
	
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public String getScanType() {
		return scanType;
	}
	public void setScanType(String scanType) {
		this.scanType = scanType;
	}
	public String getScanID() {
		return scanID;
	}
	public void setScanID(String scanID) {
		this.scanID = scanID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getWarrantsID() {
		return warrantsID;
	}
	public void setWarrantsID(String warrantsID) {
		this.warrantsID = warrantsID;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
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
	public String getFileReName() {
		return fileReName;
	}
	public void setFileReName(String fileReName) {
		this.fileReName = fileReName;
	}

	

}
