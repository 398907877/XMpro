package com.gotop.Generalprocess.model;

import java.io.Serializable;

import com.gotop.Generalprocess.annonation.GeneralprocessField;


/**
 * 
 * @author wujiajun
 * @desc  节点模式1 的实体类  
 * @version 1.0
 * 
 **/
public class ProcessModelOne extends ProcessModel  implements  Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	@GeneralprocessField(name="模式一编号,信贷业务编号",type="text",hidden=false)
	private  Long   processModelOneID;
	
	@GeneralprocessField(name="流程ID",type="text",hidden=false)
	private  String  flow_Id;
	
	/**
	 * 受理支行一	名称
	 */
	@GeneralprocessField(name="受理支行（一级选项）",type="text")
	private String orgNameOne;
	
	/**
	 * 受理支行二	名称
	 */
	@GeneralprocessField(name="受理支行（二级选项）",type="text")
	private String orgNameTwo;
	
	@GeneralprocessField(name="受理支行（一级选项）",type="text",hidden=false)
	private  String   orgCodeOne;
	
	@GeneralprocessField(name="受理支行（二级选项）",type="text",hidden=false)
	private  String   orgCodeTwo;
	
	/**
	 * 主调信贷员	姓名
	 */
	@GeneralprocessField(name="主调信贷员",type="text")
	private String creatorName;
	
	@GeneralprocessField(name="主调信贷员",type="text",hidden=false)
	private String  creator;
	
	@GeneralprocessField(name="辅调信贷员",type="text")
	private String  fdxdy;
	
	@GeneralprocessField(name="营业主管",type="text")
	private String  yxzg;
	
	@GeneralprocessField(name="营销人员",type="text")
	private String  yxry;
	
	@GeneralprocessField(name="营销人员机构",type="text")
	private String   yxryjg;
	
	
	
	@GeneralprocessField(name="客户名称",type="text")
	private String   cust_Name;
	@GeneralprocessField(name="抵押物权属人姓名",type="text")
	private String   dywx_Name;
	
	
	
	@GeneralprocessField(name="申请币别",type="dic",dicname="PROCESS_MONEY")
	private String  currency;
	
	@GeneralprocessField(name="申请金额",type="money")
	private String  apply_bal;
	
	@GeneralprocessField(name="一级分类",type="text")
	private String  oneCategory;
	
	@GeneralprocessField(name="贷种分类",type="text")
	private String   loanCategory;
	
	
	
	@GeneralprocessField(name="客户评级",type="text")
	private String   cust_grade;
	
	@GeneralprocessField(name="基准利率浮动",type="dic",dicname="PROCESS_BASICRATEFLOAT")
	private String   basic_rate_float;
	
	@GeneralprocessField(name="利率浮动比例",type="text")
	private String   rate_float_scale;
	

	
	@GeneralprocessField(name="合作机构",type="text")
	private String   coOrganization;
	
	@GeneralprocessField(name="调查时间",type="text")
	private String   survey_Time;
	
	@GeneralprocessField(name="超限说明",type="text")
	private String  content;
	

	
	
	@GeneralprocessField(name="创建日期",type="text",hidden=false)
	private String    create_Date;
	
	@GeneralprocessField(name="创建时间",type="text",hidden=false)
	private String    create_time;
	
	@GeneralprocessField(name="创建人姓名",type="text",hidden=false)
	private String     create_name;
	
	@GeneralprocessField(name="最后修改日期",type="text",hidden=false)
	private String last_up_date;
	
	@GeneralprocessField(name="最后修改时间",type="text",hidden=false)
	private String last_up_time;
	
	@GeneralprocessField(name="最后操作员",type="text",hidden=false)
	private String    last_up_name;
	
	
	
	@GeneralprocessField(name="处理意见",type="text")
	private String    hanldOption;
	
	
	@GeneralprocessField(name="是否老顾客",type="dic",dicname="ZHPT_LGK")
	private String  old_Cust;
	
	@GeneralprocessField(name="借款人工作单位",type="text")
	private String   borr_Unit;
	
	@GeneralprocessField(name="借款人配偶工作单位",type="text")
	private String borrSpouse_Unit;
	
	@GeneralprocessField(name="共同借款人工作单位",type="text")
    private String comBorr_Unit; 
	
	@GeneralprocessField(name="共同借款人配偶工作单位",type="text")
    private String comBorrSpouse_Unit;
	
	@GeneralprocessField(name="附件下载",type="fileCont")
	private String fileCont;
	

	public String getFileCont() {
		return fileCont;
	}

	public void setFileCont(String fileCont) {
		this.fileCont =flow_Id+","+fileCont+",mod1";
	}
	
	public String getComBorrSpouse_Unit() {
		return comBorrSpouse_Unit;
	}
	public void setComBorrSpouse_Unit(String comBorrSpouse_Unit) {
		this.comBorrSpouse_Unit = comBorrSpouse_Unit;
	}
	public String getComBorr_Unit() {
		return comBorr_Unit;
	}
	public void setComBorr_Unit(String comBorr_Unit) {
		this.comBorr_Unit = comBorr_Unit;
	}
	public String getBorrSpouse_Unit() {
		return borrSpouse_Unit;
	}
	public void setBorrSpouse_Unit(String borrSpouse_Unit) {
		this.borrSpouse_Unit = borrSpouse_Unit;
	}
	public String getBorr_Unit() {
		return borr_Unit;
	}
	public void setBorr_Unit(String borr_Unit) {
		this.borr_Unit = borr_Unit;
	}
	public String getOld_Cust() {
		return old_Cust;
	}
	public void setOld_Cust(String old_Cust) {
		this.old_Cust = old_Cust;
	}
	public String getHanldOption() {
		return hanldOption;
	}
	public void setHanldOption(String hanldOption) {
		this.hanldOption = hanldOption;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
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
	public Long getProcessModelOneID() {
		return processModelOneID;
	}
	public void setProcessModelOneID(Long processModelOneID) {
		this.processModelOneID = processModelOneID;
	}
	public String getFlow_Id() {
		return flow_Id;
	}
	public void setFlow_Id(String flow_Id) {
		this.flow_Id = flow_Id;
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
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getFdxdy() {
		return fdxdy;
	}
	public void setFdxdy(String fdxdy) {
		this.fdxdy = fdxdy;
	}
	public String getYxzg() {
		return yxzg;
	}
	public void setYxzg(String yxzg) {
		this.yxzg = yxzg;
	}
	public String getYxry() {
		return yxry;
	}
	public void setYxry(String yxry) {
		this.yxry = yxry;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getApply_bal() {
		return apply_bal;
	}
	public void setApply_bal(String apply_bal) {
		this.apply_bal = apply_bal;
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

	public String getDywx_Name() {
		return dywx_Name;
	}
	public void setDywx_Name(String dywx_Name) {
		this.dywx_Name = dywx_Name;
	}
	public String getCoOrganization() {
		return coOrganization;
	}
	public void setCoOrganization(String coOrganization) {
		this.coOrganization = coOrganization;
	}
	public String getSurvey_Time() {
		return survey_Time;
	}
	public void setSurvey_Time(String survey_Time) {
		this.survey_Time = survey_Time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getCreate_Date() {
		return create_Date;
	}
	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getCreate_name() {
		return create_name;
	}
	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}
	public String getLast_up_date() {
		return last_up_date;
	}
	public void setLast_up_date(String last_up_date) {
		this.last_up_date = last_up_date;
	}
	public String getLast_up_time() {
		return last_up_time;
	}
	public void setLast_up_time(String last_up_time) {
		this.last_up_time = last_up_time;
	}
	public String getLast_up_name() {
		return last_up_name;
	}
	public void setLast_up_name(String last_up_name) {
		this.last_up_name = last_up_name;
	}
	public String getYxryjg() {
		return yxryjg;
	}

	public void setYxryjg(String yxryjg) {
		this.yxryjg = yxryjg;
	}
	
	
	
	
	
}
