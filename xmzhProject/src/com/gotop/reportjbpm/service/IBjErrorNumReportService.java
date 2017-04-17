package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.primeton.utils.Page;

public interface IBjErrorNumReportService {
	/**
	 * 笔均差错数统计查询
	 * @param approval
	 * @param page
	 * @return
	 */
	List<BjErrorNumReport> queryBjErrorNumReportList(BjErrorNumReport bjErrorNumReport, Page page);
	/**
	 * 笔均差错数统计导出excel
	 * @param approval
	 * @param page
	 * @return
	 */
	List<BjErrorNumReport> queryBjErrorNumReportListForExcel(BjErrorNumReport bjErrorNumReport);
	
	

}
