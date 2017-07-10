package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.PassRateReport;
import com.primeton.utils.Page;

public interface IPassRateReportDao {
/**
 * 通过率统计查询
 * @param map
 * @param page
 * @return
 */
	List<PassRateReport> queryPassRateReportList(Map<String, Object> map, Page page);
	/**
	 * 通过率统计导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<PassRateReport> queryPassRateReportListForExcel(Map<String, Object> map);
	List yesOrNot_dep(String orgcode);

}
