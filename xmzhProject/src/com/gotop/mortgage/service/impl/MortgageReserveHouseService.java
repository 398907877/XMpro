package com.gotop.mortgage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.jbpm.model.TProcessConfig;
import com.gotop.jbpm.model.TProcessConfigPerson;
import com.gotop.mortgage.dao.IMortgageReserveHouseDao;
import com.gotop.mortgage.model.MortgageList;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.service.IMortgageReserveHouseService;
import com.primeton.utils.Page;

public class MortgageReserveHouseService implements IMortgageReserveHouseService {

	private IMortgageReserveHouseDao mortgageReserveHouseDao;
	/*
	 * 根据条件查询房产库存信息
	 * */
	@Override
	public List<MortgageReserveHouse> queryHouseStockList(
			MortgageReserveHouse mortgageReserveHouse, Page page){
		List<MortgageReserveHouse> mortgageReserveList =new ArrayList<MortgageReserveHouse>();
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("propertyName", mortgageReserveHouse.getPropertyName());
		map.put("propertyCardNo", mortgageReserveHouse.getPropertyCardNo());
		map.put("propertyNo", mortgageReserveHouse.getPropertyNo());
		map.put("propertyAddres", mortgageReserveHouse.getPropertyAddres());
		map.put("noRegisterSign", mortgageReserveHouse.getNoRegisterSign());
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
	public List<MortgageReserveHouse> queryMortgageHouseForExcel(
			MortgageReserveHouse mortgageReserveHouse) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	if (mortgageReserveHouse!=null) {
			if (mortgageReserveHouse.getNoRegisterSign()!=null
			&&!"".equals(mortgageReserveHouse.getNoRegisterSign())) {
				map.put("noRegisterSign", mortgageReserveHouse.getNoRegisterSign());
			}
			if (mortgageReserveHouse.getPropertyName()!=null
			&&!"".equals(mortgageReserveHouse.getPropertyName())) {
				map.put("propertyName", mortgageReserveHouse.getPropertyName());
			}
			if (mortgageReserveHouse.getPropertyCardNo()!=null
			&& !"".equals(mortgageReserveHouse.getPropertyCardNo())) {
				map.put("propertyCardNo", mortgageReserveHouse.getPropertyCardNo());		
			}
			if (mortgageReserveHouse.getPropertyNo()!=null
					&& !"".equals(mortgageReserveHouse.getPropertyNo())) {
				map.put("propertyNo", mortgageReserveHouse.getPropertyNo());
			}
			if (mortgageReserveHouse.getPropertyAddres()!=null
			&& !"".equals(mortgageReserveHouse.getPropertyAddres())) {
				map.put("propertyAddres", mortgageReserveHouse.getPropertyAddres());
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
    	System.out.println("queryMortgageReserveHouseById------->id==="+id);
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
//    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, Object> map = new HashMap<String, Object>();
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		System.out.println("queryMortgageReserveHouseInOutList+service-----");
		return lists;
	}
    /**
     * 出入库机动车查询
     * @abatorgenerated
     */
    public List<MortgageList> queryMortgageReserveCarInOutList(
			MortgageList mortgageList, Page page) {
    	System.out.println("queryMortgageReserveCarInOutList+111111111");
    	List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		System.out.println("queryMortgageReserveCarInOutList====+22222");
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
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		System.out.println("queryMortgageReserveHouseDetailInOutList++++++++++"+mortgageList.getMortgageType());
		List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		System.out.println("queryMortgageReserveHouseDetailInOutList99999+service");
		return lists;
	}
	@Override
	public List<MortgageList> queryMortgageReserveCarDetailInOutList(
			MortgageList mortgageList, Page page) {
		List<MortgageList> lists = new ArrayList<MortgageList>();
		Map<String, Object> map = new HashMap<String, Object>();
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
//			try {
//				if (mortgageList.getOperatingTime()!=null
//						&&!"".equals(mortgageList.getOperatingTime())) {
//					map.put("operatingTime", sdf.format(sdf1.parse(mortgageList.getOperatingTime())));		
//				}
//				if (mortgageList.getOperatingEndTime()!=null
//						&&!"".equals(mortgageList.getOperatingEndTime())) {
//					map.put("operatingEndTime", sdf.format(sdf1.parse(mortgageList.getOperatingEndTime())));
//				}		
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", mortgageList.getOperatingTime());		
			}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
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
		System.out.println("queryMortgageReserveCarDetailInOutList55555+service");
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
