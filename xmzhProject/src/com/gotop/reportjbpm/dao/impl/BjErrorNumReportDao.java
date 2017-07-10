package com.gotop.reportjbpm.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.IBjErrorNumReportDao;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class BjErrorNumReportDao extends SqlMapClientDao implements IBjErrorNumReportDao {

	@Override
	public List<BjErrorNumReport> queryBjErrorNumReportList(Map<String, Object> map, Page page) {
		
		return this.queryForList("T_BJERRORNUMREPORT_SqlMap.queryBjErrorNumReport", map,page);
	}

	@Override
	public List<BjErrorNumReport> queryBjErrorNumReportListForExcel(Map<String, Object> map) {
		return this.queryForList("T_BJERRORNUMREPORT_SqlMap.queryBjErrorNumReport", map);
	}

	@Override
	public List yesOrNot_dep(String orgcode) {
		return this.queryForList("T_LOANRATEFLOATREPORT_SqlMap.yesOrNot_dep", orgcode);
	}
	
	

}
