 package com.gotop.reportjbpm.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.reportjbpm.model.ErrorStatistic;
import com.gotop.reportjbpm.service.IErrorStatisticService;

public class ErrorStatisticAction extends BaseAction {
	private ErrorStatistic errorStatistic;
	private List<ErrorStatistic> errorStatisticList = new ArrayList<ErrorStatistic>();
	private IErrorStatisticService errorStatisticService;
	
	private String result_flag;
	
	
	public String getResult_flag() {
		return result_flag;
	}
	public void setResult_flag(String result_flag) {
		this.result_flag = result_flag;
	}
	public ErrorStatistic getErrorStatistic() {
		return errorStatistic;
	}
	public void setErrorStatistic(ErrorStatistic errorStatistic) {
		this.errorStatistic = errorStatistic;
	}
	public List<ErrorStatistic> getErrorStatisticList() {
		return errorStatisticList;
	}
	public void setErrorStatisticList(List<ErrorStatistic> errorStatisticList) {
		this.errorStatisticList = errorStatisticList;
	}
	public IErrorStatisticService getErrorStatisticService() {
		return errorStatisticService;
	}
	public void setErrorStatisticService(
			IErrorStatisticService errorStatisticService) {
		this.errorStatisticService = errorStatisticService;
	}
	/**
	 * 查询错误报表情况
	 * @return
	 */
	public String queryErrorStatistic(){
		errorStatisticList = errorStatisticService.queryErrorStatistic(errorStatistic,this.getPage());
		this.setPage(page);
		this.setErrorStatisticList(errorStatisticList);
		this.setResult_flag("1");//result_flag用于区别是普通查询('1') 还是 汇总查询('2')
		return "ErrorStatisticList";
	}
	/**
	 * 查询错误报表情况_导出excel
	 * 
	 * @return
	 */
	public String queryErrorStatisticForExcel(){
		errorStatisticList = errorStatisticService.queryErrorStatisticExcel(errorStatistic);
		this.setErrorStatisticList(errorStatisticList);
		return "ErrorStatisticListExcel";
	}
	
	
	/**
	 * 差错情况统计 汇总查询
	 * @return
	 */
	public String queryErrorStatisticSummary(){
		errorStatisticList = errorStatisticService.queryErrorStatisticSummary(errorStatistic,this.getPage());
		this.setPage(page);
		this.setErrorStatisticList(errorStatisticList);
		this.setResult_flag("2");//result_flag用于区别是普通查询('1') 还是 汇总查询('2')
		return "ErrorStatisticList";
	}
	
	/**
	 * 差错情况统计 汇总导出
	 * @return
	 */
	public String queryErrorStatisticSummaryForExcel(){
		errorStatisticList = errorStatisticService.queryErrorStatisticSummaryForExcel(errorStatistic);
		this.setErrorStatisticList(errorStatisticList);
		return "ErrorStatisticSummaryListExcel";
	}
	
	
	/**
	 * 查询所有差错环节
	 * @return
	 */
	public String querytaskNameList(){
		errorStatisticList = errorStatisticService.querytaskNameList();
		this.setErrorStatisticList(errorStatisticList);
		return "querytaskNameList";
	}
	

}
