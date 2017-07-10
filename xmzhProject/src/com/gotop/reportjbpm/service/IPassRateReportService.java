package com.gotop.reportjbpm.service;

import java.util.List;

import com.gotop.reportjbpm.model.PassRateReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IPassRateReportService {
	/**
	 * 通过率统计查询
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<PassRateReport> queryPassRateReportList(MUOUserSession muo, PassRateReport passRateReport, Page page);
	/**
	 * 通过率统计导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<PassRateReport> queryPassRateReportListForExcel(MUOUserSession muo, PassRateReport passRateReport);
	
	

}
