package com.gotop.reportjbpm.service;

import java.util.HashMap;
import java.util.List;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IProcessUsedTimeReportService {
	/**
	 * 流程用时统计报表
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(MUOUserSession muo, ProcessUsedTimeReport processUsedTimeReport, Page page);
	
	/**
	 * 流程用时统计报表
	 * @param approval
	 * @param page
	 * @return
	 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportListTemp();
	/**
	 * 流程用时统计报表导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(MUOUserSession muo, ProcessUsedTimeReport processUsedTimeReport);
	
	/**
	 * 插入临时表PROCESS_USEDTIME_REPORT
	 * @param ProcessUsedTimeReportTemp
	 */
	public void insertProcessUsedTimeReportTemp(HashMap<String, String> hmp);
	
	List<ProcessUsedTimeReport> queryProcessUsedTimeType();
	
	Object queryReportUpdatetime();

}
