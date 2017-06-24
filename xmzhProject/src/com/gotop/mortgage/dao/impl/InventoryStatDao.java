package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IInventoryStatDao;
import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.LoanInfo;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class InventoryStatDao extends SqlMapClientDao implements
		IInventoryStatDao {

	@Override
	public List<InventoryStat> queryInventoryStatList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatList", map,page);
	}
	@Override
	public List<InventoryStat> queryInventoryStatListForExcel(Map<String, Object> map) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatList", map);
	}
	@Override
	public List<InventoryStat> queryTimeList(
			Map<String, Object> map) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryTime", map);
	}
	@Override
	public boolean insertInventoryStat(Map<String, Object> map) {
		this.insert("T_InventoryStat_Query_SqlMap.insertInventoryStat", map);
		return true;
	}
	@Override
	public List<InventoryStat> queryInventoryStatListByTable(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatListByTable", map,page);
	}
	@Override
	public List<InventoryStat> queryInventoryStatListByTableForExcel(
			Map<String, Object> map) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatListByTable", map);
	}
	
	
	@Override
	public List<InventoryStat> queryHouseInventoryStatList(Map<String, Object> map,
			Page page) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatListByHouse", map,page);
	}
	@Override
	public List<InventoryStat> queryCarInventoryStatList(Map<String, Object> map,
			Page page) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatListByCar", map,page);
	}
	@Override
	public List<InventoryStat> queryHouseInventoryStatListForExcel(
			Map<String, Object> map) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatListByHouse", map);
	}
	@Override
	public List<InventoryStat> queryCarInventoryStatListForExcel(
			Map<String, Object> map) {
		return this.queryForList("T_InventoryStat_Query_SqlMap.queryInventoryStatListByCar", map);
	}
	@Override
	public int deleteNowInventoryStat(InventoryStat inventoryStat) {
		int rows = getSqlMapClientTemplate().delete("T_InventoryStat_Query_SqlMap.deleteNowInventoryStat", inventoryStat);
        return rows;
	}
}
