package com.gotop.mortgage.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.service.ILoanInfoService;
import com.gotop.mortgage.service.IMortgageLogService;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
/**
 * 外借情况查询
 * @author gotop
 *
 */
public class MortgageLogQueryAction extends BaseAction {
	private static final long serialVersionUID = -8637184763455531923L;

	private MortgageLog mortgageLog;
	
	private IMortgageLogService mortgageLogService;
	private List<MortgageLog> mortgageLogList=new ArrayList<MortgageLog>();
   
	
	public MortgageLog getMortgageLog() {
		return mortgageLog;
	}

	public void setMortgageLog(MortgageLog mortgageLog) {
		this.mortgageLog = mortgageLog;
	}

	public IMortgageLogService getMortgageLogService() {
		return mortgageLogService;
	}

	public void setMortgageLogService(IMortgageLogService mortgageLogService) {
		this.mortgageLogService = mortgageLogService;
	}

	public List<MortgageLog> getMortgageLogList() {
		return mortgageLogList;
	}

	public void setMortgageLogList(List<MortgageLog> mortgageLogList) {
		this.mortgageLogList = mortgageLogList;
	}

	public String queryMortgageLogList(){
		MUOUserSession muo = getCurrentOnlineUser();
		mortgageLogList=mortgageLogService.queryMortgageLogList(muo,mortgageLog,this.getPage());
	    this.setPage(page);
		this.setMortgageLogList(mortgageLogList);
		
		
		return  "queryMortgageLogList";
	}
	
	/**
	 * 操作日志查询导出excel
	 * @return
	 */
	public String mortgageLogExcel(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		mortgageLogList=mortgageLogService.queryMortgageLogListForExcel(muo,mortgageLog);
		this.setMortgageLogList(mortgageLogList);
		return "QueryMortgageLogForExcel";
	}

}
