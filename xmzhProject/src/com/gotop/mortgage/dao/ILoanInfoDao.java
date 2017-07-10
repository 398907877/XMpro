package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.LoanInfo;
import com.primeton.utils.Page;

public interface ILoanInfoDao {
	/**
	 * 外借情况查询
	 * @param loanInfo
	 * @param page
	 * @return
	 */
	List<LoanInfo> queryHouseLoanInfoList(Map<String, Object> map, Page page);
	List<LoanInfo> queryCarLoanInfoList(Map<String, Object> map, Page page);
	/**
	 * 外借情况查询导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<LoanInfo> queryHouseLoanInfoListForExcel(Map<String, Object> map);
	List<LoanInfo> queryCarLoanInfoListForExcel(Map<String, Object> map);
	
	List yesOrNot_dep(String orgcode);
}
