package com.gotop.mortgage.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.service.ILoanInfoService;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;
/**
 * 外借情况查询
 * @author gotop
 *
 */
public class LoanInfoQueryAction extends BaseAction {
	private static final long serialVersionUID = -8637184763455531923L;

	private LoanInfo loanInfo;
	
	private ILoanInfoService loanInfoService;
	private List<LoanInfo> loanInfoList=new ArrayList<LoanInfo>();
	private List<LoanInfo> loanInfoNullList=new ArrayList<LoanInfo>();
    public Page page2;
    
    
    public Page getPage2() {
    	if(page2==null){
			page2 = new Page();
			page2.setBegin(0);
			page2.setLength(10);
			page2.setCount(0);
			page2.setCount(true);
		}
		return page2;
	}
	public void setPage2(Page page2) {
		pageCondExpand pce = new pageCondExpand();
		pce.putPageCond(page2);
		this.page2 = page2;
	}
	public LoanInfo getLoanInfo() {
		return loanInfo;
	}


	public void setLoanInfo(LoanInfo loanInfo) {
		this.loanInfo = loanInfo;
	}


	public ILoanInfoService getLoanInfoService() {
		return loanInfoService;
	}


	public void setLoanInfoService(ILoanInfoService loanInfoService) {
		this.loanInfoService = loanInfoService;
	}


	


	public List<LoanInfo> getLoanInfoList() {
		return loanInfoList;
	}


	public void setLoanInfoList(List<LoanInfo> loanInfoList) {
		this.loanInfoList = loanInfoList;
	}


	public List<LoanInfo> getLoanInfoNullList() {
		return loanInfoNullList;
	}
	public void setLoanInfoNullList(List<LoanInfo> loanInfoNullList) {
		this.loanInfoNullList = loanInfoNullList;
	}
	public String queryLoanInfoEntryByTime(){
		MUOUserSession muo = getCurrentOnlineUser();
		if("1".equals(loanInfo.getMortgageType())){
			loanInfoList=loanInfoService.queryLoanInfoList(muo,loanInfo,this.getPage());
			//this.setPage(page);
			this.setLoanInfoList(loanInfoList);
			this.setLoanInfo(loanInfo);
			this.setPage2(this.getPage2());
			this.setLoanInfoNullList(loanInfoNullList);
		//	this.setLoanInfo(loanInfo);
		}else if("2".equals(loanInfo.getMortgageType())){
			loanInfoNullList=loanInfoService.queryLoanInfoList(muo,loanInfo,this.getPage2());
			Page bbb=new Page();
			//bbb=this.getPage2();
			bbb.setBegin(0);
			bbb.setLength(10);
			bbb.setCount(0);
			bbb.setCount(true);
			
			List<LoanInfo> loanInfoNullList2=new ArrayList<LoanInfo>();
			
			this.setLoanInfo(loanInfo);
			
			//this.setPage2(page2);
			
			this.setLoanInfoNullList(loanInfoNullList);
			
			this.setPage(bbb);
			this.setLoanInfoList(loanInfoNullList2);
			
		}
		
		return  "queryLoanInfoList";
	}
	
	/**
	 * 外借情况查询导出excel
	 * @return
	 */
	public String loanInfoExcel(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		loanInfoList=loanInfoService.queryLoanInfoListForExcel(muo,loanInfo);
		this.setLoanInfoList(loanInfoList);
		if("1".equals(loanInfo.getMortgageType())){
			return  "QueryHouseLoanInfoForExcel";
		}else if("2".equals(loanInfo.getMortgageType())){
			return  "QueryCarLoanInfoForExcel";
		}
		return null;
	}

}
