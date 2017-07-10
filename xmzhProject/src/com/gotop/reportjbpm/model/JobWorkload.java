/**
 * 
 */
package com.gotop.reportjbpm.model;

/**
 * @author gotop
 *
 */
public class JobWorkload {
	
	
	//审批时间开始
	private String appTimeStrat;
	//结束时间
	private String appTimeEnd;
	
	//第一次派单时间 开始
	private String pdtimeOne_start;
	//第一次派单时间 结束
	private String pdtimeOne_end;
	
	//第一次派单时间
	private String pdtimeOne;
		
   //一级分类
	private String oneCategory;
	//贷种分类
	private String loanCategory;
	//流程节点
	private String processNodeName;
	//人员姓名
	private String personName;
	//1次业务数量
	private String businessNumberOne;
	//2次业务数量
	private String businessNumberTwo;
	//3次业务数量
	private String businessNumberThree;
	//4次业务数量
	private String businessNumberFour;
	//5次业务数量
	private String businessNumberFive;
	public String getAppTimeStrat() {
		return appTimeStrat;
	}
	public void setAppTimeStrat(String appTimeStrat) {
		this.appTimeStrat = appTimeStrat;
	}
	public String getAppTimeEnd() {
		return appTimeEnd;
	}
	public void setAppTimeEnd(String appTimeEnd) {
		this.appTimeEnd = appTimeEnd;
	}
	public String getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(String oneCategory) {
		this.oneCategory = oneCategory;
	}
	public String getLoanCategory() {
		return loanCategory;
	}
	public void setLoanCategory(String loanCategory) {
		this.loanCategory = loanCategory;
	}
	public String getProcessNodeName() {
		return processNodeName;
	}
	public void setProcessNodeName(String processNodeName) {
		this.processNodeName = processNodeName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getBusinessNumberOne() {
		return businessNumberOne;
	}
	public void setBusinessNumberOne(String businessNumberOne) {
		this.businessNumberOne = businessNumberOne;
	}
	public String getBusinessNumberTwo() {
		return businessNumberTwo;
	}
	public void setBusinessNumberTwo(String businessNumberTwo) {
		this.businessNumberTwo = businessNumberTwo;
	}
	public String getBusinessNumberThree() {
		return businessNumberThree;
	}
	public void setBusinessNumberThree(String businessNumberThree) {
		this.businessNumberThree = businessNumberThree;
	}
	public String getBusinessNumberFour() {
		return businessNumberFour;
	}
	public void setBusinessNumberFour(String businessNumberFour) {
		this.businessNumberFour = businessNumberFour;
	}
	public String getBusinessNumberFive() {
		return businessNumberFive;
	}
	public void setBusinessNumberFive(String businessNumberFive) {
		this.businessNumberFive = businessNumberFive;
	}
	public String getPdtimeOne_start() {
		return pdtimeOne_start;
	}
	public void setPdtimeOne_start(String pdtimeOne_start) {
		this.pdtimeOne_start = pdtimeOne_start;
	}
	public String getPdtimeOne_end() {
		return pdtimeOne_end;
	}
	public void setPdtimeOne_end(String pdtimeOne_end) {
		this.pdtimeOne_end = pdtimeOne_end;
	}
	public String getPdtimeOne() {
		return pdtimeOne;
	}
	public void setPdtimeOne(String pdtimeOne) {
		this.pdtimeOne = pdtimeOne;
	}
	
	
}
