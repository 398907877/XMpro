package com.gotop.mortgage.service;

import java.util.List;

import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IInventoryStatService {
	
	/**
	 * 库存统计查询
	 * @param inventoryStat
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatList(MUOUserSession muo, InventoryStat inventoryStat, Page page);
	/**
	 * 库存统计查询导出excel
	 * @param muo 
	 * @param inventoryStat
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListForExcel(MUOUserSession muo, InventoryStat inventoryStat);

}
