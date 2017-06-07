package com.gotop.mortgage.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

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
	public int insertScan(Scan scan) throws Exception{
		return this.getScanDao().insertScan(scan);
	}
	
	@Override
	public List<Scan> queryScanList(MUOUserSession muo, Scan scan, Page page) {
		
		Map<String, Object>map=new HashMap<String, Object>();
		
		
		if (scan.getInTimeStart() !=null&&!"".equals(scan.getInTimeStart())) {
				map.put("inTimeStrat", scan.getInTimeStart());
		}
		
		if (scan.getInTimeEnd() !=null&&!"".equals(scan.getInTimeEnd())) {
				map.put("inTimeEnd",  scan.getInTimeEnd());
		}
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
