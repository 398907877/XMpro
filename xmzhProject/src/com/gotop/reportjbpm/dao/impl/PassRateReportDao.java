package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IPassRateReportDao;
import com.gotop.reportjbpm.model.PassRateReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class PassRateReportDao extends SqlMapClientDao implements IPassRateReportDao {

	@Override
	public List<PassRateReport> queryPassRateReportList(Map<String, Object> map, Page page) {
		
		return this.queryForList("T_PASSRATEREPORT_SqlMap.queryPassRateReport", map,page);
	}

	@Override
	public List<PassRateReport> queryPassRateReportListForExcel(Map<String, Object> map) {
		return this.queryForList("T_PASSRATEREPORT_SqlMap.queryPassRateReport", map);
	}

	@Override
	public List yesOrNot_dep(String orgcode) {
		return this.queryForList("T_LOANRATEFLOATREPORT_SqlMap.yesOrNot_dep", orgcode);
	}

}
