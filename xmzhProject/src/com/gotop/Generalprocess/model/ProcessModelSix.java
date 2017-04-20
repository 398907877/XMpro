package com.gotop.Generalprocess.model;

import java.io.Serializable;


import com.gotop.Generalprocess.annonation.GeneralprocessField;
/**
 * 
 * @author wujiajun
 * 
 *
 */
public class ProcessModelSix  extends ProcessModel  implements  Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	


    /**
     * 流程id .
     * @abatorgenerated
     */
	
	@GeneralprocessField(name="流程id",type="text",hidden=false)
    private String flowId;



    /**
     * 抵押送件时间 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="抵押送件时间",type="text")
    private String mortgageTime;

    /**
     * 收到他项时间 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="收到他项时间",type="text")
    private String receiveTime;

    /**
     * 公积金中心申请时间 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="公积金中心申请时间",type="text")
    private String applicationTime;

    /**
     * 公积金中心下达放款指标时间 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="公积金中心下达放款指标时间",type="text")
    private String issuedTime;

	
	/**
     * 支用金额币别
     * @abatorgenerated
     */
	@GeneralprocessField(name="支用金额币别",type="dic",dicname="PROCESS_MONEY")
    private String supportMoneyType;
	

    /**
     * 支用金额 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="支用金额",type="money")
    private String supportMoney;
	
	 /**
     * 一级分类.
     * @author yyx
     */
	@GeneralprocessField(name="一级分类",type="text")
	private String  oneCategory;
	
	 /**
     * 贷种分类 .
     * @author yyx
     */
	@GeneralprocessField(name="贷种分类",type="text")
	private String   loanCategory;
	

	/**
     * 客户评级 
     * @author lmt
     */
	@GeneralprocessField(name="客户评级",type="text")
	private String   cust_grade;
	
	/**
     * 基准利率浮动
     * @author lmt
     */
	@GeneralprocessField(name="基准利率浮动",type="dic",dicname="PROCESS_BASICRATEFLOAT")
	private String   basic_rate_float;
	
	/**
     * 利率浮动比例
     * @author lmt
     */
	@GeneralprocessField(name="利率浮动比例",type="text")
	private String   rate_float_scale;
	
	
    /**
     * 支用类别 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="支用类别",type="dic",dicname="PROCESS_pay")
    private String supportCategory;
	
    
	
	

	

    /**
     * 是否风险额度重检 .
     * @abatorgenerated
     */
	
	@GeneralprocessField(name="是否风险额度重检",type="dic",dicname="PROCESS_QuotaCheck")
    private String risk;

    /**
     * 处理意见 .
     * @abatorgenerated
     */
	@GeneralprocessField(name="处理意见",type="text")
    private String processingOpinion;
	
	
    /**
     * 客户姓名
     * @abatorgenerated
     */
	@GeneralprocessField(name="客户姓名",type="text")
    private String custName;
	
	
	
	
	@GeneralprocessField(name="是否抵押",type="dic",dicname="PROCESS_sixyesnot")
	private  String yesOrNotRisk;
	
	
	
	@GeneralprocessField(name="附件下载",type="fileCont")
	private String fileCont;
	

	public String getFileCont() {
		return fileCont;
	}

	public void setFileCont(String fileCont) {
		this.fileCont =flowId+","+fileCont+",mod6";
	}

	
	
	
	
	
	
	

	public String getYesOrNotRisk() {
		return yesOrNotRisk;
	}

	public void setYesOrNotRisk(String yesOrNotRisk) {
		this.yesOrNotRisk = yesOrNotRisk;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

	public String getMortgageTime() {
		return mortgageTime;
	}

	public void setMortgageTime(String mortgageTime) {
		this.mortgageTime = mortgageTime;
	}

	public String getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	public String getIssuedTime() {
		return issuedTime;
	}

	public void setIssuedTime(String issuedTime) {
		this.issuedTime = issuedTime;
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

	public String getSupportCategory() {
		return supportCategory;
	}

	public void setSupportCategory(String supportCategory) {
		this.supportCategory = supportCategory;
	}

	public String getSupportMoney() {
		return supportMoney;
	}

	public void setSupportMoney(String supportMoney) {
		this.supportMoney = supportMoney;
	}

	public String getRisk() {
		return risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	public String getProcessingOpinion() {
		return processingOpinion;
	}

	public void setProcessingOpinion(String processingOpinion) {
		this.processingOpinion = processingOpinion;
	}

	public String getSupportMoneyType() {
		return supportMoneyType;
	}

	public void setSupportMoneyType(String supportMoneyType) {
		this.supportMoneyType = supportMoneyType;
	}

	public String getCust_grade() {
		return cust_grade;
	}

	public void setCust_grade(String cust_grade) {
		this.cust_grade = cust_grade;
	}

	public String getBasic_rate_float() {
		return basic_rate_float;
	}

	public void setBasic_rate_float(String basic_rate_float) {
		this.basic_rate_float = basic_rate_float;
	}

	public String getRate_float_scale() {
		return rate_float_scale;
	}

	public void setRate_float_scale(String rate_float_scale) {
		this.rate_float_scale = rate_float_scale;
	}

	
	
	////
	
	
	
	
	
	

}
