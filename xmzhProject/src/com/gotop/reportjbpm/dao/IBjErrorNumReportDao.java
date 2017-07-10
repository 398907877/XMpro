package com.gotop.reportjbpm.dao;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.primeton.utils.Page;

public interface IBjErrorNumReportDao {
/**
 * 笔均差错数统计查询
 * @param map
 * @param page
 * @return
 */
	List<BjErrorNumReport> queryBjErrorNumReportList(Map<String, Object> map, Page page);
	/**
	 * 笔均差错数统计导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<BjErrorNumReport> queryBjErrorNumReportListForExcel(Map<String, Object> map);
	List yesOrNot_dep(String orgcode);

}
