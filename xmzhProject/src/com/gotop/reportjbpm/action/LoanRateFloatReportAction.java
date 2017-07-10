 package com.gotop.reportjbpm.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.LoanRateFloatReport;
import com.gotop.reportjbpm.service.ILoanRateFloatReportService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

public class LoanRateFloatReportAction extends BaseAction {
	
	private LoanRateFloatReport loanRateFloatReport;
	private List<LoanRateFloatReport> loanRateFloatReportList = new ArrayList<LoanRateFloatReport>();
	private ILoanRateFloatReportService loanRateFloatReportService;
	
	private String orgid;
	
	
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	public LoanRateFloatReport getLoanRateFloatReport() {
		return loanRateFloatReport;
	}
	public void setLoanRateFloatReport(LoanRateFloatReport loanRateFloatReport) {
		this.loanRateFloatReport = loanRateFloatReport;
	}
	public List<LoanRateFloatReport> getLoanRateFloatReportList() {
		return loanRateFloatReportList;
	}
	public void setLoanRateFloatReportList(
			List<LoanRateFloatReport> loanRateFloatReportList) {
		this.loanRateFloatReportList = loanRateFloatReportList;
	}
	
	public ILoanRateFloatReportService getLoanRateFloatReportService() {
		return loanRateFloatReportService;
	}
	public void setLoanRateFloatReportService(
			ILoanRateFloatReportService loanRateFloatReportService) {
		this.loanRateFloatReportService = loanRateFloatReportService;
	}
	/**
	 * 查询贷款利率浮动情况
	 * @return
	 */
	public String loanRateFloatReportList(){
		MUOUserSession muo = getCurrentOnlineUser();
		System.out.println("一级支行："+loanRateFloatReport.getOrgCodeOne()+"-名称："+loanRateFloatReport.getOrgNameOne());
		System.out.println("贷种分类："+loanRateFloatReport.getLoanCategoryId()+"-"+loanRateFloatReport.getLoanCategory());
		System.out.println("1："+loanRateFloatReport.getRateStart()+"-2-"+loanRateFloatReport.getRateEnd());
		loanRateFloatReportList = loanRateFloatReportService.queryLoanRateFloatReport(muo,loanRateFloatReport,this.getPage());
		this.setPage(page);
		this.setLoanRateFloatReportList(loanRateFloatReportList);
		return "LoanRateFloatReportList";
	}
	/**
	 * 查询贷款利率浮动情况_导出excel
	 * 
	 * @return
	 */
	public String loanRateFloatReportExcel(){
		MUOUserSession muo = getCurrentOnlineUser();
		loanRateFloatReportList = loanRateFloatReportService.queryLoanRateFloatReportExcel(muo,loanRateFloatReport);
		this.setLoanRateFloatReportList(loanRateFloatReportList);
		return "LoanRateFloatReportListExcel";
	}
	
	/**
	 * 判断当前机构是部门还是支行
	 */
	public void judgeIsDept(){
		String info ="";
		
		String orgid = this.getOrgid();
		HashMap<String,Object> map = loanRateFloatReportService.queryOrgInfoById(orgid);
		if(map != null){
			//若上级机构是“厦门分行”，并且当前机构不是“一类支行”说明是部门
			if( "5425".equals(map.get("PARENTORGID").toString() )  &&   !"一类支行".equals(map.get("ORGNAME")) ){
				info = "yes"; //说明是部门
			}else{
				info = "no"; //说明是支行
			}
		}
		
		if(!"".equals(info)){
			//info ="success";
			Struts2Utils.renderText(info);
		}else{
			info="fails";
			Struts2Utils.renderText(info);
		}
	}
	

}
