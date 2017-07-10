package com.gotop.mortgage.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.gotop.mortgage.dao.IScanDao;
import com.gotop.mortgage.model.Scan;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.util.dataSource.SqlMapClientDao;
import com.primeton.utils.Page;

public class ScanDao extends SqlMapClientDao implements IScanDao {
	protected static Logger log = Logger.getLogger(ScanDao.class);
	/**
	 * 新增扫描件
	 * @param scan 待新增的扫描件信息
	 * @return 新增的条数
	 * @throws Exception
	 */
	public int insertScan(Scan scan) throws Exception{
		this.insert("T_Scan_Management_SqlMap.addScan", scan);
		int count = 0;
		count++;
		return count;
}
	@Override
	public List<Scan> queryScanList(Map<String, Object> map, Page page) {
		
		return this.queryForList("T_Scan_Management_SqlMap.queryScanList", map,page);
	}
	@Override
	public Scan queryScan(Scan scan) {
		return  (Scan)this.queryForObject("T_Scan_Management_SqlMap.queryScan", scan);
	}
}