package com.gotop.reportjbpm.service;

import java.util.List;
import com.gotop.reportjbpm.model.TimeLimitConditionReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface ITimeLimitConditionReportService {
	/**
	 * 时限情况统计报表
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<TimeLimitConditionReport> queryTimeLimitConditionReportList(MUOUserSession muo, TimeLimitConditionReport timeLimitConditionReport, Page page);
	/**
	 * 时限情况统计报表导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<TimeLimitConditionReport> queryTimeLimitConditionReportListForExcel(MUOUserSession muo, TimeLimitConditionReport timeLimitConditionReport);
	
	
	Object queryReportUpdatetime();
}
