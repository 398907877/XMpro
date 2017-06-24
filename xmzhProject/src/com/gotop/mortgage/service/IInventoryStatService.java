package com.gotop.mortgage.service;

import java.util.List;

import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IInventoryStatService {
	
	/**
	 * 实时库存统计查询
	 * @param inventoryStat
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatList(MUOUserSession muo, InventoryStat inventoryStat, Page page);
	/**
	 * 实时库存统计查询导出excel
	 * @param muo 
	 * @param inventoryStat
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListForExcel(MUOUserSession muo, InventoryStat inventoryStat);
	/**
	 * 插入库存统计数据到数据库中
	 * @param inventoryStat
	 * 
	 */
	boolean insertInventoryStat(MUOUserSession muo);
	
	/**
	 * 库存统计查询
	 * @param inventoryStat
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListByTable(MUOUserSession muo, InventoryStat inventoryStat, Page page);
	
	/**
	 * 库存统计查询导出excel
	 * @param muo 
	 * @param inventoryStat
	 * @return
	 * 
	 */
	List<InventoryStat> queryInventoryStatListByTableForExcel(MUOUserSession muo, InventoryStat inventoryStat);
}
