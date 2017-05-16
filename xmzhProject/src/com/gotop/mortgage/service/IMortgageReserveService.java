package com.gotop.mortgage.service;

import java.util.List;
import com.gotop.mortgage.model.MortgageReserve;
import com.primeton.utils.Page;

public interface IMortgageReserveService {
	
	/**
	 * 查询抵押品库存
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserve> queryMortgageReserveList(MortgageReserve mortgageReserve, Page page);

}
