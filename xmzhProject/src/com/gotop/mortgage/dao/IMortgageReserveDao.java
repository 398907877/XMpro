package com.gotop.mortgage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gotop.file.model.TFileResourceTable;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveRes;
import com.gotop.mortgage.model.WarrantsFile;
import com.primeton.utils.Page;

public interface IMortgageReserveDao {
	/**
	 * 查询抵押品库存
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveList(Map<String, Object> map, Page page);
	
	
	

	/**
	 * 查询权证信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	MortgageReserve queryMortgageReserveListInfo(Map<String, Object> map);
	
	
	/**
	 * 查询房产抵押品详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveHouse> queryMortgageReserveListHouseInfo(Map<String, Object> map);
	
	
	/**
	 * 查询机动车抵押品详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveCar> queryMortgageReserveListCarInfo(Map<String, Object> map);
	
	
	
	/**
	 * 检验 他项权证号是否已存在
	 */
	String checkOtherWarrantsNumber(Map<String, Object> map);
	
	/**
	 * 插入权证信息
	 * @param map
	 * @return
	 */
	boolean insertMortgage(Map<String, Object> map);
	
	/**
	 * 插入房产押品信息
	 * @param map
	 * @return
	 */
	boolean insertMortgageHouse(Map<String, Object> map);
	
	/**
	 * 插入机动车押品信息
	 * @param map
	 * @return
	 */
	boolean insertMortgageCar(Map<String, Object> map);
	
	/**
	 * 插入操作日志信息
	 * @param map
	 * @return
	 */
	boolean insertMortgageLog(Map<String, Object> map);
	
	/**
	 * 查询序列值
	 * @param seqName
	 * @return
	 * @throws Exception
	 */
	public long getNextSeqVal(HashMap<String,String> hmp) throws Exception;
	
	/**
	 * 插入权证上传文件信息
	 * @param map
	 * @return
	 */
	boolean insertMortgageFile(Map<String, Object> map);

	/**
	 * 根据主键和类型获得文件信息
	 * @param id
	 * @param resourceType
	 * @return
	 */
	List<WarrantsFile> queryFileByIdandType(Long id);
	
	/**
	 * 根据主键获得文件信息
	 * @param fileId
	 * @return
	 */
	public WarrantsFile getFileResource(String fileId);
}
