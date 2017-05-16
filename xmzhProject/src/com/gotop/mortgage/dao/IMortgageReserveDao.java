package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.MortgageReserve;
import com.primeton.utils.Page;

public interface IMortgageReserveDao {
	/**
	 * 查询抵押品库存
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserve> queryMortgageReserveList(Map<String, Object> map, Page page);
}
