package com.gotop.mortgage.service.impl;

import java.text.ParseException;
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
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class MortgageReserveHouseService implements IMortgageReserveHouseService {

	private IMortgageReserveHouseDao mortgageReserveHouseDao;
	/*
	 * 根据条件查询房产库存信息
	 * */
	@Override
	public List<MortgageReserveHouseCar> queryHouseStockList(MUOUserSession muo,
			MortgageReserveHouseCar mortgageReserveHouseCar, Page page){
		List<MortgageReserveHouseCar> mortgageReserveList =new ArrayList<MortgageReserveHouseCar>();
		
		//List<MortgageReserveHouseCar> mortgageReserveList2 =new ArrayList<MortgageReserveHouseCar>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		String orgcode = muo.getOrgcode();
		List list  = mortgageReserveHouseDao.byOrgcodeFindParentorgid(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 //if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
			//	 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			// }
			 map.put("PARENTORGID", hp.get("PARENTORGID"));
		}
		
		//MortgageReserveHouseCar mortgageReserveHouseCar2=new MortgageReserveHouseCar();
		if(mortgageReserveHouseCar.getPropertyName()!=null && !"".equals(mortgageReserveHouseCar.getPropertyName())){
			map.put("propertyName", mortgageReserveHouseCar.getPropertyName());			
		}
		if(mortgageReserveHouseCar.getPropertyCardNo()!=null && !"".equals(mortgageReserveHouseCar.getPropertyCardNo())){
			map.put("propertyCardNo", mortgageReserveHouseCar.getPropertyCardNo());
		}
		if(mortgageReserveHouseCar.getPropertyNo()!=null && !"".equals(mortgageReserveHouseCar.getPropertyNo())){
			map.put("propertyNo", mortgageReserveHouseCar.getPropertyNo());		
		}
		if(mortgageReserveHouseCar.getPropertyAddres()!=null && !"".equals(mortgageReserveHouseCar.getPropertyAddres())){
			map.put("propertyAddres", mortgageReserveHouseCar.getPropertyAddres());		
		}
		if(mortgageReserveHouseCar.getNoRegisterSign()!=null && !"".equals(mortgageReserveHouseCar.getNoRegisterSign())){
			map.put("noRegisterSign", mortgageReserveHouseCar.getNoRegisterSign());
		}
		
		
		
		mortgageReserveList=mortgageReserveHouseDao.queryMortgageReserveList(map, page);
		
//		for(int i=0;i<mortgageReserveList.size();i++){
//			  mortgageReserveHouseCar2=mortgageReserveList.get(i);
//			//  System.out.println("aaaaaaaa:"+mortgageReserveHouseCar2.getWarrantsId());
//			  Map<String, Object>map2=new HashMap<String, Object>();
//			     if(mortgageReserveHouseCar2.getWarrantsId()!=null && !"".equals(mortgageReserveHouseCar2.getWarrantsId())){
//						map2.put("warrantsId", mortgageReserveHouseCar2.getWarrantsId());
//						mortgageReserveList2=mortgageReserveHouseDao.queryPropertyNameAndNoList(map2);
//						String names="";
//					     String nos="";
//					     for(int j=0;j<mortgageReserveList2.size();j++){
//					    	 names+=mortgageReserveList2.get(j).getPropertyName()+",";
//					    	 nos+=mortgageReserveList2.get(j).getPropertyNo()+",";
//					     }
//					     if(!"".equals(names) && !"".equals(nos)){
//					    	 names=names.substring(0, names.length()-1);
//						     nos=nos.substring(0, nos.length()-1);
//					     }
//					     
//					     mortgageReserveList.get(i).setPropertyName(names);
//					     mortgageReserveList.get(i).setPropertyNo(nos);
//			     }	     
//		}
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
	public List<MortgageReserveHouseCar> queryMortgageHouseForExcel(MUOUserSession muo,
			MortgageReserveHouseCar mortgageReserveHouseCar) {
    	List<MortgageReserveHouseCar> mortgageReserveList =new ArrayList<MortgageReserveHouseCar>();
    	//List<MortgageReserveHouseCar> mortgageReserveList2 =new ArrayList<MortgageReserveHouseCar>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	//MortgageReserveHouseCar mortgageReserveHouseCar2=new MortgageReserveHouseCar();
    	
    	String orgcode = muo.getOrgcode();
		List list  = mortgageReserveHouseDao.byOrgcodeFindParentorgid(orgcode); //查询当前机构是部门还是机构
		
		if (list.size() != 0){
			 HashMap<String, Object>  hp = (HashMap<String, Object>) list.get(0);
			 //if("no".equals(hp.get("IS_DEP"))) { //当前机构不是部门，说明是支行
			//	 map.put("defaultOrgcode", hp.get("ORGCODE")); //查询列表默认显示本级及下级的数据
			// }
			 map.put("PARENTORGID", hp.get("PARENTORGID"));
		}
    	
    	
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
			if (mortgageReserveHouseCar.getWarrantsId()!=null
					&& !"".equals(mortgageReserveHouseCar.getWarrantsId())) {
						map.put("warrantsId", mortgageReserveHouseCar.getWarrantsId());
					}
		}
    	mortgageReserveList=mortgageReserveHouseDao.queryMortgageReserveHouseForExcel(map);
    	
//    	for(int i=0;i<mortgageReserveList.size();i++){
//			  mortgageReserveHouseCar2=mortgageReserveList.get(i);
//			 // System.out.println("aaaaaaaa:"+mortgageReserveHouseCar2.getWarrantsId());
//			  Map<String, Object>map2=new HashMap<String, Object>();
//			     if(mortgageReserveHouseCar2.getWarrantsId()!=null && !"".equals(mortgageReserveHouseCar2.getWarrantsId())){
//						map2.put("warrantsId", mortgageReserveHouseCar2.getWarrantsId());
//						mortgageReserveList2=mortgageReserveHouseDao.queryPropertyNameAndNoList(map2);
//						String names="";
//					     String nos="";
//					     for(int j=0;j<mortgageReserveList2.size();j++){
//					    	 names+=mortgageReserveList2.get(j).getPropertyName()+",";
//					    	 nos+=mortgageReserveList2.get(j).getPropertyNo()+",";
//					     }
//					     if(!"".equals(names) && !"".equals(nos)){
//					    	 names=names.substring(0, names.length()-1);
//						     nos=nos.substring(0, nos.length()-1);
//					     }
//					     mortgageReserveList.get(i).setPropertyName(names);
//					     mortgageReserveList.get(i).setPropertyNo(nos);
//			     }	     
//		}
    	
		return mortgageReserveList;
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
    	//System.out.println("queryMortgageReserveHouseById------->id==="+id);
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
			}//else {
				//map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
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
				//map.put("mortgageType", null);
				//map.put("operatingMatters", null);
				map.put("status", mortgageList.getStatus());
			}
		}
		lists = mortgageReserveHouseDao.queryMortgageReserveHouseInOutList(map, page);
		//System.out.println("queryMortgageReserveHouseInOutList+service-----");
		return lists;
	}
    /**
     * 出入库机动车查询
     * @abatorgenerated
     */
    public List<MortgageList> queryMortgageReserveCarInOutList(
			MortgageList mortgageList, Page page) {
    	//System.out.println("queryMortgageReserveCarInOutList+111111111");
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
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
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
				//map.put("mortgageType", null);
				//map.put("operatingMatters", null);
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
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			try {
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				
					map.put("operatingTime", sdf1.format(sdf2.parse(mortgageList.getOperatingTime())));
					
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime",sdf1.format(sdf2.parse(mortgageList.getOperatingEndTime())));
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
			} catch (ParseException e) {
				e.printStackTrace();
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
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			try {
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				
					map.put("operatingTime", sdf1.format(sdf2.parse(mortgageList.getOperatingTime())));
						
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", sdf1.format(sdf2.parse(mortgageList.getOperatingEndTime())));
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
			} catch (ParseException e) {
				e.printStackTrace();
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
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			try {
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				
					map.put("operatingTime", sdf1.format(sdf2.parse(mortgageList.getOperatingTime())));
						
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", sdf1.format(sdf2.parse(mortgageList.getOperatingEndTime())));
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}
			} catch (ParseException e) {
				e.printStackTrace();
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
		SimpleDateFormat sdf2= new SimpleDateFormat("yyyy-MM-dd");
		String operatingTime=sdf1.format(date);
		String operatingEndTime=sdf2.format(date);
		if (mortgageList!=null) {
			if (mortgageList.getMortgageType()!=null
			&&!"".equals(mortgageList.getMortgageType())) {
				map.put("mortgageType", mortgageList.getMortgageType());
			}
			try {
			if (mortgageList.getOperatingTime()!=null
					&&!"".equals(mortgageList.getOperatingTime())) {
				map.put("operatingTime", sdf1.format(sdf2.parse(mortgageList.getOperatingTime())));		
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				
					map.put("operatingEndTime", sdf1.format(sdf2.parse(mortgageList.getOperatingEndTime())));
				
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
			} catch (ParseException e) {
				e.printStackTrace();
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
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
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
				map.put("status", mortgageList.getStatus());
			}
		}
		//外借情况查询
		if ("1".equals(mortgageList.getOperatingMatters())) {
			lists = mortgageReserveHouseDao.queryMortgageReserveHouseDetailInOutList1(map, page);
		}else {
			lists = mortgageReserveHouseDao.queryMortgageReserveHouseDetailInOutList(map, page);
		}
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
			}//else {
			//	map.put("operatingTime", operatingTime);
			//}
			if (mortgageList.getOperatingEndTime()!=null
					&&!"".equals(mortgageList.getOperatingEndTime())) {
				map.put("operatingEndTime", mortgageList.getOperatingEndTime());
			}//else {
			//	map.put("operatingEndTime", operatingEndTime);
			//}	
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
		//外借情况查询
		if ("1".equals(mortgageList.getOperatingMatters())) {
			lists = mortgageReserveHouseDao.queryMortgageReserveCarDetailInOutList1(map, page);
		}else {
			lists = mortgageReserveHouseDao.queryMortgageReserveCarDetailInOutList(map, page);
		}
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
