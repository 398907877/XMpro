package com.gotop.mortgage.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.Generalprocess.util.SpringContextUtil;
import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.service.IInventoryStatService;
import com.gotop.mortgage.service.IMortgageLogService;
import com.gotop.reportjbpm.model.ProcessUsedTimeReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;
/**
 * 外借情况查询
 * @author gotop
 *
 */
public class InventoryStatQueryAction extends BaseAction {
	private static final long serialVersionUID = -8637184763455531923L;

	private InventoryStat inventoryStat;
	
	private IInventoryStatService inventoryStatService;
	private List<InventoryStat> inventoryStatList=new ArrayList<InventoryStat>();
	private String reslut;
	public String getReslut() {
		return reslut;
	}
	public void setReslut(String reslut) {
		this.reslut = reslut;
	}
	
	public InventoryStat getInventoryStat() {
		return inventoryStat;
	}

	

	public IInventoryStatService getInventoryStatService() {
		return inventoryStatService;
	}



	public void setInventoryStatService(IInventoryStatService inventoryStatService) {
		this.inventoryStatService = inventoryStatService;
	}



	public List<InventoryStat> getInventoryStatList() {
		return inventoryStatList;
	}



	public void setInventoryStatList(List<InventoryStat> inventoryStatList) {
		this.inventoryStatList = inventoryStatList;
	}



	public void setInventoryStat(InventoryStat inventoryStat) {
		this.inventoryStat = inventoryStat;
	}



	public String queryInventoryStatList(){
		MUOUserSession muo = getCurrentOnlineUser();
		inventoryStatList=inventoryStatService.queryInventoryStatList(muo,inventoryStat,this.getPage());
	    this.setPage(page);
		this.setInventoryStatList(inventoryStatList);
		return  "queryInventoryStatList";
	}
	
	/**
	 * 库存统计查询导出excel
	 * @return
	 */
	public String inventoryStatExcel(){
		
		MUOUserSession muo = getCurrentOnlineUser();
		inventoryStatList=inventoryStatService.queryInventoryStatListForExcel(muo,inventoryStat);
		this.setInventoryStatList(inventoryStatList);
		if("1".equals(inventoryStat.getMortgageType())){
			return  "QueryHouseInventoryStatForExcel";
		}else if("2".equals(inventoryStat.getMortgageType())){
			return  "QueryCarInventoryStatForExcel";
		}
		return null;
	}

	public String inventoryStatTimeReport() throws Exception {
		//System.out.println("aaaaaaa");
		 MUOUserSession muo = getCurrentOnlineUser();
		 String res="激活失败";
		    boolean result2=false;
			Map<String, Object>map=new HashMap<String, Object>();
			InventoryStat inventoryStat2 = new InventoryStat();
			try {
				
				result2=inventoryStatService.insertInventoryStat(muo);
				if(result2){
					res="激活成功";
				}else{
					res="激活失败";
				}
				
			} catch (Exception e) {
				res="激活失败";
				e.printStackTrace();
			}
	    	this.setReslut(res);
	    	return "inventoryStatTimeReport";		
	 }
}
