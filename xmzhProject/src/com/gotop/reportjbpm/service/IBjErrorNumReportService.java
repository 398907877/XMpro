package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IBjErrorNumReportService {
	/**
	 * 笔均差错数统计查询
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<BjErrorNumReport> queryBjErrorNumReportList(MUOUserSession muo, BjErrorNumReport bjErrorNumReport, Page page);
	/**
	 * 笔均差错数统计导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<BjErrorNumReport> queryBjErrorNumReportListForExcel(MUOUserSession muo, BjErrorNumReport bjErrorNumReport);
	
	

}
