package com.gotop.timeMachine.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProcessUsedTime implements Serializable {
    /**
     * 主键 .
     * @abatorgenerated
     */
    private Long id;

    /**
     * 一级支行 .
     * @abatorgenerated
     */
    private String orgCodeOne;

    /**
     * 二级支行
     * @abatorgenerated
     */
    private String orgCodeTwo;

    /**
     * 一级支行名称 .
     * @abatorgenerated
     */
    private String orgNameOne;

    /**
     * 二级支行支行名称
     * @abatorgenerated
     */
    private String orgNameTwo;
    /**
     * 一级分类
     * @abatorgenerated
     */
    private  String  oneCategory;
    /**
     * 贷种分类
     * @abatorgenerated
     */
    private String loanCategory;
    /**
     * 时限类型
     * @abatorgenerated
     */
    private String timeLimitType;
    /**
     * 天数
     * @abatorgenerated
     */
    private String daysDealNum;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrgCodeOne() {
		return orgCodeOne;
	}
	public void setOrgCodeOne(String orgCodeOne) {
		this.orgCodeOne = orgCodeOne;
	}
	public String getOrgCodeTwo() {
		return orgCodeTwo;
	}
	public void setOrgCodeTwo(String orgCodeTwo) {
		this.orgCodeTwo = orgCodeTwo;
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
	public String getTimeLimitType() {
		return timeLimitType;
	}
	public void setTimeLimitType(String timeLimitType) {
		this.timeLimitType = timeLimitType;
	}
	public String getDaysDealNum() {
		return daysDealNum;
	}
	public void setDaysDealNum(String daysDealNum) {
		this.daysDealNum = daysDealNum;
	}
    
    
    
}