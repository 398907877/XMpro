package com.gotop.mortgage.action;

import java.util.ArrayList;
import java.util.List;
import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.service.IMortgageReserveService;

public class MortgageReserveAction extends BaseAction {
	private MortgageReserve mortgageReserve;
	
	private IMortgageReserveService mortgageReserveService;
	private List<MortgageReserve> mortgageReserveList=new ArrayList<MortgageReserve>();
	public List<MortgageReserve> getMortgageReserveList() {
		return mortgageReserveList;
	}
	public void setMortgageReserveList(List<MortgageReserve> mortgageReserveList) {
		this.mortgageReserveList = mortgageReserveList;
	}
	public IMortgageReserveService getMortgageReserveService() {
		return mortgageReserveService;
	}
	public void setMortgageReserveService(
			IMortgageReserveService mortgageReserveService) {
		this.mortgageReserveService = mortgageReserveService;
	}
	public MortgageReserve getMortgageReserve() {
		return mortgageReserve;
	}
	public void setMortgageReserve(MortgageReserve mortgageReserve) {
		this.mortgageReserve = mortgageReserve;
	}
	public String queryMortgageReserveList(){
		mortgageReserveList=mortgageReserveService.queryMortgageReserveList(mortgageReserve, this.getPage());
		this.setPage(page);
		this.setMortgageReserveList(mortgageReserveList);
		return "mortgageReserveList";
	}

}
