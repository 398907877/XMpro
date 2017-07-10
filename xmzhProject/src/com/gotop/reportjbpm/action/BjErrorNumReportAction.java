package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.reportjbpm.service.IBjErrorNumReportService;
import com.gotop.vo.system.MUOUserSession;

public class BjErrorNumReportAction extends BaseAction {
	private BjErrorNumReport bjErrorNumReport;
	private IBjErrorNumReportService bjErrorNumReportService;
	private List<BjErrorNumReport> bjErrorNumReportList =new ArrayList<BjErrorNumReport>();
	
	
	public BjErrorNumReport getBjErrorNumReport() {
		return bjErrorNumReport;
	}
	public void setBjErrorNumReport(BjErrorNumReport bjErrorNumReport) {
		this.bjErrorNumReport = bjErrorNumReport;
	}
	public IBjErrorNumReportService getBjErrorNumReportService() {
		return bjErrorNumReportService;
	}
	public void setBjErrorNumReportService(
			IBjErrorNumReportService bjErrorNumReportService) {
		this.bjErrorNumReportService = bjErrorNumReportService;
	}
	public List<BjErrorNumReport> getBjErrorNumReportList() {
		return bjErrorNumReportList;
	}
	public void setBjErrorNumReportList(List<BjErrorNumReport> bjErrorNumReportList) {
		this.bjErrorNumReportList = bjErrorNumReportList;
	}
	/**
	 * 笔均差错数统计
	 * @return
	 */
	public String bjErrorNumReportList(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		bjErrorNumReportList=bjErrorNumReportService.queryBjErrorNumReportList(muo,bjErrorNumReport,this.getPage());
		this.setPage(page);
		this.setBjErrorNumReportList(bjErrorNumReportList);
		return  "QueryBjErrorNumReportList";
	}
	/**
	 * 笔均差错数统计导出excel
	 * @return
	 */
	public String bjErrorNumReportExcel(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		bjErrorNumReportList=bjErrorNumReportService.queryBjErrorNumReportListForExcel(muo,bjErrorNumReport);
		this.setBjErrorNumReportList(bjErrorNumReportList);
		return  "QueryBjErrorNumReportForExcel";
	}
	
	
	
	

}
