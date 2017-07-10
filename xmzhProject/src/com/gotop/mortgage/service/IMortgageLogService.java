package com.gotop.mortgage.service;

import java.util.List;

import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IMortgageLogService {
	
	/**
	 * 操作日志查询
	 * @param mortgageLog
	 * @param page
	 * @return
	 */
	List<MortgageLog> queryMortgageLogList(MUOUserSession muo, MortgageLog mortgageLog, Page page);
	/**
	 * 操作日志查询导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<MortgageLog> queryMortgageLogListForExcel(MUOUserSession muo, MortgageLog mortgageLog);

}
