 package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.LoanRateFloatReport;
import com.gotop.reportjbpm.service.ILoanRateFloatReportService;
import com.gotop.vo.system.MUOUserSession;

public class LoanRateFloatReportAction extends BaseAction {
	private LoanRateFloatReport loanRateFloatReport;
	private List<LoanRateFloatReport> loanRateFloatReportList = new ArrayList<LoanRateFloatReport>();
	private ILoanRateFloatReportService loanRateFloatReportService;
	
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

}
