package com.gotop.mortgage.service;

import java.util.List;

import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.Scan;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface ILoanInfoService {
	
	/**
	 * 外借情况查询
	 * @param loanInfo
	 * @param page
	 * @return
	 */
	List<LoanInfo> queryLoanInfoList(MUOUserSession muo, LoanInfo loanInfo, Page page);
	/**
	 * 外借情况查询导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<LoanInfo> queryLoanInfoListForExcel(MUOUserSession muo, LoanInfo loanInfo);
	

}
