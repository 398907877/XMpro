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
import com.gotop.util.time.TimeUtil;
import com.primeton.utils.Page;
import com.primeton.utils.pageCondExpand;

public class MortgageReserveHouseAction extends BaseAction{
	private MortgageReserveHouseCar mortgageReserveHouseCar;
	private MortgageReserve mortgageReserve;
	private MortgageList mortgageList;
	private MortgageLog mortgageLog;
	private IMortgageReserveHouseService mortgageReserveHouseService;
	private List<MortgageReserveHouseCar> mortgageReserveHouseList=new ArrayList<MortgageReserveHouseCar>();
	private List<MortgageList> mortgageLists = new ArrayList<MortgageList>();
	public Page page2;
	private String result_flag;
	//库存查询
	public String queryMortgageHouseReserveList() throws Exception{
		//System.out.println("1111111:"+mortgageReserveHouse.getWarrantsId());
		//System.out.println("补登记确认标志："+mortgageReserveHouse.getNoRegisterSign());
		mortgageReserveHouseList=mortgageReserveHouseService.queryHouseStockList(mortgageReserveHouseCar, this.getPage());
		page.setBegin(0);
		page.setCount(true);
		page.setLength(10);
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
		System.out.println("toRegisterSignConfirm:"+mortgageReserveHouseCar.getWarrantsId());
		this.setMortgageReserveHouseCar(mortgageReserveHouseCar);
		mortgageReserveHouseCar.setWarrantsId(mortgageReserveHouseCar.getWarrantsId());
		return "RegisterSignConfirm";
	}
	//补登记确认
	public String noRegisterSignConfirm() throws Exception
	{
		String warrantsId=getRequest().getParameter("warrantsId");
		//System.out.println("aaa==="+warrantsId);
		String info = "success";
		try {
			//MortgageLog mortgageLog = new MortgageLog();
			//String warrantsId = mortgageReserveHouse.getWarrantsId();
			//System.out.println("补登记确认的getWarrantsId=="+warrantsId);
			 mortgageReserve = this.mortgageReserveHouseService.queryMortgageReserveHouseById(warrantsId);
			//MortgageReserve mortgageReserve1 = new MortgageReserve();
//			mortgageReserve1.setNoRegisterSign(mortgageReserve.getNoRegisterSign());
			//修改主表的补登记状态
			//System.out.println("mortgageReserveID==="+mortgageReserve.getId());
			mortgageReserveHouseService.update(mortgageReserve);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("warrantsId",warrantsId);
			map.put("operatingUserId", Long.toString(this.getCurrentOnlineUser().getEmpid()));
			map.put("operatingType", "5");
			map.put("operatingTime", TimeUtil.today()+TimeUtil.now());
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
		mortgageReserveHouseList=mortgageReserveHouseService.queryMortgageHouseForExcel(mortgageReserveHouseCar);
		this.setMortgageReserveHouseList(mortgageReserveHouseList);
		return "queryMortgageQueryForExcel";
	}
	/**
	 * 出入库汇总查询
	 * 
	 */
	public String queryMortgageInOut(){
		if ("2".equals(mortgageList.getMortgageType())) {
			System.out.println("进入机动车出入库汇总查询"+mortgageList.getMortgageType());
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarInOutList(mortgageList, this.getPage());
//			return "queryMortgageInOut";
		}
		
		if ("1".equals(mortgageList.getMortgageType())) {
			System.out.println("进入房产出入库汇总查询"+mortgageList.getMortgageType());
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseInOutList(mortgageList, this.getPage());
			//return "queryMortgageInOut";
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
		//System.out.println("mortgageList------->"+mortgageList);
//		String aaa = getRequest().getParameter("aaa");
//		System.out.println("aaaaaa------->="+aaa);
		System.out.println("出入汇总查询的类型："+mortgageList.getMortgageType());
//		System.out.println("mmmm"+mortgageList.getOperatingEndTime());
//		System.out.println(""+mortgageList.getOperatingMatters());
//		System.out.println("出入汇总查询的类型："+mortgageList2.getMortgageType());
		if ("2".equals(mortgageList.getMortgageType())) {
			System.out.println("进入机动车明细查询"+mortgageList.getMortgageType());
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarDetailInOutList(mortgageList,this.getPage());
			//this.setPage(page);
		}
		if ("1".equals(mortgageList.getMortgageType())) {
			System.out.println("进入房产明细查询"+mortgageList.getMortgageType());
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
			System.out.println("机动车汇总导出");
			mortgageLists= mortgageReserveHouseService.queryMortgageReserveCarInOutForExcel(mortgageList);
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("1");
			return "queryMortgageReserveCarInOutForExcel";
		}
		System.out.println("房产汇总导出");
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
		
		if ("2".equals(mortgageList.getMortgageType())&&"01".equals(mortgageList.getOperatingMatters())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarDetailInOutForExcel(mortgageList);
			System.out.println("机动车外借导出");
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveCarDetailInOutForExcel1";
		}
		if ("2".equals(mortgageList.getMortgageType())&&!"01".equals(mortgageList.getOperatingMatters())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveCarDetailInOutForExcel(mortgageList);
			System.out.println("机动车不外借导出");
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveCarDetailInOutForExcel";
		}
		if ("1".equals(mortgageList.getMortgageType())&&!"01".equals(mortgageList.getOperatingMatters())) {
			mortgageLists = mortgageReserveHouseService.queryMortgageReserveHouseDetailInOutForExcel(mortgageList);
			System.out.println("房产不外借导出");
			this.setMortgageLists(mortgageLists);
			this.setResult_flag("2");
			return "queryMortgageReserveHouseDetailInOutForExcel";
		}
		if ("1".equals(mortgageList.getMortgageType())&&"01".equals(mortgageList.getOperatingMatters())) {
			System.out.println("房产外借导出");
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
	
	public MortgageLog getMortgageLog() {
		return mortgageLog;
	}
	public void setMortgageLog(MortgageLog mortgageLog) {
		this.mortgageLog = mortgageLog;
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
	public Page getPage2() {
		if (page2==null) {
			page2=new Page();
			page2.setBegin(0);
			page2.setCount(0);
			page2.setLength(10);
			page2.setCount(true);
			page2.setFirst(true);
		}
		return page2;
	}
	public void setPage2(Page page2) {
		pageCondExpand pce = new pageCondExpand();
		pce.putPageCond(page2);
		this.page2 = page2;
	}
	
	
	
}
