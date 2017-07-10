package com.gotop.reportjbpm.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.reportjbpm.dao.IProcessUsedTimeReportDao;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ProcessUsedTimeReportDao extends SqlMapClientDao implements IProcessUsedTimeReportDao {

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportList(Map<String, Object> map, Page page) {
		return this.queryForList("T_PROCESSUSEDTIMEREPORT_SqlMap.queryProcessUsedTimeReportList", map,page);
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportListForExcel(Map<String, Object> map) {
		return this.queryForList("T_PROCESSUSEDTIMEREPORT_SqlMap.queryProcessUsedTimeReportList", map);
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeReportListTemp() {
		return this.queryForList("T_PROCESSUSEDTIMEREPORT_SqlMap.queryProcessUsedTimeReportListTemp", null);
	}

	@Override
	public void insertProcessUsedTimeReportTemp(
			HashMap<String, String> hmp) {
		this.insert("T_PROCESSUSEDTIMEREPORT_SqlMap.insertProcessUsedTimeReportTemp", hmp);
		
	}

	@Override
	public List<ProcessUsedTimeReport> queryProcessUsedTimeType() {

		return this.queryForList("T_PROCESSUSEDTIMEREPORT_SqlMap.queryProcessUsedTimeType", null);
	}

	@Override
	public Object queryReportUpdatetime() {
		Object object = queryForObject("T_PROCESSUSEDTIMEREPORT_SqlMap.queryReportUpdatetime");
		return  object;
	}

	@Override
	public List yesOrNot_dep(String orgcode) {
		return this.queryForList("T_LOANRATEFLOATREPORT_SqlMap.yesOrNot_dep", orgcode);
	}

	
}
