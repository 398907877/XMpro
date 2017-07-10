package com.gotop.mortgage.dao;

import java.util.List;
import java.util.Map;

import com.gotop.mortgage.model.Scan;
import com.gotop.reportjbpm.model.BjErrorNumReport;
import com.primeton.utils.Page;

public interface IScanDao {
	/**
	 * 新增扫描件
	 * @param scan 待新增的扫描件信息
	 * @return 新增的条数
	 * @throws Exception
	 */
	public int insertScan(Scan scan) throws Exception;
	
	/**
	 * 扫描件查询
	 * @param map
	 * @param page
	 * @return
	 */
	List<Scan> queryScanList(Map<String, Object> map, Page page);
	
	/**
	 * 根据ID获取扫描件
	 * @param map
	 * @param page
	 * @return
	 */
	Scan queryScan(Scan scan);
}
