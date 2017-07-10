package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IMortgageLogDao;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class MortgageLogDao extends SqlMapClientDao implements
		IMortgageLogDao {

	@Override
	public List<MortgageLog> queryMortgageLogList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_MortgageLog_Query_SqlMap.queryMortgageLogList", map,page);
	}
	@Override
	public List<MortgageLog> queryMortgageLogListForExcel(Map<String, Object> map) {
		return this.queryForList("T_MortgageLog_Query_SqlMap.queryMortgageLogList", map);
	}

	
}
