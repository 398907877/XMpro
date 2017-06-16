package com.gotop.mortgage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.mortgage.dao.IMortgageReserveHouseDao;
import com.gotop.mortgage.model.MortgageList;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveHouseCar;
import com.gotop.mortgage.service.IMortgageReserveHouseService;
import com.primeton.utils.Page;

public class MortgageReserveHouseService implements IMortgageReserveHouseService {

	private IMortgageReserveHouseDao mortgageReserveHouseDao;
	/*
	 * 根据条件查询房产库存信息
	 * */
	@Override
	public List<MortgageReserveHouseCar> queryHouseStockList(
			MortgageReserveHouseCar mortgageReserveHouseCar, Page page){
		List<MortgageReserveHouseCar> mortgageReserveList =new ArrayList<MortgageReserveHouseCar>();
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("propertyName", mortgageReserveHouseCar.getPropertyName());
		map.put("propertyCardNo", mortgageReserveHouseCar.getPropertyCardNo());
		map.put("propertyNo", mortgageReserveHouseCar.getPropertyNo());
		map.put("propertyAddres", mortgageReserveHouseCar.getPropertyAddres());
		map.put("noRegisterSign", mortgageReserveHouseCar.getNoRegisterSign());
		mortgageReserveList=mortgageReserveHouseDao.queryMortgageReserveList(map, page);
		return mortgageReserveList;

	}
	/**
     * 更新单条记录，通过主键
     * @abatorgenerated
     */
    public void update(MortgageReserve obj) throws Exception {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("noRegisterSign", "1");
    	map.put("id", obj.getId());
        this.mortgageReserveHouseDao.updateByPrimaryKeySelective(map);
    }
    
    @Override
	public List<MortgageReserveHouseCar> queryMortgageHouseForExcel(
			MortgageReserveHouseCar mortgageReserveHouseCar) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if (mortgageReserveHouseCar!=null) {
			if (mortgageReserveHouseCar.getNoRegisterSign()!=null
			&&!"".equals(mortgageReserveHouseCar.getNoRegisterSign())) {
				map.put("noRegisterSign", mortgageReserveHouseCar.getNoRegisterSign());
			}
			if (mortgageReserveHouseCar.getPropertyName()!=null
			&&!"".equals(mortgageReserveHouseCar.getPropertyName())) {
				map.put("propertyName", mortgageReserveHouseCar.getPropertyName());
			}
			if (mortgageReserveHouseCar.getPropertyCardNo()!=null
			&& !"".equals(mortgageReserveHouseCar.getPropertyCardNo())) {
				map.put("propertyCardNo", mortgageReserveHouseCar.getPropertyCardNo());		
			}
			if (mortgageReserveHouseCar.getPropertyNo()!=null
					&& !"".equals(mortgageReserveHouseCar.getPropertyNo())) {
				map.put("propertyNo", mortgageReserveHouseCar.getPropertyNo());
			}
			if (mortgageReserveHouseCar.getPropertyAddres()!=null
			&& !"".equals(mortgageReserveHouseCar.getPropertyAddres())) {
				map.put("propertyAddres", mortgageReserveHouseCar.getPropertyAddres());
			}
		}
    	
		return mortgageReserveHouseDao.queryMortgageReserveHouseForExcel(map);
	}
    
    /**
     * 插入单条记录
     * @abatorgenerated
     */
    public void insert(Map<String, Object> map) throws Exception {
        this.mortgageReserveHouseDao.insert(map);
    }
    /**
     * 根据id查询单条记录
     * @abatorgenerated
     */
    @Override
	public MortgageReserve queryMortgageReserveHouseById(
			String id) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	map.put("id", id);
		return this.mortgageReserveHouseDao.queryMortgageReserveHouseById(map);
	}
    /**
     * 出入库房产查询
     * @abatorgenerated
     */
    @Override
	public List<MortgageList> queryMortgageReserveHouseInOutList(
			MortgageList mortgageList, Page page) {
    	
    	List<MortgageList> lists = new ArrayList<MortgageList>();
    	Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		Map<String, Object> map = new HashMap<String, Object>();
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
				map.put("mortgageType", null);
				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		lists = mortgageReserveHouseDao.queryMortgageReserveHouseInOutList(map, page);
		return lists;
	}
    /**
     * 出入库机动车查询
     * @abatorgenerated
     */
    public List<MortgageList> queryMortgageReserveCarInOutList(
			MortgageList mortgageList, Page page) {
    	Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
    	List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
				map.put("mortgageType", null);
				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		lists = mortgageReserveHouseDao.queryMortgageReserveCarInOutList(map, page);
		return lists;
	}
    
    /**
     * 出入库房产查询的Excel导出
     * @abatorgenerated
     */
	@Override
	public List<MortgageList> queryMortgageReserveHouseInOutForExcel(
			MortgageList mortgageList) {
		List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
//				map.put("mortgageType", null);
//				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		lists=mortgageReserveHouseDao.queryMortgageReserveHouseInOutForExcel(map);
		return lists;
	}

    /**
     * 出入库机动车查询的Excel导出
     * @abatorgenerated
     */
	@Override
	public List<MortgageList> queryMortgageReserveCarInOutForExcel(
			MortgageList mortgageList) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
//				map.put("mortgageType", null);
//				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		return mortgageReserveHouseDao.queryMortgageReserveCarInOutForExcel(map);
	}
	/**
     * 出入库机动车明细的Excel导出
     * @abatorgenerated
     */
	@Override
	public List<MortgageList> queryMortgageReserveCarDetailInOutForExcel(
			MortgageList mortgageList) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
//				map.put("mortgageType", null);
//				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		return mortgageReserveHouseDao.queryMortgageReserveCarDetailInOutForExcel(map);
	}
	/**
     * 出入库房产明细的Excel导出
     * @abatorgenerated
     */
	@Override
	public List<MortgageList> queryMortgageReserveHouseDetailInOutForExcel(
			MortgageList mortgageList) {
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
//				map.put("mortgageType", null);
//				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		return mortgageReserveHouseDao.queryMortgageReserveHouseDetailInOutForExcel(map);
	}
	@Override
	public List<MortgageList> queryMortgageReserveHouseDetailInOutList(
			MortgageList mortgageList, Page page) {
		List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
//				map.put("mortgageType", null);
//				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		lists = mortgageReserveHouseDao.queryMortgageReserveHouseDetailInOutList(map, page);
		return lists;
	}
	@Override
	public List<MortgageList> queryMortgageReserveCarDetailInOutList(
			MortgageList mortgageList, Page page) {
		List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyyMMdd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}else {
				map.put("operatingTime", operatingTime);
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}else {
				map.put("operatingEndTime", operatingEndTime);
			}	
			if (mortgageList.getOperatingType()!=null
			&&!"".equals(mortgageList.getOperatingType())) {
				map.put("operatingType", mortgageList.getOperatingType());
			}
			if (mortgageList.getOperatingMatters()!=null
			&&!"".equals(mortgageList.getOperatingMatters())) {
				map.put("operatingMatters", mortgageList.getOperatingMatters());
			}
			if (mortgageList.getStatus()!=null
			&&!"".equals(mortgageList.getStatus())) {
//				map.put("mortgageType", null);
//				map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		lists = mortgageReserveHouseDao.queryMortgageReserveCarDetailInOutList(map, page);
		return lists;
	}
    
    public IMortgageReserveHouseDao getMortgageReserveHouseDao() {
		return mortgageReserveHouseDao;
	}
	public void setMortgageReserveHouseDao(
			IMortgageReserveHouseDao mortgageReserveHouseDao) {
		this.mortgageReserveHouseDao = mortgageReserveHouseDao;
	}
	
	
	
	
}
