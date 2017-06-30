package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IMortgageReserveHouseDao;
import com.gotop.mortgage.model.MortgageList;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveHouseCar;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class MortgageReserveHouseDao extends SqlMapClientDao implements IMortgageReserveHouseDao{

	@Override
	public List<MortgageReserveHouseCar> queryMortgageReserveList(
		Map<String, Object> map, Page page){
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveHouseList",map,page);
	}
	@Override
	public List<MortgageReserveHouseCar> queryPropertyNameAndNoList(
		Map<String, Object> map){
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryPropertyNameAndNoList",map);
	}
	@Override
	public int updateByPrimaryKeySelective(Map<String, Object> map) {
		int rows = getSqlMapClientTemplate().update("T_Mortgage_Reserve_House_SqlMap.noRegisterSignUpdate", map);
        return rows;
	}

	@Override
	public List<MortgageReserveHouseCar> queryMortgageReserveHouseForExcel(
			Map<String, Object> map) {
		return queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveHouseList",map);
	}
	/**
     * 插入一条新数据.
     * @abatorgenerated
     */
    public void insert(Map<String, Object> map) {
        getSqlMapClientTemplate().insert("T_Mortgage_Reserve_House_SqlMap.MortgageLog_insert", map);
    }
   
    public MortgageReserve queryMortgageReserveHouseById(Map<String, Object> map)
    {
    	return (MortgageReserve) this.queryForObject("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveById",map);
    }

	@Override
	public List<MortgageList> queryMortgageReserveHouseInOutList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveHouseInOutList",map,page);
	}

	@Override
	public List<MortgageList> queryMortgageReserveCarInOutList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveCarInOutList",map,page);
	}
	@Override
	public List<MortgageList> queryMortgageReserveHouseInOutForExcel(
			Map<String, Object> map) {
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveHouseInOutList",map);
	}
	@Override
	public List<MortgageList> queryMortgageReserveCarInOutForExcel(
			Map<String, Object> map) {
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveCarInOutList",map);
	}

	@Override
	public List<MortgageList> queryMortgageReserveHouseDetailInOutList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveHouseDetailInOutList",map,page);
	}
	
	@Override
	public List<MortgageList> queryMortgageReserveCarDetailInOutList(
			Map<String, Object> map, Page page) {
		return this.queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveCarDetailInOutList",map,page);
	}
	
	@Override
	public List<MortgageList> queryMortgageReserveCarDetailInOutForExcel(
			Map<String, Object> map) {
		return queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveCarDetailInOutList",map);
	}
	@Override
	public List<MortgageList> queryMortgageReserveHouseDetailInOutForExcel(
			Map<String, Object> map) {
		return queryForList("T_Mortgage_Reserve_House_SqlMap.queryMortgageReserveHouseDetailInOutList",map);
	}
	@Override
	public String byOrgcodeFindParentorgid(String orgcode) {
		Object obj=queryForObject("T_Mortgage_Reserve_House_SqlMap.byOrgcodeFindParentorgid",orgcode);
		return String.valueOf(obj);
	}
	@Override
	public String queryOneOrgCode(String orgcode) {
		Object obj=queryForObject("T_Mortgage_Reserve_House_SqlMap.queryOneOrgCode",orgcode);
		return String.valueOf(obj);
	}
	@Override
	public String judgeYesAndNoOneOrgCode(String orgcode) {
		Object obj=queryForObject("T_Mortgage_Reserve_House_SqlMap.judgeYesAndNoOneOrgCode",orgcode);
		return String.valueOf(obj);
	}

}
