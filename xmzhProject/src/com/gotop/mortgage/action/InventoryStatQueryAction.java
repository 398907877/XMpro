package com.gotop.mortgage.action;

import java.util.ArrayList;
import java.util.List;

import com.gotop.crm.util.BaseAction;
import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.service.IInventoryStatService;
import com.gotop.mortgage.service.IMortgageLogService;
import com.gotop.vo.system.MUOUserSession;
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
		return "QueryInventoryStatForExcel";
	}

}
