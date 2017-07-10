package com.gotop.reportjbpm.service;

import java.util.HashMap;
import java.util.List;

import com.gotop.reportjbpm.model.LoanRateFloatReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface ILoanRateFloatReportService {

	

	List<LoanRateFloatReport> queryLoanRateFloatReport(MUOUserSession muo,LoanRateFloatReport loanRateFloatReport,Page page);

	List<LoanRateFloatReport> queryLoanRateFloatReportExcel(MUOUserSession muo,LoanRateFloatReport loanRateFloatReport);

	HashMap<String, Object> queryOrgInfoById(String orgid);

}
