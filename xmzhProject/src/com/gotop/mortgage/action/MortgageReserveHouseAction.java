package com.gotop.mortgage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.MortgageList;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveHouseCar;
import com.gotop.mortgage.service.IMortgageReserveHouseService;
import com.gotop.util.Struts2Utils;
import com.gotop.vo.system.MUOUserSession;

public class MortgageReserveHouseAction extends BaseAction{
	private MortgageReserveHouseCar mortgageReserveHouseCar;
	private MortgageReserve mortgageReserve;
	private MortgageList mortgageList;
	private MortgageLog mortgageLog;
	private IMortgageReserveHouseService mortgageReserveHouseService;
	private List<MortgageReserveHouseCar> mortgageReserveHouseList=new ArrayList<MortgageReserveHouseCar>();
	private List<MortgageList> mortgageLists = new ArrayList<MortgageList>();
	private String result_flag;
	//库存查询
	public String queryMortgageHouseReserveList() throws Exception{
		MUOUserSession muo = getCurrentOnlineUser();
		mortgageReserveHouseList=mortgageReserveHouseService.queryHouseStockList(muo,mortgageReserveHouseCar, this.getPage());
		this.setPage(page);
		this.setMortgageReserveHouseList(mortgageReserveHouseList);
		return "mortgageReserveHouseList";
	}
	/**
	 * 跳转到补登记确认界面
	 * 
	 * @return
	 */
	public String toRegisterSignConfirm() {
		//System.out.println("toRegisterSignConfirm:"+mortgageReserveHouseCar.getWarrantsId());
		MUOUserSession muo = getCurrentOnlineUser();
		mortgageReserveHouseCar.setWarrantsId(mortgageReserveHouseCar.getWarrantsId());
		mortgageReserveHouseCar.setPropertyName(mortgageReserveHouseCar.getPropertyName());
		mortgageReserveHouseCar.setPropertyNo(mortgageReserveHouseCar.getPropertyNo());
		//mortgageReserveHouseList=mortgageReserveHouseService.queryMortgageHouseForExcel(muo,mortgageReserveHouseCar);
		
		//this.setMortgageReserveHouseCar(mortgageReserveHouseList.get(0));
		this.setMortgageReserveHouseCar(mortgageReserveHouseCar);

		return "RegisterSignConfirm";
	}
	//补登记确认
	public String noRegisterSignConfirm() throws Exception
	{
		String warrantsId=getRequest().getParameter("warrantsId");
		String info = "success";
		try {
			 mortgageReserve = this.mortgageReserveHouseService.queryMortgageReserveHouseById(warrantsId);
			//System.out.println("补登记未确认"+mortgageReserve.getNoRegisterSign());
			//修改主表的补登记状态
			mortgageReserveHouseService.update(mortgageReserve);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("warrantsId",warrantsId);
			map.put("operatingUserId", Long.toString(this.getCurrentOnlineUser().getEmpid()));
			map.put("operatingType", "5");
			map.put("operatingRemark", "添加补登记确认");
			//将修改的补登记记录插入操作日志的表
			mortgageReserveHouseService.insert(map);
			
		} catch (Exception e) {
			info="fails";
			log.error("[补登记修改失败！]", e);
			throw e;
		}
		finally {
			Struts2Utils.renderText(info);
		}
		return null;
	}
	
	/**
	 * 房产库存导出功能导出excel
	 * @return
	 */
	public String queryMortgageQueryForExcel(){
		MUOUserSession muo = getCurrentOnlineUser();
		mortgageReserveHouseList=mortgageReserveHouseService.queryMortgageHouseForExcel(muo,mortgageReserveHouseCar);
		this.setMortgageReserveHouseList(mortgageReserveHouseList);
		return "queryMortgageQueryForExcel";
	}
	/**
	 * 出入库汇总查询
	 * 
	 */
	public String queryMortgageInOut(){
//		if(mortgageList.getCheckboxStatus()!=null && !"1".equals(mortgageList.getCheckboxStatus())){
//			mortgageList.setCheckboxStatus("true");
//		}
		if ("2".equals(mortgageList.getMortgageType())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarInOutList(mortgageList, this.getPage());
		}
		if ("1".equals(mortgageList.getMortgageType())) {
			//System.out.println("进入房产出入库汇总查询"+mortgageList.getMortgageType());
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseInOutList(mortgageList, this.getPage());
		}
		this.setPage(page);
		this.setResult_flag("1");
		this.setMortgageLists(mortgageLists);
		return "queryMortgageInOut";
	}
	/**
	 * 出入库明细详情查询
	 * 
	 */
	public String queryMortgageQueryInOutForDetail(){
		if ("2".equals(mortgageList.getMortgageType())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarDetailInOutList(mortgageList,this.getPage());
		}
		if ("1".equals(mortgageList.getMortgageType())) {
			//System.out.println("进入房产外借明细查询"+mortgageList.getMortgageType());
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseDetailInOutList(mortgageList,this.getPage());
		}
		this.setPage(page);
		this.setMortgageLists(mortgageLists);
		this.setResult_flag("2");
		return "queryMortgageInOut";
	}
	/**
	 * 出入库汇总导出
	 * @return
	 */
	public String queryMortgageTotalInOutForExcel(){
		if ("2".equals(mortgageList.getMortgageType())) {
			mortgageLists= mortgageReserveHouseService.queryMortgageReserveCarInOutForExcel(mortgageList);
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("1");
			return "queryMortgageReserveCarInOutForExcel";
		}
		mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseInOutForExcel(mortgageList);
		this.setMortgageLists(mortgageLists);
		this.setResult_flag("1");
		return "queryMortgageReserveHouseInOutForExcel";
	}
	/**
	 * 出入库明细导出
	 * @return
	 */
	public String queryMortgageDetailInOutForExcel(){
		
		if ("2".equals(mortgageList.getMortgageType())&&"1".equals(mortgageList.getOperatingMatters())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarDetailInOutForExcel(mortgageList);
			//System.out.println("机动车外借导出");
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveCarDetailInOutForExcel1";
		}
		if ("2".equals(mortgageList.getMortgageType())&&!"1".equals(mortgageList.getOperatingMatters())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarDetailInOutForExcel(mortgageList);
			//System.out.println("机动车不外借导出");
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveCarDetailInOutForExcel";
		}
		if ("1".equals(mortgageList.getMortgageType())&&!"1".equals(mortgageList.getOperatingMatters())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseDetailInOutForExcel(mortgageList);
			//System.out.println("房产不外借导出");
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveHouseDetailInOutForExcel";
		}
		if ("1".equals(mortgageList.getMortgageType())&&"1".equals(mortgageList.getOperatingMatters())) {
			//System.out.println("房产外借导出");
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseDetailInOutForExcel(mortgageList);
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveHouseDetailInOutForExcel1";
		}
		return null;
		
	}
	
	public MortgageReserveHouseCar getMortgageReserveHouseCar() {
		return mortgageReserveHouseCar;
	}
	public void setMortgageReserveHouseCar(
			MortgageReserveHouseCar mortgageReserveHouseCar) {
		this.mortgageReserveHouseCar = mortgageReserveHouseCar;
	}
	public IMortgageReserveHouseService getMortgageReserveHouseService() {
		return mortgageReserveHouseService;
	}
	public void setMortgageReserveHouseService(
			IMortgageReserveHouseService mortgageReserveHouseService) {
		this.mortgageReserveHouseService = mortgageReserveHouseService;
	}
	public MortgageReserve getMortgageReserve() {
		return mortgageReserve;
	}
	public void setMortgageReserve(MortgageReserve mortgageReserve) {
		this.mortgageReserve = mortgageReserve;
	}
	
	public List<MortgageReserveHouseCar> getMortgageReserveHouseList() {
		return mortgageReserveHouseList;
	}
	public void setMortgageReserveHouseList(
			List<MortgageReserveHouseCar> mortgageReserveHouseList) {
		this.mortgageReserveHouseList = mortgageReserveHouseList;
	}
	public MortgageList getMortgageList() {
		return mortgageList;
	}
	public void setMortgageList(MortgageList mortgageList) {
		this.mortgageList = mortgageList;
	}
	
	public List<MortgageList> getMortgageLists() {
		return mortgageLists;
	}
	public void setMortgageLists(List<MortgageList> mortgageLists) {
		this.mortgageLists = mortgageLists;
	}
	public String getResult_flag() {
		return result_flag;
	}
	public void setResult_flag(String result_flag) {
		this.result_flag = result_flag;
	}
	public MortgageLog getMortgageLog() {
		return mortgageLog;
	}
	public void setMortgageLog(MortgageLog mortgageLog) {
		this.mortgageLog = mortgageLog;
	}
	
	
}
