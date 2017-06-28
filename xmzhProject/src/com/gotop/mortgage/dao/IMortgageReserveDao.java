package com.gotop.mortgage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.gotop.mortgage.model.MortgageReserve;
import com.gotop.mortgage.model.MortgageReserveCar;
import com.gotop.mortgage.model.MortgageReserveHouse;
import com.gotop.mortgage.model.MortgageReserveOut;
import com.gotop.mortgage.model.MortgageReserveRes;
import com.gotop.mortgage.model.MortgageReserveUpdLog;
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
	 * 查询抵押品房产类型库存导出
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveListExcel(Map<String, Object> map);
	
	
	/**
	 * 查询抵押品机动车类型库存导出
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveListCarExcel(Map<String, Object> map);

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
	 * 检验 库存序号是否已存在
	 * @param mortgageReserve
	 * @return
	 */
	String checkProjectNumber(Map<String, Object> map);
	
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
	

	/**
	 * 修改权证信息
	 * @param map
	 * @return
	 */
	boolean updMortgage(Map<String, Object> map);
	
	/**
	 * 修改房产押品信息
	 * @param map
	 * @return
	 */
	boolean updMortgageHouse(Map<String, Object> map);
	
	/**
	 * 修改机动车押品信息
	 * @param map
	 * @return
	 */
	boolean updMortgageCar(Map<String, Object> map);

	/**
	 * 查询房产类型押品信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveHouseList(Map<String, Object> map);

	/**
	 * 查询机动车类型押品信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryMortgageReserveCarList(Map<String, Object> map);
	

	/**
	 * 出入库处理信息
	 * @param map
	 * @return
	 */
	boolean insertMortgageReserveOutMap(Map<String, Object> map);
	
	/**
	 * 检验机动车登记证号是否已存在
	 */
	String checkCarRegisterNo(Map<String, Object> map);
	
	/**
	 * 查询机构号
	 * @param map
	 * @return
	 */
	public List<MortgageReserve> queryOrgs(Map<String, Object> map);
	
	/**
	 * 检验 他项权证号是否已存在
	 * @param mortgageReserve
	 * @return
	 */
	String checkIsLog(Map<String, Object> map);
	
	
	/**
	 * 生成权证信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	MortgageReserve openGenerate(Map<String, Object> map);
	
	/**
	 * 查询出入库信息
	 * @param map
	 * @return
	 */
	public MortgageReserveOut showBorrowerNums(Map<String, Object> map);
	
	/**
	 * 注销、同注同抵产权数量归0
	 * @param map
	 * @return
	 */
	void updMortgageHouseNums(Map<String, Object> map);
	
	/**
	 * 修改权证信息状态
	 * @param map
	 * @return
	 */
	void updMortgageStatus(Map<String, Object> map);
	
	/**
	 * 注销后抵质押品状态
	 * @param map
	 * @return
	 */
	void updMortgageAfterMortgageStatus(Map<String, Object> map);
	
	/**
	 * 更新出入库流水表的状态
	 * @param map
	 * @return
	 */
	void updMortgageOutIn(Map<String, Object> map);
	
	/**
	 * 出入库信息详情房产类型
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryOutInHouseList(Map<String, Object> map);
	/**
	 * 出入库信息详情房产类型
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveRes> queryOutInCarList(Map<String, Object> map);
	
	/**
	 * 插入变更操作日志信息
	 * @param map
	 * @return
	 */
	void insertMortgageUpdLog(Map<String, Object> map);
	
	
	/**
	 * 判断记录表是否有值
	 * @param map
	 * @return
	 */
	public String checkIsUpdLog(Map<String, Object> map);
	
	/**
	 * 插入变更操作日志信息
	 * @param map
	 * @return
	 */
	void insertMortgageUpdLogSelect(Map<String, Object> map);
	
	
	/**
	 * 查询机动车类型押品信息详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	List<MortgageReserveUpdLog> queryDetailColl(Map<String, Object> map, Page page);
	

	/**
	 * 权证状态详情
	 * @param mortgageReserve
	 * @param page
	 * @return
	 */
	public MortgageReserveRes showStatus(Map<String, Object> map);
}
