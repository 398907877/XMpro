package com.gotop.mortgage.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<InventoryStat> inventoryStatLists=new ArrayList<InventoryStat>();
		
		List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
		
		Map<String, Object>map=new HashMap<String, Object>();
		
//		//统计时间
//		if (inventoryStat.getStatTime() !=null&&!"".equals(inventoryStat.getStatTime())) {
//			map.put("statTime", inventoryStat.getStatTime());
//	    }
//		
//		
//		List<InventoryStat> inventoryStatLists =inventoryStatDao.queryInventoryStatList(map,page);
		
		if (inventoryStat.getStatTime() !=null&&!"".equals(inventoryStat.getStatTime())) {
					
						map.put("statTime",inventoryStat.getStatTime());
						inventoryStatLists2 =inventoryStatDao.queryInventoryStatList(map,page);
					}else{
						//获取表中所有的时间（包含去除重复）
						inventoryStatLists =inventoryStatDao.queryTimeList(map);
						ArrayList<String> arr = new ArrayList<String>();
						int n=0;
						if(inventoryStatLists!=null){
							
							for(InventoryStat vcc:inventoryStatLists){
								arr.add(vcc.getStatTime());
							}
							//去除重复
							arr = (ArrayList<String>) getNewList(arr);
							
							//遍历所有时间  以每个时间统计数据
							for(int i=0;i<arr.size();i++){
								String str=arr.get(i);
								map.put("statTime", str);
								inventoryStatLists =inventoryStatDao.queryInventoryStatListForExcel(map);
								inventoryStatLists2.addAll(inventoryStatLists);
								n+=inventoryStatLists.size();
							}
							
						}
						page.setCount(n);
					}	
				return inventoryStatLists2;
	}
	
	@Override
	public List<InventoryStat> queryInventoryStatListForExcel(MUOUserSession muo, InventoryStat inventoryStat) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<InventoryStat> inventoryStatList=new ArrayList<InventoryStat>();
		Map<String, Object>map=new HashMap<String, Object>();
		
		List<InventoryStat> inventoryStatLists=new ArrayList<InventoryStat>();
		
		List<InventoryStat> inventoryStatLists2=new ArrayList<InventoryStat>();
		
		String orgcode = muo.getOrgcode();
		
		//统计时间
		try {
				if (inventoryStat.getStatTime() !=null&&!"".equals(inventoryStat.getStatTime())) {
					
						map.put("statTime", sdf1.format(sdf.parse(inventoryStat.getStatTime())));
						inventoryStatLists2 =inventoryStatDao.queryInventoryStatListForExcel(map);
					}else{
						inventoryStatLists =inventoryStatDao.queryTimeList(map);
						ArrayList<String> arr = new ArrayList<String>();
						if(inventoryStatLists!=null){
							
							for(InventoryStat vcc:inventoryStatLists){
								arr.add(vcc.getStatTime());
							}
							arr = (ArrayList<String>) getNewList(arr);
							for(int i=0;i<arr.size();i++){
								String str=arr.get(i);
								map.put("statTime", str);
								inventoryStatLists =inventoryStatDao.queryInventoryStatListForExcel(map);
								inventoryStatLists2.addAll(inventoryStatLists);
							}
							
						}
					}
			    }
		catch (ParseException e) {
			e.printStackTrace();
		}	
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
}
