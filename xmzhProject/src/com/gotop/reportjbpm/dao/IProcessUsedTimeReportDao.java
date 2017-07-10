package com.gotop.reportjbpm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.primeton.utils.Page;

public interface IProcessUsedTimeReportDao {
/**
 * 流程用时统计报表
 * @param map
 * @param page
 * @return
 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(Map<String, Object> map, Page page);
	

/**
 * 流程用时统计报表
 * @param map
 * @param page
 * @return
 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportListTemp();
	/**
	 * 流程用时统计报表导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(Map<String, Object> map);
	
	List<ProcessUsedTimeReport> queryProcessUsedTimeType();
	
	void insertProcessUsedTimeReportTemp(HashMap<String, String> hmp);
	Object queryReportUpdatetime();


	List yesOrNot_dep(String orgcode);

}
