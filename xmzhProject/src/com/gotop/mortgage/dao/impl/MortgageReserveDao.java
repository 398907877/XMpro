package com.gotop.mortgage.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.file.model.TFileResourceTable;
import com.gotop.mortgage.dao.IMortgageReserveDao;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveRes;
import com.gotop.mortgage.model.WarrantsFile;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class MortgageReserveDao extends SqlMapClientDao implements
		IMortgageReserveDao {

	@Override
	public List<MortgageReserveRes> queryMortgageReserveList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveList", map,page);
	}

	

	
	@Override
	public String checkOtherWarrantsNumber(Map<String, Object> map) {
		Object obj =this.queryForObject("T_Mortgage_Reserve_SqlMap.checkOtherWarrantsNumber", map);
		return String.valueOf(obj);
	}

	@Override
	public boolean insertMortgage(Map<String, Object> map) {
		this.insert("T_Mortgage_Reserve_SqlMap.insertMortgage", map);
		return true;
	}

	@Override
	public boolean insertMortgageHouse(Map<String, Object> map) {
		this.insert("T_Mortgage_Reserve_SqlMap.insertMortgageHouse", map);
		return true;
	}

	@Override
	public boolean insertMortgageCar(Map<String, Object> map) {
		this.insert("T_Mortgage_Reserve_SqlMap.insertMortgageCar", map);
		return true;
	}

	@Override
	public long getNextSeqVal(HashMap<String, String> hmp) throws Exception {
		Object obj = this.queryForObject("T_Mortgage_Reserve_SqlMap.getNextSeqValue", hmp);
		return Long.parseLong(String.valueOf(obj));
	}

	@Override
	public boolean insertMortgageLog(Map<String, Object> map) {
		this.insert("T_Mortgage_Reserve_SqlMap.insertMortgageLog", map);
		return true;
	}

	@Override
	public boolean insertMortgageFile(Map<String, Object> map) {
		this.insert("T_Mortgage_Reserve_SqlMap.insertMortgageFile", map);
		return true;
	}

	@Override
	public MortgageReserve queryMortgageReserveListInfo(
			Map<String, Object> map) {
		MortgageReserve mortgageReserve=(MortgageReserve) queryForObject("T_Mortgage_Reserve_SqlMap.queryMortgageReserveListInfo", map);
		return mortgageReserve;
	}

	@Override
	public List<MortgageReserveHouse> queryMortgageReserveListHouseInfo(
			Map<String, Object> map) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveListHouseInfo", map);
	}

	@Override
	public List<MortgageReserveCar> queryMortgageReserveListCarInfo(
			Map<String, Object> map) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveListCarInfo", map);
	}



	@Override
	public List<WarrantsFile> queryFileByIdandType(Long id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<WarrantsFile> fileList = queryForList("T_Mortgage_Reserve_SqlMap.queryFileByIdandType", map);
		return fileList;
	}



	@Override
	public WarrantsFile getFileResource(String fileId) {
		WarrantsFile fileResourceTable = new WarrantsFile();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", fileId);
		fileResourceTable = (WarrantsFile) queryForObject("T_Mortgage_Reserve_SqlMap.getFileResource", map);
		return fileResourceTable;
	}



	@Override
	public String checkProjectNumber(Map<String, Object> map) {
		Object obj =this.queryForObject("T_Mortgage_Reserve_SqlMap.checkProjectNumber", map);
		return String.valueOf(obj);
	}



	@Override
	public boolean updMortgage(Map<String, Object> map) {
		this.update("T_Mortgage_Reserve_SqlMap.updMortgage", map);
		return true;
	}



	@Override
	public boolean updMortgageHouse(Map<String, Object> map) {
		this.update("T_Mortgage_Reserve_SqlMap.updMortgageHouse", map);
		return true;
	}



	@Override
	public boolean updMortgageCar(Map<String, Object> map) {
		this.update("T_Mortgage_Reserve_SqlMap.updMortgageCar", map);
		return true;
	}



	@Override
	public List<MortgageReserveRes> queryMortgageReserveHouseList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveHouseList", map,page);
	}



	@Override
	public List<MortgageReserveRes> queryMortgageReserveCarList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveCarList", map,page);
	}



	@Override
	public boolean insertMortgageReserveOutMap(Map<String, Object> map) {
		this.insert("T_Mortgage_Reserve_SqlMap.insertMortgageReserveOutMap", map);
		return true;
	}



	@Override
	public String checkCarRegisterNo(Map<String, Object> map) {
		Object obj =this.queryForObject("T_Mortgage_Reserve_SqlMap.checkCarRegisterNo", map);
		return String.valueOf(obj);
	}




	@Override
	public List<MortgageReserveRes> queryMortgageReserveListExcel(
			Map<String, Object> map) {
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryMortgageReserveListExcel", map);
	}




	@Override
	public List<MortgageReserve> queryOrgs(Map<String, Object> map) {
		
		return this.queryForList("T_Mortgage_Reserve_SqlMap.queryOrgs", map);
	}




	@Override
	public String checkIsLog(Map<String, Object> map) {
		Object obj =this.queryForObject("T_Mortgage_Reserve_SqlMap.checkIsLog", map);
		return String.valueOf(obj);
	}


}
