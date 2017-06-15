package com.gotop.mortgage.model;

import java.io.Serializable;

/**
 * 库存统计类
 * @author gotop
 *
 */
public class InventoryStat implements Serializable{
	private static final long serialVersionUID = 2232407149888537837L;
//  统计时间
	private String statTime;
// 押品类型
	private String mortgageType;
// 他项类型	
	private String otherType;	
// 贷种类型
	private String loanType;
// 数量
	private String num;
	
	
	
	
//  不动产抵押权-数量
	private String num1;
//	不动产登记预告-数量
	private String num2;
//	预告登记证明-数量
	private String num3;
//	小计-数量
	private String num4;
//	小企业--数量
	private String num5;	
//  零售-数量
	private String num6;
//  产权证-小企业-数量
	private String num7;
//  他项-汽车消费-数量
	private String num8;
//	他项-经营性车辆-数量
	private String num9;
//	机动车登记证-汽车消费-数量
	private String num10;
//	机动车登记证-经营性车辆-数量
	private String num11;
//	房产-他项--合计
	private String total1;	
//	房产-产权证--合计
	private String total2;	
//	机动车-他项--合计
	private String total3;	
//	机动车-机动车登记证--合计
	private String total4;
	
	

	
	public String getMortgageType() {
		return mortgageType;
	}
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	public String getOtherType() {
		return otherType;
	}
	public void setOtherType(String otherType) {
		this.otherType = otherType;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	
	
	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public String getNum3() {
		return num3;
	}
	public void setNum3(String num3) {
		this.num3 = num3;
	}
	public String getNum4() {
		return num4;
	}
	public void setNum4(String num4) {
		this.num4 = num4;
	}
	public String getNum5() {
		return num5;
	}
	public void setNum5(String num5) {
		this.num5 = num5;
	}
	public String getNum6() {
		return num6;
	}
	public void setNum6(String num6) {
		this.num6 = num6;
	}
	public String getNum7() {
		return num7;
	}
	public void setNum7(String num7) {
		this.num7 = num7;
	}
	public String getNum8() {
		return num8;
	}
	public void setNum8(String num8) {
		this.num8 = num8;
	}
	public String getNum9() {
		return num9;
	}
	public void setNum9(String num9) {
		this.num9 = num9;
	}
	public String getNum10() {
		return num10;
	}
	public void setNum10(String num10) {
		this.num10 = num10;
	}
	public String getNum11() {
		return num11;
	}
	public void setNum11(String num11) {
		this.num11 = num11;
	}
	public String getTotal1() {
		return total1;
	}
	public void setTotal1(String total1) {
		this.total1 = total1;
	}
	public String getTotal2() {
		return total2;
	}
	public void setTotal2(String total2) {
		this.total2 = total2;
	}
	public String getTotal3() {
		return total3;
	}
	public void setTotal3(String total3) {
		this.total3 = total3;
	}
	public String getTotal4() {
		return total4;
	}
	public void setTotal4(String total4) {
		this.total4 = total4;
	}
	public String getStatTime() {
		return statTime;
	}
	public void setStatTime(String statTime) {
		this.statTime = statTime;
	}	
	
	
	

}