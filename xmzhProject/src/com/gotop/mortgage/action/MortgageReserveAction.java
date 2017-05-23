package com.gotop.mortgage.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.service.IMortgageReserveService;
import com.gotop.util.Struts2Utils;

public class MortgageReserveAction extends BaseAction {
	private MortgageReserve mortgageReserve;
	private MortgageReserveCar mortgageReserveCar;
	private MortgageReserveHouse mortgageReserveHouse;
	
	private IMortgageReserveService mortgageReserveService;
	private List<MortgageReserve> mortgageReserveList=new ArrayList<MortgageReserve>();
	private Map<String, String> tempMortgage;
	
	public Map<String, String> getTempMortgage() {
		return tempMortgage;
	}
	public void setTempMortgage(Map<String, String> tempMortgage) {
		this.tempMortgage = tempMortgage;
	}
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
	
	
	public MortgageReserveCar getMortgageReserveCar() {
		return mortgageReserveCar;
	}
	public MortgageReserveHouse getMortgageReserveHouse() {
		return mortgageReserveHouse;
	}
	public void setMortgageReserveCar(MortgageReserveCar mortgageReserveCar) {
		this.mortgageReserveCar = mortgageReserveCar;
	}
	public void setMortgageReserveHouse(MortgageReserveHouse mortgageReserveHouse) {
		this.mortgageReserveHouse = mortgageReserveHouse;
	}
	/**
	 * 查询库存信息
	 * @return
	 */
	public String queryMortgageReserveList(){
		System.out.println("1111111:"+mortgageReserve.getBorrowerName());
		mortgageReserveList=mortgageReserveService.queryMortgageReserveList(mortgageReserve, this.getPage());
		this.setPage(page);
		this.setMortgageReserveList(mortgageReserveList);
		return "mortgageReserveList";
	}
	

	/**
	 * 跳转到 新增 库存页面
	 * @return
	 */
	public String toAddItem(){
		return "add_mortgageReserve";
	}
	
	/**
	 * 新增入库
	 * @throws Exception
	 */
	public void addItem() throws Exception{
       String info ="success";
		try {
			System.out.println("2222:"+tempMortgage.get("otherTypeFC"));
			System.out.println("2222333:"+tempMortgage.get("otherTypeJDC"));
			System.out.println("orgCode:"+mortgageReserve.getOrgCode());
			
		} catch (Exception e) {
			info="fails";
			log.error("[失败！]", e);
			throw e;
		}finally{	
			Struts2Utils.renderText(info);
		}
	}

}
