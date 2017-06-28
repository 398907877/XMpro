package com.gotop.mortgage.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.deviceManagement.model.DeviceDetail;
import com.gotop.mortgage.dao.IInventoryStatDao;
import com.gotop.mortgage.dao.IMortgageLogDao;
import com.gotop.mortgage.model.InventoryStat;
import com.gotop.mortgage.model.MortgageLog;
import com.gotop.mortgage.service.IInventoryStatService;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class InventoryStatService implements IInventoryStatService {

	private IInventoryStatDao inventoryStatDao;
	
	

	public IInventoryStatDao getInventoryStatDao() {
		return inventoryStatDao;
	}

	public void setInventoryStatDao(IInventoryStatDao inventoryStatDao) {
		this.inventoryStatDao = inventoryStatDao;
	}

	@Override
    public List<InventoryStat> queryInventoryStatList(MUOUserSession muo, InventoryStat inventoryStat, Page page) {
      //  List<InventoryStat> inventoryStatLists=new ArrayList<InventoryStat>();
		
		List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
		
		Map<String, Object>map=new HashMap<String, Object>();
		
		//押品类型
		if (inventoryStat.getMortgageType() !=null&&!"".equals(inventoryStat.getMortgageType())) {
			if("1".equals(inventoryStat.getMortgageType())){
				map.put("mortgageType", "房产");
			}
			if("2".equals(inventoryStat.getMortgageType())){
				map.put("mortgageType", "机动车");
			}
			
	    }
				
		Date d=new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String inserttime = sdf2.format(d);
		//统计时间
		if (inventoryStat.getInTimeStart() !=null&&!"".equals(inventoryStat.getInTimeStart())) {
			 map.put("inTimeStart", inventoryStat.getInTimeStart());
			
			if (inventoryStat.getInTimeEnd() !=null&&!"".equals(inventoryStat.getInTimeEnd())) {
				map.put("inTimeEnd", inventoryStat.getInTimeEnd());
				if(inventoryStat.getInTimeStart().equals(inventoryStat.getInTimeEnd()) && inventoryStat.getInTimeStart().equals(inserttime)){
				//如果开始时间等于结束时间,并且是当天时间	
					map.put("statTime", inventoryStat.getInTimeStart());
					if("1".equals(inventoryStat.getMortgageType())){
						inventoryStatLists2 =inventoryStatDao.queryHouseInventoryStatList(map,page);
					}
					if("2".equals(inventoryStat.getMortgageType())){
						inventoryStatLists2 =inventoryStatDao.queryCarInventoryStatList(map,page);
					}
				}else{
					inventoryStatLists2 =inventoryStatDao.queryInventoryStatListByTable(map,page);
				}
			}
		}
		
//		if(inventoryStat.getInTimeStart() !=null&&!"".equals(inventoryStat.getInTimeStart())){
//			 map.put("inTimeStart", inventoryStat.getInTimeStart());
//		}
//		if (inventoryStat.getInTimeEnd() !=null&&!"".equals(inventoryStat.getInTimeEnd())) {
//			 map.put("inTimeEnd", inventoryStat.getInTimeEnd());
//		}
//		//如果开始时间等于结束时间,并且是当天时间
//		if(inventoryStat.getInTimeStart().equals(inventoryStat.getInTimeEnd()) && inventoryStat.getInTimeStart().equals(inserttime)){
//			map.put("statTime", inventoryStat.getInTimeStart());
//			if("1".equals(inventoryStat.getMortgageType())){
//				inventoryStatLists2 =inventoryStatDao.queryHouseInventoryStatList(map,page);
//			}
//			if("2".equals(inventoryStat.getMortgageType())){
//				inventoryStatLists2 =inventoryStatDao.queryCarInventoryStatList(map,page);
//			}
//		}else{
//			inventoryStatLists2 =inventoryStatDao.queryInventoryStatListByTable(map,page);
//		}
		


				return inventoryStatLists2;
	}
	
	@Override
	public List<InventoryStat> queryInventoryStatListForExcel(MUOUserSession muo, InventoryStat inventoryStat) {
		Map<String, Object>map=new HashMap<String, Object>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Date d=new Date();
	//	List<InventoryStat> inventoryStatLists=new ArrayList<InventoryStat>();
		
		List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
		
		String orgcode = muo.getOrgcode();
		    //押品类型
			if (inventoryStat.getMortgageType() !=null&&!"".equals(inventoryStat.getMortgageType())) {
				if("1".equals(inventoryStat.getMortgageType())){
					map.put("mortgageType", "房产");
				}
				if("2".equals(inventoryStat.getMortgageType())){
					map.put("mortgageType", "机动车");
				}
			}	

			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			String inserttime = sdf2.format(d);
			
			if (inventoryStat.getInTimeStart() !=null&&!"".equals(inventoryStat.getInTimeStart())) {
				try {
					map.put("inTimeStart", sdf1.format(sdf.parse(inventoryStat.getInTimeStart())));
					
					if (inventoryStat.getInTimeEnd() !=null&&!"".equals(inventoryStat.getInTimeEnd())) {
				   //	map.put("statTime", sdf1.format(sdf.parse(inventoryStat.getStatTime())));
						map.put("inTimeEnd", sdf1.format(sdf.parse(inventoryStat.getInTimeEnd())));
						if(inventoryStat.getInTimeStart().equals(inventoryStat.getInTimeEnd()) && sdf1.format(sdf.parse(inventoryStat.getInTimeStart())).equals(inserttime)){
						//如果开始时间等于结束时间,并且是当天时间	
							map.put("statTime", sdf1.format(sdf.parse(inventoryStat.getInTimeStart())));
							if("1".equals(inventoryStat.getMortgageType())){
								inventoryStatLists2 =inventoryStatDao.queryHouseInventoryStatListForExcel(map);
							}
							if("2".equals(inventoryStat.getMortgageType())){
								inventoryStatLists2 =inventoryStatDao.queryCarInventoryStatListForExcel(map);
							}
						}else{
							inventoryStatLists2 =inventoryStatDao.queryInventoryStatListByTableForExcel(map);
						}
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
		    }else{
		    	try {
					map.put("statTime", sdf1.format(sdf.parse(inventoryStat.getStatTime())));
				} catch (ParseException e) {
					e.printStackTrace();
				}
		    	inventoryStatLists2 =inventoryStatDao.queryInventoryStatListForExcel(map);
		    }
			
//			try {
//			if(inventoryStat.getInTimeStart() !=null&&!"".equals(inventoryStat.getInTimeStart())){
//				map.put("inTimeStart", sdf1.format(sdf.parse(inventoryStat.getInTimeStart())));
//			}
//			if (inventoryStat.getInTimeEnd() !=null&&!"".equals(inventoryStat.getInTimeEnd())) {
//				map.put("inTimeEnd", sdf1.format(sdf.parse(inventoryStat.getInTimeEnd())));
//			}
//			//如果开始时间等于结束时间,并且是当天时间
//			if(inventoryStat.getInTimeStart().equals(inventoryStat.getInTimeEnd()) && sdf1.format(sdf.parse(inventoryStat.getInTimeStart())).equals(inserttime)){
//				map.put("statTime", sdf1.format(sdf.parse(inventoryStat.getInTimeStart())));
//				if("1".equals(inventoryStat.getMortgageType())){
//					inventoryStatLists2 =inventoryStatDao.queryHouseInventoryStatListForExcel(map);
//				}
//				if("2".equals(inventoryStat.getMortgageType())){
//					inventoryStatLists2 =inventoryStatDao.queryCarInventoryStatListForExcel(map);
//				}
//			}else{
//				inventoryStatLists2 =inventoryStatDao.queryInventoryStatListByTableForExcel(map);
//			}
//			
//			if(inventoryStat.getStatTime() !=null&&!"".equals(inventoryStat.getStatTime())){
//				map.put("statTime", sdf1.format(sdf.parse(inventoryStat.getStatTime())));
//				inventoryStatLists2 =inventoryStatDao.queryInventoryStatListForExcel(map);
//			}
//			  } catch (ParseException e) {
//				e.printStackTrace();
//			}
//			
			
		
		return inventoryStatLists2;
	}
	
	
	/**
     * 去除重复的字符串
     * @param li 字符串集合
     * @return
     */
    public static List<String> getNewList(List<String> li){
    	List<String> list = new ArrayList<String>();
             for(int i=0;i<li.size();i++){
    	      String str = li.get(i); //获取传入集合对象的每一个元素
               if(!list.contains(str)){ //查看新集合中是否有指定的元素，如果没有则加入
                    list.add(str);
                    }
               }
             return list;//返回集合
             }

	@Override
	public boolean insertInventoryStat(MUOUserSession muo) {
		List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
		
		InventoryStat inventoryStat = new InventoryStat();
		InventoryStat delinventoryStat = new InventoryStat();
		InventoryStat inventoryStat2 = new InventoryStat();
		Date d=new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		String inserttime = sdf2.format(d);
		String delStatTime = sdf3.format(d);
		inventoryStat.setStatTime(inserttime);
		//保存要删除的某天的时间
		delinventoryStat.setStatTime(delStatTime);
		//实时获取当前的库存统计
		inventoryStatLists2=queryInventoryStatListForExcel(muo,inventoryStat);
		
		//删除数据库表中当天的库存统计数据
		inventoryStatDao.deleteNowInventoryStat(delinventoryStat);
		
		boolean result=false;
		for(int i=0;i<inventoryStatLists2.size();i++){
			Map<String, Object>map=new HashMap<String, Object>();
			inventoryStat2=inventoryStatLists2.get(i);
			try {
				map.put("statTime", inventoryStat2.getStatTime());
				map.put("mortgageType", inventoryStat2.getMortgageType());
				map.put("warrantsType", inventoryStat2.getWarrantsType());
				map.put("loanType", inventoryStat2.getLoanType());
				map.put("otherType", inventoryStat2.getOtherType());
				map.put("num", inventoryStat2.getNum());
				result=inventoryStatDao.insertInventoryStat(map);
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}
		}			
		return result;
	}

	@Override
	public List<InventoryStat> queryInventoryStatListByTable(
			MUOUserSession muo, InventoryStat inventoryStat, Page page) {
            List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
		
		Map<String, Object>map=new HashMap<String, Object>();
		
		
		Date d=new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String inserttime = sdf2.format(d);
		//统计时间
		if (inventoryStat.getStatTime() !=null&&!"".equals(inventoryStat.getStatTime())) {
			map.put("statTime", inventoryStat.getStatTime());
	    }else{
	    	map.put("statTime", inserttime);
	    }
				
		inventoryStatLists2 =inventoryStatDao.queryInventoryStatListByTable(map,page);
		return inventoryStatLists2;
	}

	@Override
	public List<InventoryStat> queryInventoryStatListByTableForExcel(
			MUOUserSession muo, InventoryStat inventoryStat) {
		 List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
			
			Map<String, Object>map=new HashMap<String, Object>();
			
			
			Date d=new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			String inserttime = sdf2.format(d);
			//统计时间
			if (inventoryStat.getStatTime() !=null&&!"".equals(inventoryStat.getStatTime())) {
				map.put("statTime", inventoryStat.getStatTime());
		    }else{
		    	map.put("statTime", inserttime);
		    }
					
			inventoryStatLists2 =inventoryStatDao.queryInventoryStatListByTableForExcel(map);
			return inventoryStatLists2;
	}

}
