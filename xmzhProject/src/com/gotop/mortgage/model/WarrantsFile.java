package com.gotop.mortgage.model;

public class WarrantsFile {
	
	private Long	fileId;  
	private String	warrantsId; 
	private String	fileName; 
	private String	filePath; 
	private String	creator; 
	private String	createDate; 
	private String	 fileReName;
	
	public Long getFileId() {
		return fileId;
	}
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	public String getWarrantsId() {
		return warrantsId;
	}
	public String getFileName() {
		return fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public String getCreator() {
		return creator;
	}
	public String getCreateDate() {
		return createDate;
	}
	public String getFileReName() {
		return fileReName;
	}
	public void setWarrantsId(String warrantsId) {
		this.warrantsId = warrantsId;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public void setFileReName(String fileReName) {
		this.fileReName = fileReName;
	} 


}
