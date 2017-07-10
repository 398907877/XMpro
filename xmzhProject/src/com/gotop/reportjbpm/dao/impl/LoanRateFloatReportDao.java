package com.gotop.reportjbpm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.dao.ILoanRateFloatReportDao;
import com.gotop.reportjbpm.model.LoanRateFloatReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.gotop.vo.tyjg.Omorganization;
import com.primeton.utils.Page;

public class LoanRateFloatReportDao extends SqlMapClientDao implements ILoanRateFloatReportDao {

	@Override
	public List<LoanRateFloatReport> queryLoanRateFloatReport(Map<String, Object> map,
			Page page) {
		
		return queryForList("T_LOANRATEFLOATREPORT_SqlMap.queryLoanRateFloatReport",map,page);
	}



	@Override
	public List<LoanRateFloatReport> queryLoanRateFloatReportForExcel(
			Map<String, Object> map) {
		return queryForList("T_LOANRATEFLOATREPORT_SqlMap.queryLoanRateFloatReport",map);
	}

	@Override
	public List<Omorganization> isOneOrg(Map<String, Object> map2) {
		
		List list = queryForList("GENERAL_PROCESS_SqlMap.isOneOrg", map2);
		return list;
	}



	@Override
	public HashMap<String, Object> queryOrgInfoById(String orgid) {
		
		HashMap<String, Object> map = (HashMap<String, Object>) queryForObject("T_LOANRATEFLOATREPORT_SqlMap.queryOrgInfoById", orgid);
		return map;
	}



	@Override
	public List yesOrNot_dep(String orgcode) {
		return this.queryForList("T_LOANRATEFLOATREPORT_SqlMap.yesOrNot_dep", orgcode);
	}
}
