package com.gotop.mortgage.service.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.mortgage.dao.IMortgageReserveDao;
import com.gotop.mortgage.dao.IScanDao;
import com.gotop.mortgage.model.Scan;
import com.gotop.mortgage.service.IScanService;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.util.string.Obj2StrUtils;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public class ScanService implements IScanService,Serializable {
	private static final long serialVersionUID = 1397357119507270645L;
	protected static Logger log = Logger.getLogger(ScanService.class);
	private IScanDao scanDao;
	
	private IMortgageReserveDao mortgageReserveDao;
	public IMortgageReserveDao getMortgageReserveDao() {
		return mortgageReserveDao;
	}
	public void setMortgageReserveDao(IMortgageReserveDao mortgageReserveDao) {
		this.mortgageReserveDao = mortgageReserveDao;
	}
	public IScanDao getScanDao() {
		return scanDao;
	}

	public void setScanDao(IScanDao scanDao) {
		this.scanDao = scanDao;
	}

	/**
	 * 新增扫描件
	 * @param scan 待新增的扫描件
	 * @return 新增的条数
	 * @throws Exception
	 */
	public int insertScan(Scan scan,MUOUserSession muo) throws Exception{
		HashMap<String, String>hmp=new HashMap<String, String>();
		
//		Date d=new Date();
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmss");
//		String inserttime = sdf2.format(d);
//		
//		//上传时间
//		//scan.setOperationTime(inserttime);
//		//如果上传时间为空，默认当前时间
//		if(scan.getOperationTime() ==null || "".equals(scan.getOperationTime())){
//			scan.setOperationTime(inserttime);
//		}
		
		boolean result=false;
		int count=0;
		try {
		//新增扫描件上传
		 count = this.getScanDao().insertScan(scan);
		
		
//		//获取当前用户id
//		Long userID=muo.getEmpid();
//		
//		//插入成功
//		if(count > 0){
//			String operatingType="6";//扫描件上传
//			//插入日志
//			result=insertMortgageOperatingLog(operatingType, userID, inserttime, "扫描件上传");
//			if(!result){
//				count=0;
//			}
//		}
		} catch (Exception e) {
			count=0;
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 插入日志表信息
	 * @param operatingType 操作类型
	 * @param userID   操作人员id
	 * @param pkey    操作主表ID
	 * @param inserttime  插入时间与插入信息时间保持一致
	 * @param remark  备注
	 * @return
	 * @throws Exception
	 */
	public boolean insertMortgageOperatingLog(String operatingType,Long userID,String inserttime,String remark) throws Exception{
		Map<String, Object>map=new HashMap<String, Object>();
		boolean result=false;
		try {
			map.put("inserttime", inserttime);
			map.put("userID", userID);
			map.put("operatingType", operatingType);
			map.put("remark", remark);
			result=mortgageReserveDao.insertMortgageLog(map);
		} catch (Exception e) {
			result=false;
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Scan> queryScanList(MUOUserSession muo, Scan scan, Page page) {
		
		Map<String, Object>map=new HashMap<String, Object>();
		
		
		Date d=new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String inserttime = sdf2.format(d);
		
		if (scan.getInTimeStart() !=null&&!"".equals(scan.getInTimeStart())) {
				map.put("inTimeStrat", scan.getInTimeStart());
		}//else{
			//map.put("inTimeStrat", inserttime);
		//}
		
		if (scan.getInTimeEnd() !=null&&!"".equals(scan.getInTimeEnd())) {
				map.put("inTimeEnd",  scan.getInTimeEnd());
		}//else{
		//	map.put("inTimeEnd",  inserttime);
		//}
		//扫描件种类
		if(scan.getScanType()!=null && !"".equals(scan.getScanType())){
			map.put("scanType", scan.getScanType());
		}	
		
		List<Scan> scanLists =scanDao.queryScanList(map,page);
		
		return scanLists;
	}

	@Override
	public Scan queryScan(Scan scan) {
		
		return scanDao.queryScan(scan);
	}
}
