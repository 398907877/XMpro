package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.MortgageLog;
import com.primeton.utils.Page;

public interface IInventoryStatDao {
	/**
	 * 操作日志查询
	 * @param mortgageLog
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatList(Map<String, Object> map, Page page);
	List<InventoryStat> queryTimeList(Map<String, Object> map);
	/**
	 * 操作日志查询导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListForExcel(Map<String, Object> map);

}
