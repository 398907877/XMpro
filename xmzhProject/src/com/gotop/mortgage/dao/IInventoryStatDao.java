package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.mortgage.model.MortgageLog;
import com.primeton.utils.Page;

public interface IInventoryStatDao {
	/**
	 * 实时库存统计查询
	 * @param mortgageLog
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatList(Map<String, Object> map, Page page);
	List<InventoryStat> queryTimeList(Map<String, Object> map);
	/**
	 * 实时库存统计导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListForExcel(Map<String, Object> map);
	/**
	 * 插入库存统计
	 * @param map
	 * @return
	 */
	boolean insertInventoryStat(Map<String, Object> map);
	
	/**
	 * 库存统计查询
	 * @param mortgageLog
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListByTable(Map<String, Object> map, Page page);
	
	/**
	 * 库存统计导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryInventoryStatListByTableForExcel(Map<String, Object> map);
	
	/**
	 * 押品类型为房产，库存统计
	 * @param map
	 * @return
	 */
	List<InventoryStat> queryHouseInventoryStatList(Map<String, Object> map, Page page);
	/**
	 * 押品类型为机动车，库存统计
	 * @param map
	 * @return
	 */
	List<InventoryStat> queryCarInventoryStatList(Map<String, Object> map, Page page);
	/**
	 * 押品类型为房产，库存统计，导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryHouseInventoryStatListForExcel(Map<String, Object> map);
	/**
	 * 押品类型为机动车，库存统计，导出Excel
	 * @param map
	 * @param page
	 * @return
	 */
	List<InventoryStat> queryCarInventoryStatListForExcel(Map<String, Object> map);
	
	/**
	 * 删除数据库中某天的库存统计数据
	 * @param map
	 * @return
	 */
	int deleteNowInventoryStat(InventoryStat inventoryStat);
}
