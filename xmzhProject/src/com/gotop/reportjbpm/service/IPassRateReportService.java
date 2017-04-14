package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.PassRateReport;
import com.primeton.utils.Page;

public interface IPassRateReportService {
	/**
	 * 通过率统计查询
	 * @param approval
	 * @param page
	 * @return
	 */
	List<PassRateReport> queryPassRateReportList(PassRateReport passRateReport, Page page);
	/**
	 * 通过率统计导出excel
	 * @param approval
	 * @param page
	 * @return
	 */
	List<PassRateReport> queryPassRateReportListForExcel(PassRateReport passRateReport);
	
	

}
