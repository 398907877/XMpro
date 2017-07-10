package com.gotop.reportjbpm.service;

import java.util.List;
import com.gotop.reportjbpm.model.SxApprovalReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface ISxApprovalReportService {
	
	/**
	 * 授信审批报表
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportList(MUOUserSession muo, SxApprovalReport sxApprovalReport, Page page,List<SxApprovalReport> sxApprovalReportTitleList);
	

	/**
	 * 授信审批报表标题头
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportTitleList(SxApprovalReport sxApprovalReport);
	/**
	 * 授信审批报表导出excel
	 * @param muo 
	 * @param approval
	 * @param page
	 * @return
	 */
	List<SxApprovalReport> querySxApprovalReportListForExcel(MUOUserSession muo, SxApprovalReport sxApprovalReport,List<SxApprovalReport> sxApprovalReportTitleList);
	

	

}
