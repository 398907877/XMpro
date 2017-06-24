package com.gotop.mortgage.service;

import java.io.Serializable;
import java.util.List;

import com.gotop.mortgage.model.Scan;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.gotop.vo.system.MUOUserSession;
import com.primeton.utils.Page;

public interface IScanService extends Serializable {
	/**
	 * 新增扫描件
	 * @param scan 待新增的扫描件信息
	 * @return 新增的条数
	 * @throws Exception
	 */
	public int insertScan(Scan scan,MUOUserSession muo) throws Exception;
	
	/**
	 * 扫描件查询
	 * @param muo 
	 * @param scan
	 * @param page
	 * @return
	 */
	List<Scan> queryScanList(MUOUserSession muo, Scan scan, Page page);
	/**
	 * 根据scanID查询Scan
	 * @param scan
	 * @return
	 */
	Scan queryScan(Scan scan);
	
	//插入日志
	public boolean insertMortgageOperatingLog(String operatingType,Long userID,String inserttime,String remark) throws Exception;
}
