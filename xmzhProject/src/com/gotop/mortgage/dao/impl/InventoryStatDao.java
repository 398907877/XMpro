package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IInventoryStatDao;
import com.gotop.mortgage.model.InventoryStat;
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
}
