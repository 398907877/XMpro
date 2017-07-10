package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.primeton.utils.Page;

public interface IMortgageLogDao {
	/**
	 * 操作日志查询
	 * @param mortgageLog
	 * @param page
	 * @return
	 */
	List<MortgageLog> queryMortgageLogList(Map<String, Object> map, Page page);
	/**
	 * 操作日志查询导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<MortgageLog> queryMortgageLogListForExcel(Map<String, Object> map);

}
