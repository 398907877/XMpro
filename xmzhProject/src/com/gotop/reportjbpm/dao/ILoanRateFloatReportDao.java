package com.gotop.reportjbpm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.reportjbpm.model.LoanRateFloatReport;
import com.gotop.vo.tyjg.Omorganization;
import com.primeton.utils.Page;

public interface ILoanRateFloatReportDao {

	List<LoanRateFloatReport> queryLoanRateFloatReport(Map<String, Object> map, Page page);


	List<LoanRateFloatReport> queryLoanRateFloatReportForExcel(Map<String, Object> map);

	public List<Omorganization> isOneOrg(Map<String, Object> map2);
	//List<LoanRateFloatReport> querytaskNameList();


	HashMap<String, Object> queryOrgInfoById(String orgid);


	List yesOrNot_dep(String orgcode);

}
