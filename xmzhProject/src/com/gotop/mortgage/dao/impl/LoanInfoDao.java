package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.ILoanInfoDao;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class LoanInfoDao extends SqlMapClientDao implements
		ILoanInfoDao {

	@Override
	public List<LoanInfo> queryHouseLoanInfoList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_LoanInfo_Query_SqlMap.queryHouseLoanInfoList", map,page);
	}
	@Override
	public List<LoanInfo> queryCarLoanInfoList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_LoanInfo_Query_SqlMap.queryCarLoanInfoList", map,page);
	}
	@Override
	public List<LoanInfo> queryHouseLoanInfoListForExcel(Map<String, Object> map) {
		return this.queryForList("T_LoanInfo_Query_SqlMap.queryHouseLoanInfoList", map);
	}
	@Override
	public List<LoanInfo> queryCarLoanInfoListForExcel(Map<String, Object> map) {
		return this.queryForList("T_LoanInfo_Query_SqlMap.queryCarLoanInfoList", map);
	}

	@Override
	public List yesOrNot_dep(String orgcode) {
		return this.queryForList("T_LOANRATEFLOATREPORT_SqlMap.yesOrNot_dep", orgcode);
	}
}
