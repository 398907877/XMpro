package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.PassRateReport;
import com.gotop.reportjbpm.service.IPassRateReportService;
import com.gotop.vo.system.MUOUserSession;

public class PassRateReportAction extends BaseAction {
	private PassRateReport passRateReport;
	private IPassRateReportService passRateReportService;
	private List<PassRateReport> passRateReportList =new ArrayList<PassRateReport>();
	
	
	public PassRateReport getPassRateReport() {
		return passRateReport;
	}
	public void setPassRateReport(PassRateReport passRateReport) {
		this.passRateReport = passRateReport;
	}
	public IPassRateReportService getPassRateReportService() {
		return passRateReportService;
	}
	public void setPassRateReportService(
			IPassRateReportService passRateReportService) {
		this.passRateReportService = passRateReportService;
	}
	
	public List<PassRateReport> getPassRateReportList() {
		return passRateReportList;
	}
	public void setPassRateReportList(List<PassRateReport> passRateReportList) {
		this.passRateReportList = passRateReportList;
	}
	/**
	 * 通过率统计
	 * @return
	 */
	public String queryPassRateReportList(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		passRateReportList=passRateReportService.queryPassRateReportList(muo,passRateReport,this.getPage());
		this.setPage(page);
		this.setPassRateReportList(passRateReportList);
		return  "QueryPassRateReportList";
	}
	/**
	 * 通过率统计导出excel
	 * @return
	 */
	public String queryPassRateReportListForExcel(){
		MUOUserSession muo = getCurrentOnlineUser();
		passRateReportList=passRateReportService.queryPassRateReportListForExcel(muo,passRateReport);
		this.setPassRateReportList(passRateReportList);
		return  "QueryPassRateReportForExcel";
	}
	
	
	
	

}
