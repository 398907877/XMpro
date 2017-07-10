package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.jbpm.model.XdCdtypeBean;
import com.gotop.reportjbpm.model.ReportRefusalrate;
import com.gotop.reportjbpm.service.TReportRefusalrateService;
import com.primeton.utils.Page;

public class ReportRefusalrateAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8547644353737023333L;
	private ReportRefusalrate reportRefusalrate;
	private List<ReportRefusalrate> list = new ArrayList<ReportRefusalrate>();
	private TReportRefusalrateService reportRefusalRateService;
//合计
	private List<ReportRefusalrate> listSum = new ArrayList<ReportRefusalrate>();
    
	
	public List<ReportRefusalrate> getListSum() {
		return listSum;
	}
	public void setListSum(List<ReportRefusalrate> listSum) {
		this.listSum = listSum;
	}
	public ReportRefusalrate getReportRefusalrate() {
		return reportRefusalrate;
	}
	public void setReportRefusalrate(ReportRefusalrate reportRefusalrate) {
		this.reportRefusalrate = reportRefusalrate;
	}
	public TReportRefusalrateService getReportRefusalRateService() {
		return reportRefusalRateService;
	}
	public void setReportRefusalRateService(
			TReportRefusalrateService reportRefusalRateService) {
		this.reportRefusalRateService = reportRefusalRateService;
	}
	public List<ReportRefusalrate> getList() {
		return list;
	}
	public void setList(List<ReportRefusalrate> list) {
		this.list = list;
	}

	/**
	 * 查询拒贷信息
	 * @return
	 */
	public String queryReportRefusalRate(){
		list=reportRefusalRateService.selectReportRefusalRate(reportRefusalrate,this.getPage());
		listSum=reportRefusalRateService.selectReportRefusalRateSum(reportRefusalrate);
		this.setListSum(listSum);
		this.setList(list);
		return"queryReportRefusalRate";
	}
	/**
	 * 查询拒贷信息_导出excel
	 * 
	 * @return
	 */
	public String queryReportRefusalrateExcel(){
		if(reportRefusalrate==null){
			reportRefusalrate=new ReportRefusalrate();
		}
		listSum=reportRefusalRateService.selectReportRefusalRateSum(reportRefusalrate);
		this.setListSum(listSum);
		list = reportRefusalRateService.queryReportRefusalrateExcel(reportRefusalrate);
		this.setList(list);
		return "queryReportRefusalrateExcel";
	}
	
	
	
}
