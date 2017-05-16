package com.gotop.mortgage.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.mortgage.dao.IMortgageReserveDao;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.service.IMortgageReserveService;
import com.primeton.utils.Page;

public class MortgageReserveService implements IMortgageReserveService {

	private IMortgageReserveDao mortgageReserveDao;
	public IMortgageReserveDao getMortgageReserveDao() {
		return mortgageReserveDao;
	}
	public void setMortgageReserveDao(IMortgageReserveDao mortgageReserveDao) {
		this.mortgageReserveDao = mortgageReserveDao;
	}
	@Override
	public List<MortgageReserve> queryMortgageReserveList(
			MortgageReserve mortgageReserve, Page page) {
		List<MortgageReserve> mortgageReserveList =new ArrayList<MortgageReserve>();
		Map<String, Object>map=new HashMap<String, Object>();
		mortgageReserveList=mortgageReserveDao.queryMortgageReserveList(map, page);
		return mortgageReserveList;
	}

}
