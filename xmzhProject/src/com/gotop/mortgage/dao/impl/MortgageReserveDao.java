package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IMortgageReserveDao;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class MortgageReserveDao extends SqlMapClientDao implements
		IMortgageReserveDao {

	@Override
	public List<MortgageReserve> queryMortgageReserveList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveList", map,page);
	}


}
